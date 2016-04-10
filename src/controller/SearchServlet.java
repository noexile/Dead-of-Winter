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
       
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		resp.setHeader("Pragma", "no-cache");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Player player = (Player) request.getSession().getAttribute("player");		
		GameMap map = (GameMap) request.getSession().getAttribute("map");
		String survivorName = request.getParameter("selected_survivor");
		String dice = request.getParameter("picked_dice");
		List<Survivor> playerSurvivors = player.getSurvivors();
		Survivor pickedSurvivor = getSurvivor(survivorName, playerSurvivors);
		ArrayList<Survivor> survivors = (ArrayList<Survivor>) request.getSession().getAttribute("survivors");		
	
		

		if (dice == null || dice.trim().isEmpty()) {
			request.getSession().setAttribute("searchError", "No dice selected for searching!");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		} else if(Integer.valueOf(dice) < pickedSurvivor.getSearchValue()) {
			request.getSession().setAttribute("searchError", "The picked dice must have bigger value than the survivors' !");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		}
		
		for (int i = 0; i < player.getRolledDice().size(); i++) {
			if (player.getRolledDice().get(i).equals(Integer.valueOf(dice))) {
				player.getRolledDice().remove(i);
				break;
			}
		}
		
		Location searchingLocation = pickedSurvivor.getCurrentLocation();		
		
		if(searchingLocation instanceof NonColonyLocation){
			Random rand = new Random();
			if(((NonColonyLocation)searchingLocation).getItems().size()==0){
				request.getSession().setAttribute("searchError", "Sorry no more cards in this location");
				request.getRequestDispatcher("boardgame.jsp").forward(request, response);
				return;
			}
			int value = rand.nextInt(((NonColonyLocation)searchingLocation).getItems().size());
			if(!(((NonColonyLocation) searchingLocation).getItems().get(value).getType().equals(Item.Type.SURVIVOR.toString().toLowerCase())))
				player.getPlayerItems().add(((NonColonyLocation) searchingLocation).getItems().get(value));
			else{
				Survivor s = getSurvivor(((NonColonyLocation) searchingLocation).getItems().get(value).getName(), survivors);
				player.getSurvivors().add(s);
				map.getColony().getSurvivors().add(s);
			}

			player.addValueToLog(survivorName + " searches the " + searchingLocation.getLocationName()  + " and find " + ((NonColonyLocation) searchingLocation).getItems().get(value).getName());
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


}
