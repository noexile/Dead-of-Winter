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

import model.ability.Ability;
import model.card.Item;
import model.card.PlayerCard;
import model.card.SurvivorCard;
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
		String dice = request.getParameter("picked_dice");
		
		ArrayList<Survivor> survivors = (ArrayList<Survivor>) request.getSession().getAttribute("survivors");
		System.out.println(survivors.size());
		

		System.out.println(survivorName);
		List<Survivor> playerSurvivors = player.getSurvivors();
		System.out.println(player.getSurvivors().size());
		Survivor pickedSurvivor = getSurvivor(survivorName ,playerSurvivors);
		survivors.removeAll(playerSurvivors);
		System.out.println(survivors.size());
		

		System.out.println("search servlet picked dice: " + dice);
		if (dice == null || dice.trim().isEmpty()) {
			request.getSession().setAttribute("searchError", "No dice selected for searching!");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		} else if(Integer.valueOf(dice) < pickedSurvivor.getAttackValue()) {
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

		System.out.println(searchingLocation);
		
		
		
		if(searchingLocation instanceof NonColonyLocation){
			Random rand = new Random();
			int rn = rand.nextInt(survivors.size());
			Survivor s = survivors.get(rn);
			System.out.println(((NonColonyLocation) searchingLocation).getItems().size());
			System.out.println(s.getName());
			((NonColonyLocation) searchingLocation).getItems().add(new SurvivorCard(s.getName(),null, Item.Type.SURVIVOR, s.getLink()));
			if(((NonColonyLocation)searchingLocation).getItems().size()==0){
				request.getSession().setAttribute("searchError", "Sorry no more cards in this location");
				request.getRequestDispatcher("boardgame.jsp").forward(request, response);
				return;
			}
			System.out.println(((NonColonyLocation) searchingLocation).getItems().size());
			int value = rand.nextInt(((NonColonyLocation)searchingLocation).getItems().size());
			System.out.println(((NonColonyLocation) searchingLocation).getItems().get(value).getName());
			if(!(((NonColonyLocation) searchingLocation).getItems().get(value).getType().equals(Item.Type.SURVIVOR.toString().toLowerCase())))
				player.getPlayerItems().add(((NonColonyLocation) searchingLocation).getItems().get(value));
			else{
				player.getSurvivors().add(s);
				map.getColony().getSurvivors().add(s);
			}
			request.getSession().setAttribute("searchMsg", "You found " + ((NonColonyLocation) searchingLocation).getItems().get(value).getName());
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
