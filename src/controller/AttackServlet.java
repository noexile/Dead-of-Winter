package controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.character.Survivor;
import model.location.Location;
import model.user.Player;

@WebServlet("/AttackServlet")
public class AttackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		Player player = (Player) request.getSession().getAttribute("player");
		String survivorName = request.getParameter("selected_survivor");
		String dice = request.getParameter("picked_dice");
		
		List<Survivor> playerSurvivors = player.getSurvivors();
		Survivor pickedSurvivor = getSurvivor(survivorName, playerSurvivors);
		Location attackingLocation = pickedSurvivor.getCurrentLocation();
		StringBuilder attackMessage = new StringBuilder();
		
		if (dice == null || dice.trim().isEmpty()) {
			request.getSession().setAttribute("noZombieError", "No dice selected for attacking!");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		} else if(Integer.valueOf(dice) < pickedSurvivor.getAttackValue()) {
			request.getSession().setAttribute("noZombieError", "The picked dice must have bigger value than the survivors' !");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		}
		
		for (int i = 0; i < player.getRolledDice().size(); i++) {
			if (player.getRolledDice().get(i).equals(Integer.valueOf(dice))) {
				player.getRolledDice().remove(i);
				break;
			}
		}

		int exposureDieValue = pickedSurvivor.rollForExposure();
		if (attackingLocation.getEntrance().getOcupiedPlaces() > 0) {
			attackMessage.append(survivorName + " attacks zombie at the " + attackingLocation.getLocationName() + ". Exposure dice rolled: " + exposureDieValue + ". ");
			player.setZombieKills(player.getZombieKills()+1);
			if (willSurvive(exposureDieValue)) {
				// do not take damage if die is die is rolled between 0 and 5
				if (exposureDieValue < 6) {
					attackMessage.append("Survivor stays unharmed. ");
				} else if(exposureDieValue > 5 && exposureDieValue < 9) { // takes 1 normal damage if die is rolled between 6 and 8
					pickedSurvivor.takeDamage();
					System.out.println(pickedSurvivor.getName() + " received 1 normal damage");
					attackMessage.append("Survivor receave 1 damage. ");
				} else if (exposureDieValue > 8 && exposureDieValue < 11) { // takes 1 normal damage with frostbite if die is rolled between 9 and 10
					pickedSurvivor.receiveFrostBite();
					System.out.println(pickedSurvivor.getName() + " received 1 frostbite damage");
					attackMessage.append("Survivor receave 1 frostbite damage. ");
				}				
				
				Random rn = new Random();
				int random = rn.nextInt(6) + 1;
				if(random>=4){
					player.getMainObjective().getGoal().setZombieKills(player.getMainObjective().getGoal().getZombieKills()+1);
					attackMessage.append(" You manage to take a zombie token.");
				}
				
				attackingLocation.getEntrance().removeOccupant();
			} else {
				pickedSurvivor.die();
			}								
		} else {
			request.getSession().setAttribute("noZombieError", "Sorry there are no zombies to attack");
		}
		
		if (pickedSurvivor.getReceivedDamage() >= Survivor.SURVIVOR_MAX_LIFE || !pickedSurvivor.isAlive()) {
			
			if (!pickedSurvivor.isAlive()) {
				attackMessage.append("Survivor gets bitten and die.");
			} else {
				attackMessage.append("Survivor receave fatal damage and die.");
			}
			pickedSurvivor.die();			
			
			player.getSurvivors().remove(pickedSurvivor);
			attackingLocation.getSurvivors().remove(pickedSurvivor);
		}
		
		player.addValueToLog(attackMessage.toString());
		request.getRequestDispatcher("boardgame.jsp").forward(request, response);
	}

	private boolean willSurvive(int exposureDieValue) {
		if (exposureDieValue != 11) {
			return true;
		}
		return false; // dies if roll 11
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
