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
import model.interfaces.ISurvivorDao;
import model.interfaces.ISurvivorDao.DS;
import model.location.GameMap;
import model.location.Location;
import model.location.NonColonyLocation;
import model.user.Player;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		
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
			if(!(((NonColonyLocation) searchingLocation).getItems().get(value).getType().equalsIgnoreCase(Item.Type.SURVIVOR.toString().toLowerCase()))) {
				player.getPlayerItems().add(((NonColonyLocation) searchingLocation).getItems().get(value));
			} else {
				Survivor survivor = getSurvivor(((NonColonyLocation) searchingLocation).getItems().get(value).getName(), ISurvivorDao.getDAO(DS.DB).getSurvivors());
				System.out.println(player.getSurvivors().size() + " predi da se iztegli karta");
				player.getSurvivors().add(survivor);
				System.out.println(player.getSurvivors().size() + " sled kato se iztegli karta");
				GameMap.getColony().getSurvivors().add(survivor);
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
