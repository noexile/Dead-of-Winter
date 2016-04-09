package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.card.Item;
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
		
		// TESTED AND IS WORKING
		// 1. pay food
		int foodNeeded = map.getColony().getSurvivors().size();
		
		if (foodNeeded <= map.getColony().getFoodSupply()) {
			map.getColony().setFoodSupply(map.getColony().getFoodSupply() - foodNeeded);
			System.out.println("Fed " + foodNeeded + " food for the colonists to survive.");
		} else {
			player.loseMorale();
			System.out.println("You do not have enough food to feed your colonists!");
			System.out.println("You loose 1 morele!");
		}
		
		
		// TESTED AND IS WORKING
		// 2. check waste --> hard-coded waste supply. for every 10 items in the waste pile - loose 1 morale
		if (map.getColony().getWastePileSize() > 10) {
			int moraleLost = map.getColony().getWastePileSize() / 10;
			
			System.out.println("Wastepile is too big and smelly. There are " + moraleLost + " items as trash inside!");
			for (int i = 0; i < moraleLost; i++) {
				player.loseMorale();
			}
		}
		
		
		// TESTED AND IS WORKING
		// 3. resolve crisis
		if (player.getCurrentCrisis().getNeededCardsForCrisis() > map.getColony().getCrisisContributionCards()) {
			// LOSE CONDITION
			player.getCurrentCrisis().loseCrisisObjective(player, map);
			
			System.out.println("Failed resolving crisis!");			
		} else if((player.getCurrentCrisis().getNeededCardsForCrisis() + 2) <= map.getColony().getCrisisContributionCards()) {	
			// SAVE CONDITION
			player.getCurrentCrisis().meetCrisisObjective(player, map);
			System.out.println("Crisis resolved greatly! Nicely done!");
		} else {
			System.out.println("Crisis resolved barely!");
		}
		
		map.getColony().resetCrisisCards(); // resets the crisis contribution cards
		
		
		/// TESTED AND IS WORKING
		// 4. add Zombies
		addZombies(map, player);
		
		
		// TESTED AND IS WORKING
		// 5. check main objective
		boolean win = checkIfMainObjectiveGoalIsReached(player);
		if (win) {
			// check secret objective
			if (checkIfSecretObjectiveGoalIsReached(player)) {
				// TODO game win
				System.out.println("Ai chestito - specheli igrata!");
				request.getRequestDispatcher("EndGameServlet").forward(request, response);
				return;
			}
			
			// TODO lose
			System.out.println("Sorry pich - secreta ne si go izpulnil!");
			request.getRequestDispatcher("EndGameServlet").forward(request, response);
			return;
		}
		
		
		// TESTED AND IS WORKING	
		// 6. reset and update survivor properties
		for (int i = 0; i < player.getSurvivors().size(); i++) {
			Survivor currentSurvivor = player.getSurvivors().get(i);
			currentSurvivor.resetMove();
			
			if (currentSurvivor.isHasFrostBite()) {
				currentSurvivor.takeDamage();
				
				if (currentSurvivor.getReceivedDamage() >= Survivor.SURVIVOR_MAX_LIFE) {
					currentSurvivor.die();
				}
				
				if (!currentSurvivor.isAlive()) {
					System.out.println(currentSurvivor.getName() + " has died from frostbite!");
					removeTheDeadSurvivorFromTheGame(player, currentSurvivor);
					player.loseMorale();
				}
			}
		}
		
		
		// TESTED AND IS WORKING
		// 7. check morale
		if (player.getMorale() <= 0) {
			// TODO game lost
			System.out.println("Morale reached 0. Game lost!");
			request.getRequestDispatcher("EndGameServlet").forward(request, response);
			return;
		}
		
		
		// TESTED AND IS WORKING
		// 8. check number of survivors
		if (player.getSurvivors().size() == 0) {
			// TODO game lost
			System.out.println("All survivors are dead - gg wp!");
			request.getRequestDispatcher("EndGameServlet").forward(request, response);
			return;
		}
		
		
		// TESTED AND IS WORKING			
		// 9. move round token
		if ((player.getRound() - 1) == 0) {
			// TODO game lost
			System.out.println("Rounds reached 0 and the game conditions are not met. Game lost!");
			request.getRequestDispatcher("EndGameServlet").forward(request, response);
			return;
		} else {
			player.nextRound();
		}
		
		
		// TESTED AND IS WORKING		
		// 10. set new crisis card
		player.getNextCrisisCard();
		
		
		// TESTED AND IS WORKING		
		// 11. roll dice for player
		player.rollDice();
		
		
		System.out.println("tsatchets - all done!");
		request.getSession().setAttribute("player", player);
		request.getSession().setAttribute("map", map);
		request.getRequestDispatcher("boardgame.jsp").forward(request, response);
	}

	private boolean checkIfSecretObjectiveGoalIsReached(Player player) {
		if (player.getSecretObjective().getSecretObjectiveGoal().meetRequirements(player)) {
			return true;
		}
		return false;
	}

	private void addZombies(GameMap map, Player player) {
		Survivor lowestInfluenceSurvivor = null;
		
		for (int i = 0; i < map.getMap().size(); i++) {
			if (map.getMap().get(i).getSurvivors().size() > 0) {
				System.out.println(map.getMap().get(i).getLocationName() + " have " + map.getMap().get(i).getSurvivors().size() + " survivors");
				for (int j = 0; j < map.getMap().get(i).getSurvivors().size(); j++) {
					System.out.println("i am sadly here");
					System.out.println(map.getMap().get(i).getEntrance().getOcupiedPlaces() + " occupid places");
					if (map.getMap().get(i).getZombieLimit() > map.getMap().get(i).getEntrance().getOcupiedPlaces()) {
						for (int m = 0; m < map.getMap().get(i).getEntrance().MAX_FREE_PLACES; m++) {
							if (map.getMap().get(i).getEntrance().getPlaces().get(m).isOccupied()) {
								continue;
							}
							map.getMap().get(i).getEntrance().getPlaces().get(m).setOccupant(new Zombie());
							System.out.println("A zombie has entered in the " + map.getMap().get(i).getLocationName());
							break;
						}
					} else {
						System.out.println("i am here");
						lowestInfluenceSurvivor = getLowestInfluenceSurvivor(map.getMap().get(i));
						lowestInfluenceSurvivor.die();
					}
					
					if (lowestInfluenceSurvivor != null && !lowestInfluenceSurvivor.isAlive()) {
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
		
		System.out.println(location.getSurvivors().size());
		for (int i = 0; i < location.getSurvivors().size(); i++) {
			if (i == 0) {
				survivor = (Survivor) location.getSurvivors().get(i);
				System.out.println("1: " +survivor);
				continue;
			}
			
			if (((Survivor)location.getSurvivors().get(i)).getInfluence() < survivor.getInfluence()) {
				System.out.println("2: " +survivor);
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
