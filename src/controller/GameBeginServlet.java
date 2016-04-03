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

import model.card.CrisisCard;
import model.card.PlayerCard;
import model.location.Location;
import model.location.map.Colony;
import model.location.map.GasStation;
import model.location.map.GroceryStore;
import model.location.map.Hospital;
import model.location.map.Library;
import model.location.map.PoliceStation;
import model.location.map.School;
import model.user.Player;

@WebServlet("/GameBeginServlet")
public class GameBeginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Player player = (Player) request.getSession().getAttribute("player");
		ArrayList<PlayerCard> startingCards = (ArrayList<PlayerCard>) request.getSession().getAttribute("randomizedPlayerStartingCards");
		
		request.removeAttribute("playerStartingCards");
		request.removeAttribute("randomizedPlayerStartingCards");
		request.removeAttribute("randomizedPlayerStartingCardsPartOne");
		request.removeAttribute("randomizedPlayerStartingCardsPartTwo");
		
		player.setPlayerItems(startingCards);
		player.setMorale(player.getMainObjective().getStartingMorale());
		player.setRound(player.getMainObjective().getStartingRound());
		player.setCrisisCards(generateCrisisCards());
		
		player.getNextCrisisCard();
		System.out.println("current crisis card name: " + player.getCurrentCrisisCard().getName());
		System.out.println("current crisis card link: " + player.getCurrentCrisisCard().getLink());
		
		List<Location> map = generateMap();
		
		printPlayerCurrentStuff(player); // printing all stuff in the console for verification
		
		request.getSession().setAttribute("map", map);
		request.getSession().setAttribute("player", player);
		request.getRequestDispatcher("boardgame.jsp").forward(request, response);
	}

	private Queue<CrisisCard> generateCrisisCards() {
		List<CrisisCard> generatedCardsBeforeShuffle = new ArrayList<CrisisCard>();
		
		Queue<CrisisCard> generatedCrisisCards = new LinkedBlockingQueue<CrisisCard>();
		
		// TODO
		// fix the ability
		// fix the objective
		generatedCardsBeforeShuffle.add(new CrisisCard("Strength of the dead", null, null, "resources/strength_of_the_dead.png"));
		generatedCardsBeforeShuffle.add(new CrisisCard("Despair", null, null, "resources/despair.png"));
		generatedCardsBeforeShuffle.add(new CrisisCard("Legions of Death", null, null, "resources/legions_of_death.png"));
		generatedCardsBeforeShuffle.add(new CrisisCard("Overpopulation", null, null, "resources/overpopulation.png"));
		generatedCardsBeforeShuffle.add(new CrisisCard("Fuel Shortage", null, null, "resources/fuel_shortage.png"));
		generatedCardsBeforeShuffle.add(new CrisisCard("Illness", null, null, "resources/illness.png"));
		generatedCardsBeforeShuffle.add(new CrisisCard("Horror in the Night", null, null, "resources/horror_in_the_night.png"));
		generatedCardsBeforeShuffle.add(new CrisisCard("Zombie Surge", null, null, "resources/zombie_surge.png"));
		generatedCardsBeforeShuffle.add(new CrisisCard("Unending Hordes", null, null, "resources/unending_hordes.png"));
		
		Collections.shuffle(generatedCardsBeforeShuffle);
		Collections.shuffle(generatedCardsBeforeShuffle);
		
		for (int i = 0; i < generatedCardsBeforeShuffle.size(); i++) {
			generatedCrisisCards.offer(generatedCardsBeforeShuffle.get(i));
		}
		
		return generatedCrisisCards;
	}

	private ArrayList<Location> generateMap() {
		ArrayList<Location> generatedMap = new ArrayList<Location>();
		
		generatedMap.add(new Colony());
		generatedMap.add(new PoliceStation());
		generatedMap.add(new GroceryStore());
		generatedMap.add(new Hospital());
		generatedMap.add(new Library());
		generatedMap.add(new School());
		generatedMap.add(new GasStation());
		
		return generatedMap;
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
