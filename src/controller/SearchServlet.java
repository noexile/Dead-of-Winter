package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.card.Item;
import model.card.PlayerCard;
import model.card.playercards.Food1;
import model.card.playercards.Fuel;
import model.card.playercards.Junk;
import model.card.playercards.Medicine;
import model.character.Survivor;
import model.location.GameMap;
import model.location.Location;
import model.location.NonColonyLocation;
import model.user.Player;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IM IN THE SERVLET");
		Player player = (Player) request.getSession().getAttribute("player");		
		GameMap map = (GameMap) request.getSession().getAttribute("map");
		String survivorName = request.getParameter("selected_survivor");
		
		final int STARTING_MEDICINE_CARDS = 3;
		final int STARTING_FOOD1_CARDS = 3;
		final int STARTING_JUNK_CARDS = 2;
		final int STARTING_FUEL_CARDS = 2;

		System.out.println(survivorName);
		List<Survivor> playerSurvivors = player.getSurvivors();
		System.out.println(player.getSurvivors().size());
		Survivor pickedSurvivor = getSurvivor(survivorName ,playerSurvivors);
		
		
		Location searchingLocation = pickedSurvivor.getCurrentLocation();

		System.out.println(searchingLocation);
		
		
		if(searchingLocation instanceof NonColonyLocation){
			if(((NonColonyLocation)searchingLocation).getItems().size()==0){
				((NonColonyLocation)searchingLocation).getItems().addAll(generatePlayerCards(STARTING_MEDICINE_CARDS, STARTING_FOOD1_CARDS, STARTING_JUNK_CARDS, STARTING_FUEL_CARDS));
			}
			Random rand = new Random(); 
			int value = rand.nextInt(((NonColonyLocation)searchingLocation).getItems().size());
			System.out.println(((NonColonyLocation) searchingLocation).getItems().get(value).getName());
			player.getPlayerItems().add(((NonColonyLocation) searchingLocation).getItems().get(value));
			((NonColonyLocation)searchingLocation).getItems().remove(value);
		}
		else{
			request.getSession().setAttribute("searchError", "You cant search in the colony");
		}
		
		

		request.getRequestDispatcher("boardgame.jsp").forward(request, response);
		
		
	}
	

	private Survivor getSurvivor(String survivorName, List<Survivor> playerSurvivors) {
		
		for (int i = 0; i < playerSurvivors.size(); i++) {
			if (playerSurvivors.get(i).getName().equals(survivorName)) {
				return playerSurvivors.get(i);
			}
		}
		return null;
	}

	private ArrayList<PlayerCard> generatePlayerCards(int STARTING_MEDICINE_CARDS, int STARTING_FOOD1_CARDS, int STARTING_JUNK_CARDS, int STARTING_FUEL_CARDS) {
		ArrayList<PlayerCard> playerCards = new ArrayList<PlayerCard>();
		
		// TODO Beans
		// ADD ABILITY TO ALL CARDS
		for (int i = 0; i < STARTING_MEDICINE_CARDS; i++) {
			playerCards.add(new Medicine(null)); 
		}
		
		for (int i = 0; i < STARTING_FOOD1_CARDS; i++) {
			playerCards.add(new Food1(null)); 
		}
		
		for (int i = 0; i < STARTING_JUNK_CARDS; i++) {
			playerCards.add(new Junk(null)); 
		}
		
		for (int i = 0; i < STARTING_FUEL_CARDS; i++) {
			playerCards.add(new Fuel(null)); 
		}
		
		return playerCards;
	}

}
