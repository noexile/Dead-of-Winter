package controller;

import java.io.IOException;
import java.util.List;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Player player = (Player) request.getSession().getAttribute("player");
		String survivorName = request.getParameter("selected_survivor");

		System.out.println(survivorName);
		List<Survivor> playerSurvivors = player.getSurvivors();
		Survivor pickedSurvivor = getSurvivor(survivorName, playerSurvivors);
		Location attackingLocation = pickedSurvivor.getCurrentLocation();

		int exposureDieValue = pickedSurvivor.rollForExposure();
		if (attackingLocation.getEntrance().getOcupiedPlaces() > 0) {
			System.out.println(attackingLocation.getEntrance().getFreePlaces());
			System.out.println("Exposure die is rolled: " + exposureDieValue);
			if (willSurvive(exposureDieValue)) {

				player.getMainObjective().getGoal()
						.setZombieKills(player.getMainObjective().getGoal().getZombieKills() + 1);
				attackingLocation.getEntrance().removeOccupant();
				// do not take damage if die is die is rolled between 0 and 5
				if (exposureDieValue > 5 && exposureDieValue < 9) { // takes 1
																	// normal
																	// damage if
																	// die is
																	// rolled
																	// between 6
																	// and 8
					pickedSurvivor.takeDamage();
					System.out.println(pickedSurvivor.getName() + " received 1 normal damage");
				} else if (exposureDieValue > 8 && exposureDieValue < 11) { // takes
																			// 1
																			// normal
																			// damage
																			// with
																			// frostbite
																			// if
																			// die
																			// is
																			// rolled
																			// between
																			// 9
																			// and
																			// 10
					pickedSurvivor.receiveFrostBite();
					System.out.println(pickedSurvivor.getName() + " received 1 frostbite damage");
				}

				if (pickedSurvivor.getReceivedDamage() >= Survivor.SURVIVOR_MAX_LIFE) {
					pickedSurvivor.die();
					player.getSurvivors().remove(pickedSurvivor);
				}
			} else {
				pickedSurvivor.die();
				player.getSurvivors().remove(pickedSurvivor);
				player.getMainObjective().getGoal()
						.setZombieKills(player.getMainObjective().getGoal().getZombieKills() + 1);
			}
		} else {
			request.getSession().setAttribute("noZombieError", "Sorry there are no zombies to attack");
		}
		System.out.println("Zombies killed = " + player.getMainObjective().getGoal().getZombieKills());
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
