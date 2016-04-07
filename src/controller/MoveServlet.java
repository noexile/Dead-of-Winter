package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.card.Item;
import model.character.Survivor;
import model.location.GameMap;
import model.location.Location;
import model.user.Player;

@WebServlet("/MoveServlet")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String survivorName = request.getParameter("selected_survivor");
		String chosenLocationToMove = request.getParameter("selected_location_to_move");
		String useFuel = request.getParameter("use_fuel");
		
		Player player = (Player) request.getSession().getAttribute("player");		
		GameMap map = (GameMap) request.getSession().getAttribute("map");
		
		// TODO if has already moved this turn
		
		List<Survivor> playerSurvivors = player.getSurvivors();
		Survivor pickedSurvivor = getSurvivor(survivorName ,playerSurvivors);
		
		List<Location> mapLocations = map.getMap();
		Location survivorCurrentLocation = pickedSurvivor.getCurrentLocation();
		Location pickedLocation = getLocation(chosenLocationToMove, mapLocations);
		
		System.out.println("---");
		System.out.println("Picked survivor: " + pickedSurvivor.getName()); // printing the survivor that moves
		System.out.println("Picked location: " + pickedLocation.getLocationName()); // printing the chosen location to move
		System.out.println("---");
		
		if (pickedSurvivor.getCurrentLocation().getLocationName().equals(chosenLocationToMove)) {
			request.getSession().setAttribute("moveError", "Survivor is already on the chosen location!");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		}
		
		if (pickedLocation.getSurvivorsLimit() == pickedLocation.getSurvivors().size()) {
			request.getSession().setAttribute("moveError", "The location survivor limit is reached! You cannot move there!");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		}
		
		if (useFuel != null) {
			if (!checkIfPlayerHasFuelCards(player)) {
				request.getSession().setAttribute("moveError", "You do not have fuel to use for this move!");
				request.getRequestDispatcher("boardgame.jsp").forward(request, response);
				return;
			}
			
			System.out.println(pickedSurvivor.getName() + " uses 1 fuel card to move to " + chosenLocationToMove);
			removeFuelFromPlayer(player, map); // removes fuel and add card to waste pile
		} else {
			int exposureDieValue = pickedSurvivor.rollForExposure();
			
			System.out.println("Exposure die is rolled: " + exposureDieValue);
			if (willSurvive(exposureDieValue)) {
				
				// do not take damage if die is die is rolled between 0 and 5
				if(exposureDieValue > 5 && exposureDieValue < 9) { // takes 1 normal damage if die is rolled between 6 and 8
					pickedSurvivor.takeDamage();
					System.out.println(pickedSurvivor.getName() + " received 1 normal damage");
				} else if (exposureDieValue > 8 && exposureDieValue < 11) { // takes 1 normal damage with frostbite if die is rolled between 9 and 10
					pickedSurvivor.receiveFrostBite();
					System.out.println(pickedSurvivor.getName() + " received 1 frostbite damage");
				}
				
				if (pickedSurvivor.getReceivedDamage() >= Survivor.SURVIVOR_MAX_LIFE) {
					pickedSurvivor.die();
				}
			} else {
				pickedSurvivor.die();
			}
			
			System.out.println(pickedSurvivor.getName() + ": total received damage " + pickedSurvivor.getReceivedDamage());
								
		}
				
		addSurvivorOnNewLocation(map, survivorCurrentLocation, chosenLocationToMove, pickedSurvivor);
		survivorCurrentLocation.getSurvivors().remove(pickedSurvivor);
		pickedSurvivor.moveToLocation(pickedLocation);
		
		// checks if the survivor is alive
		if (!pickedSurvivor.isAlive()) {
			System.out.println(pickedSurvivor.getName() + " dies and a disease spreads!");
			
			// spreads disease and returns the survivor with lowest influence in the location if there is any
			Survivor lowestInfluenceSurvivor = pickedSurvivor.spreadDisease(pickedLocation);
			
			// checks if there is another survivor on the moved location
			if (lowestInfluenceSurvivor == null) {
				System.out.println("There are no other survivors in the " + pickedLocation.getLocationName());
			} else {
				lowestInfluenceSurvivor.takeDamage();
				
				// checks the life of the lowest influence survivor
				if (lowestInfluenceSurvivor.getReceivedDamage() >= Survivor.SURVIVOR_MAX_LIFE) {
					lowestInfluenceSurvivor.die();
					
					System.out.println(lowestInfluenceSurvivor.getName() + " dies from the spread disease!");
					// remove the lowest influence survivor that died
					removeTheDeadSurvivorFromTheGame(player, pickedLocation, lowestInfluenceSurvivor);
				}
				
			}

			// remove the survivor that died
			removeTheDeadSurvivorFromTheGame(player, pickedLocation, pickedSurvivor);	
		}
		
		for (int i = 0; i < map.getMap().size(); i++) {
			for (int j = 0; j < map.getMap().get(i).getSurvivors().size(); j++) {
				System.out.println("Location: " + map.getMap().get(i).getLocationName() + ". Survivor: " + map.getMap().get(i).getSurvivors().get(j).getName());
			}
		}
		
		request.getSession().setAttribute("player", player);
		request.getSession().setAttribute("map", map);
		request.getRequestDispatcher("boardgame.jsp").forward(request, response);
	}
	
	private void removeTheDeadSurvivorFromTheGame(Player player, Location pickedLocation, Survivor pickedSurvivor) {
		for (int i = 0; i < player.getSurvivors().size(); i++) {
			if (player.getSurvivors().get(i).getName().equals(pickedSurvivor.getName())) {
				player.getSurvivors().remove(i);
				break;
			}
		}
		
		for (int i = 0; i < pickedLocation.getSurvivors().size(); i++) {
			if (pickedLocation.getSurvivors().get(i).getName().equals(pickedSurvivor.getName())) {
				pickedLocation.getSurvivors().remove(i);
				break;
			}
		}
	}

	private boolean willSurvive(int exposureDieValue) {
		if (exposureDieValue != 11) {
			return true;
		}
		return false; // dies if roll 11
	}

	private void removeFuelFromPlayer(Player player, GameMap map) {
		for (int i = 0; i < player.getPlayerItems().size(); i++) {
			if (player.getPlayerItems().get(i).getName().equalsIgnoreCase(Item.Type.FUEL.toString())) {
				player.getPlayerItems().remove(i);
				map.getColony().addCardToWastePile();
				break;
			}
		}
	}

	private boolean checkIfPlayerHasFuelCards(Player player) {
			for (int i = 0; i < player.getPlayerItems().size(); i++) {
				if (player.getPlayerItems().get(i).getName().equalsIgnoreCase(Item.Type.FUEL.toString())) {
					return true;
				}
			}
		return false;
	}

	private void addSurvivorOnNewLocation(GameMap map, Location survivorCurrentLocation, String chosenLocationToMove, Survivor pickedSurvivor) {
		for (int i = 0; i < map.getMap().size(); i++) {
			if (map.getMap().get(i).getLocationName().equals(chosenLocationToMove)) {
				map.getMap().get(i).getSurvivors().add(pickedSurvivor);
				break;
			}
		}
		
		for (int i = 0; i < map.getMap().size(); i++) {
			if (map.getMap().get(i).getLocationName().equalsIgnoreCase(survivorCurrentLocation.getLocationName())) {
				map.getMap().get(i).getSurvivors().remove(pickedSurvivor);
			}
		}
	}

	private Location getLocation(String chosenLocationToMove, List<Location> mapLocations) {
		
		for (int i = 0; i < mapLocations.size(); i++) {
			if (mapLocations.get(i).getLocationName().equals(chosenLocationToMove)) {
				return mapLocations.get(i);
			}
		}
		
		return null;
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
