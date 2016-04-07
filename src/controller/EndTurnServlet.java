package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.character.Survivor;
import model.character.Zombie;
import model.location.GameMap;
import model.location.Location;
import model.user.Player;

@WebServlet("/EndTurnServlet")
public class EndTurnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Player player = (Player) request.getSession().getAttribute("player");
		GameMap map = (GameMap) request.getSession().getAttribute("map");
		
		// 1. pay food
		int foodNeeded = map.getColony().getSurvivors().size();
		
		if (foodNeeded >= map.getColony().getFoodSupply()) {
			map.getColony().setFoodSupply(map.getColony().getFoodSupply() - foodNeeded);
			System.out.println("Fed " + foodNeeded + " food for the colonists to survive.");
		} else {
			player.loseMorale();
			System.out.println("You do not have enough food to feed your colonists!");
			System.out.println("You loose 1 morele!");
		}
		
		
		// 2. check waste --> hard-coded waste supply. for every 10 items in the waste pile - loose 1 morale
		if (map.getColony().getWastePileSize() > 10) {
			int moraleLost = map.getColony().getWastePileSize() / 10;
			
			for (int i = 0; i < moraleLost; i++) {
				player.loseMorale();
			}
		}
		
		
		// 3. resolve crisis
		if (player.getCurrentCrisis().getNeededCardsForCrisis() > map.getColony().getCrisisContributionCards()) {
			// TODO
			// da se setne nyakakva mizeriika
			System.out.println("Failed resolving crisis!");
		} else if((player.getCurrentCrisis().getNeededCardsForCrisis() + 2) < map.getColony().getCrisisContributionCards()) {
			System.out.println("Crisis resolved greatly! Nicely done!");
			// TODO
			// da se setne nyakakva shukariika
		} else {
			System.out.println("Crisis resolved barely!");
		}
		
		map.getColony().resetCrisisCards(); // resets the crisis contribution cards
		
		
		// 4. add Zombies
		addZombies(map, player);
		
		
		// 5. check number of survivors
		if (player.getSurvivors().size() == 0) {
			// TODO game lost
			System.out.println("All survivors are dead - gg wp!");
			request.getRequestDispatcher("EndGameServlet").forward(request, response);
			return;
		}

		
		// 6. check main objective
		boolean win = checkIfMainObjectiveGoalIsReached(player);
		if (win) {
			// TODO game win
			System.out.println("Ai chestito - specheli igrata!");
			request.getRequestDispatcher("EndGameServlet").forward(request, response);
			return;
		}
		
		
		// 7. check morale
		if (player.getMorale() <= 0) {
			// TODO game lost
			System.out.println("Morale reached 0. Game lost!");
			request.getRequestDispatcher("EndGameServlet").forward(request, response);
			return;
		}
		

		// 8. reset and update survivor properties
		// if all of the survivors die because of frost bite forward to EndGameServlet
		for (int i = 0; i < player.getSurvivors().size(); i++) {
			Survivor currentSurvivor = player.getSurvivors().get(i);
			if (currentSurvivor.isHasFrostBite()) {
				currentSurvivor.takeDamage();
				currentSurvivor.resetMove();
				
				if (currentSurvivor.getReceivedDamage() >= Survivor.SURVIVOR_MAX_LIFE) {
					currentSurvivor.die();
				}
				
				if (!currentSurvivor.isAlive()) {
					System.out.println(currentSurvivor.getName() + " has died because of zombie breach");
					removeTheDeadSurvivorFromTheGame(player, currentSurvivor);
				}
			}
		}
		
		
		// 9. move round token
		if ((player.getRound() - 1) == 0) {
			// TODO game lost
			System.out.println("Rounds reached 0. Game lost!");
			request.getRequestDispatcher("EndGameServlet").forward(request, response);
			return;
		}
		
		
		// 10. set new crisis card
		player.getNextCrisisCard();
		
		
		// 11. roll dice for player
		player.rollDice();
		
		
		System.out.println("tsatchets - all done!");
		request.getSession().setAttribute("player", player);
		request.getSession().setAttribute("map", map);
		request.getRequestDispatcher("boardgame.jsp").forward(request, response);
	}

	private void addZombies(GameMap map, Player player) {
		Survivor lowestInfluenceSurvivor = null;
		
		for (int i = 0; i < map.getMap().size(); i++) {
			if (map.getMap().get(i).getSurvivors().size() > 0) {
				
				for (int j = 0; j < map.getMap().get(i).getSurvivors().size(); j++) {
					if (map.getMap().get(i).getZombieLimit() > map.getMap().get(i).getEntrance().getZombieCounter()) {
						map.getMap().get(i).getEntrance().getPlaces().get(map.getMap().get(i).getEntrance().getZombieCounter() - 1).setOccupant(new Zombie());
						System.out.println("A zombie has entered in the " + map.getMap().get(i).getLocationName());
						continue;
					} else {
						lowestInfluenceSurvivor = getLowestInfluenceSurvivor(map.getMap().get(i));
						lowestInfluenceSurvivor.die();
					}
					
					if (!lowestInfluenceSurvivor.isAlive()) {
						System.out.println(lowestInfluenceSurvivor.getName() + " has died because of zombie breach");
						removeTheDeadSurvivorFromTheGame(player, lowestInfluenceSurvivor);
					}
				}
				
			}
		}
	}

	private void removeTheDeadSurvivorFromTheGame(Player player, Survivor lowestInfluenceSurvivor) {
		for (int i = 0; i < lowestInfluenceSurvivor.getCurrentLocation().getSurvivors().size(); i++) {
			if (lowestInfluenceSurvivor.getCurrentLocation().getSurvivors().get(i).equals(lowestInfluenceSurvivor)) {
				lowestInfluenceSurvivor.getCurrentLocation().getSurvivors().remove(i);
				break;
			}
		}
		
		for (int i = 0; i < player.getSurvivors().size(); i++) {
			if (player.getSurvivors().get(i).equals(lowestInfluenceSurvivor)) {
				player.getSurvivors().remove(i);
				break;
			}
		}
	}

	private Survivor getLowestInfluenceSurvivor(Location location) {
		Survivor survivor = null;
		
		for (int i = 0; i < location.getSurvivors().size(); i++) {
			if (i == 0) {
				survivor = (Survivor) location.getSurvivors().get(i);
				continue;
			}
			
			if (((Survivor)location.getSurvivors().get(i)).getInfluence() < survivor.getInfluence()) {
				survivor = (Survivor) location.getSurvivors().get(i);
			}			
		}
		
		return survivor;
	}

	private boolean checkIfMainObjectiveGoalIsReached(Player player) {
		
		if (player.getMainObjective().getGoal().getZombieKills() >= player.getMainObjective().getGoal().getMaxZombieKills()) {
			return true;
		}
		
		return false;
	}

}
