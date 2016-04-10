package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.location.GameMap;
import model.location.Location;
import model.location.NonColonyLocation;
import model.user.Player;

@WebServlet("/CleanSavedInfoServlet")
public class CleanSavedInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		Player player = (Player) request.getSession().getAttribute("player");
		GameMap map = (GameMap) request.getSession().getAttribute("map");
		
		endGame(player, map);
		request.getSession().removeAttribute("player");
		request.getSession().removeAttribute("map");
		request.getSession().removeAttribute("result");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void endGame(Player player, GameMap map){
		removeSurvivorsFromTheGameMap(map); // TODO
		removeZombiesFromTheMap(map);
		removeItemsFromTheMap(map);
		removeFoodSupplyFromTheColony(map);
		removeWastePileFromTheColony(map);
		removeCrisisContributionCardsFromTheColony(map);
		resetSurvivorSruff();
		
		removePlayerStuff(player);
		
	}

	private void resetSurvivorSruff() {
		// todo ???
	}

	private void removePlayerStuff(Player player) {
		player.setMainObjective(null);
		player.setSecretObjective(null);
		player.setAllCrisis(null);
		player.setCurrentCrisis(null);
		player.getPlayerItems().clear();
		player.getSurvivors().clear();
		player.setMorale(0);
		player.setRound(0);
		player.getRolledDice().clear();
		player.getLog().clear();		
	}

	private void removeCrisisContributionCardsFromTheColony(GameMap map) {
		map.getColony().resetCrisisContributionCards();
	}

	private void removeWastePileFromTheColony(GameMap map) {
		map.getColony().resetWastePile();
	}

	private void removeFoodSupplyFromTheColony(GameMap map) {
		map.getColony().setFoodSupply(0);
	}

	private void removeItemsFromTheMap(GameMap map) {
		for (int i = 0; i < map.getMap().size(); i++) {
			if (map.getMap().get(i) instanceof NonColonyLocation) {
				NonColonyLocation location = (NonColonyLocation) map.getMap().get(i);
				location.getItems().clear();
				location.generateItemsInLocation();
			}
		}
	}

	private void removeZombiesFromTheMap(GameMap map) {
		for (int i = 0; i < map.getMap().size(); i++) {
			Location location = map.getMap().get(i);
			
			for (int j = 0; j < location.getEntrance().getPlaces().size(); j++) {
				if (location.getEntrance().getPlaces().get(j).isOccupied()) {
					location.getEntrance().getPlaces().get(j).setOccupant(null);
				}
			}
		}
	}

	private void removeSurvivorsFromTheGameMap(GameMap map) {
		for (int i = 0; i < map.getMap().size(); i++) {
			map.getMap().get(i).getSurvivors().clear();
		}
	}

}
