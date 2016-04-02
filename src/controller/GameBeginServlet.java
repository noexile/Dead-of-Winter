package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.card.Card;
import model.card.Item;
import model.card.PlayerCard;
import model.card.playercards.Food1;
import model.card.playercards.Fuel;
import model.card.playercards.Junk;
import model.card.playercards.Medicine;
import model.location.Location;
import model.location.map.Colony;
import model.location.map.Everywhere;
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
		
		List<Location> map = generateMap();
		List<Item> itemCards = generateItems();
		// TODO crisis cards
		// TODO fix Secret Objective
		
		printPlayerCurrentStuff(player); // printing all stuff in the console for verification
		
		request.getSession().setAttribute("itemCards", itemCards);
		request.getSession().setAttribute("map", map);
		request.getSession().setAttribute("player", player);
		request.getRequestDispatcher("boardgame.jsp").forward(request, response);
	}

	private List<Item> generateItems() {
		ArrayList<Item> generatedItems = new ArrayList<Item>();
		
		//generated cards for printing in the player cards menu
		generatedItems.add(new Food1(null)); 
		generatedItems.add(new Fuel(null)); 
		generatedItems.add(new Medicine(null)); 
		generatedItems.add(new Junk(null)); 
		
		return generatedItems;
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
