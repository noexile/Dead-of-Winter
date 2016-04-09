package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.card.Item;
import model.character.Zombie;
import model.location.Entrance;
import model.location.GameMap;
import model.location.Location;
import model.location.map.Colony;
import model.location.map.GasStation;
import model.location.map.GroceryStore;
import model.location.map.Hospital;
import model.location.map.Library;
import model.location.map.PoliceStation;
import model.location.map.School;
import model.objective.Crisis;
import model.objective.crises.Despair;
import model.objective.crises.FuelShortage;
import model.objective.crises.HorrorInTheNight;
import model.objective.crises.Illness;
import model.objective.crises.LegionsOfDeath;
import model.objective.crises.Overpopulation;
import model.objective.crises.StrengthOfTheDead;
import model.objective.crises.UnendingHordes;
import model.objective.crises.ZombieSurge;
import model.user.Player;

@WebServlet("/GameBeginServlet")
public class GameBeginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Player player = (Player) request.getSession().getAttribute("player");
		ArrayList<Item> startingCards = (ArrayList<Item>) request.getSession().getAttribute("randomizedPlayerStartingCards");

		request.removeAttribute("playerStartingCards");
		request.removeAttribute("randomizedPlayerStartingCards");
		request.removeAttribute("randomizedPlayerStartingCardsPartOne");
		request.removeAttribute("randomizedPlayerStartingCardsPartTwo");
		
		player.setPlayerItems(startingCards);
		player.setMorale(player.getMainObjective().getSetUp().getStartingMorale());
		player.setRound(player.getMainObjective().getSetUp().getStartingRound());
		player.setAllCrisis(generateCrisis());
		
		player.getNextCrisisCard();
		System.out.println("current crisis card name: " + player.getCurrentCrisis().getName());
		System.out.println("current crisis card link: " + player.getCurrentCrisis().getLink());
		
		// generate the game Map
		GameMap map = new GameMap(Colony.getInstance(), PoliceStation.getInstance(), GroceryStore.getInstance(), School.getInstance(), Library.getInstance(), Hospital.getInstance(), GasStation.getInstance());
		
		// generate starting Zombies depending on chosen Main Objective
		for (int i = 0; i < map.getMap().size(); i++) {
			Location location = map.getMap().get(i);{
				for (int j = 0; j < player.getMainObjective().getSetUp().getStartingZombiesAtColony(); j++) {
					Entrance entrance = location.getEntrance();
					entrance.getPlaces().get(j).setOccupant(new Zombie());
					entrance.occupyPlace();
					System.out.println("Zombie occupies in colony " + location.getLocationName() + " link is = " + entrance.getPlaces().get(j).getOccupant().getLink());
				}
			}
		}
		
		// adding the survivors at the Colony at the start of the game
		for (int i = 0; i < player.getSurvivors().size(); i++) {
			map.getColony().getSurvivors().add(player.getSurvivors().get(i));
		}
		
		printPlayerCurrentStuff(player); // printing all stuff in the console for verification
		
		player.rollDice();

		request.getSession().setAttribute("map", map);
		request.getSession().setAttribute("player", player);
		request.getRequestDispatcher("boardgame.jsp").forward(request, response);
				
	}

	private Queue<Crisis> generateCrisis() {
		List<Crisis> generatedCardsBeforeShuffle = new ArrayList<Crisis>();
		
		Queue<Crisis> generatedCrisisCards = new LinkedBlockingQueue<Crisis>();
		
		generatedCardsBeforeShuffle.add(StrengthOfTheDead.getInstance());
		generatedCardsBeforeShuffle.add(Despair.getInstance());
		generatedCardsBeforeShuffle.add(LegionsOfDeath.getInstance());
		generatedCardsBeforeShuffle.add(FuelShortage.getInstance());
		generatedCardsBeforeShuffle.add(Overpopulation.getInstance());
		generatedCardsBeforeShuffle.add(Illness.getInstance());
		generatedCardsBeforeShuffle.add(HorrorInTheNight.getInstance());
		generatedCardsBeforeShuffle.add(ZombieSurge.getInstance());
		generatedCardsBeforeShuffle.add(UnendingHordes.getInstance());
		
		Collections.shuffle(generatedCardsBeforeShuffle);
		Collections.shuffle(generatedCardsBeforeShuffle);
		
		for (int i = 0; i < generatedCardsBeforeShuffle.size(); i++) {
			generatedCrisisCards.offer(generatedCardsBeforeShuffle.get(i));
		}
		
		return generatedCrisisCards;
	}

	private void printPlayerCurrentStuff(Player player) {
		System.out.println("Main objective: " + player.getMainObjective().getName());
		System.out.println("Secret objective: " + player.getSecretObjective().getSecretObjectiveGoal().getName());
		System.out.println("Player id: " + player.getId());
		System.out.println("Starting items:");
		for (int i = 0; i < player.getPlayerItems().size(); i++) {
			System.out.println("- " + player.getPlayerItems().get(i).getName());
		}
		System.out.println("Starting survivors:");
		for (int i = 0; i < player.getSurvivors().size(); i++) {
			System.out.println("- " + player.getSurvivors().get(i).getName());
		}
	}

}
