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
import model.user.Player;

@WebServlet("/HealServlet")
public class HealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Player player = (Player) request.getSession().getAttribute("player");
		String survivorName = request.getParameter("selected_survivor");
		
		GameMap map = (GameMap) request.getSession().getAttribute("map");

		System.out.println(survivorName);
		List<Survivor> playerSurvivors = player.getSurvivors();
		System.out.println(player.getSurvivors().size());
		Survivor pickedSurvivor = getSurvivor(survivorName, playerSurvivors);

		if (pickedSurvivor.getReceivedDamage() > 0) {
			if (!checkIfPlayerHasMedicineCards(player)) {
				request.getSession().setAttribute("healError", "You do not have medicine to use for this move!");
				request.getRequestDispatcher("boardgame.jsp").forward(request, response);
				return;
			}
			removeMedicineFromPlayer(player, map);
			if(pickedSurvivor.isHasFrostBite()){
				pickedSurvivor.setHasFrostBite(false);
				request.getSession().setAttribute("healMsg", "Your survivor is no longer frost bitten but is still damaged");
			}
			else {
				pickedSurvivor.setReceivedDamage(0);
				request.getSession().setAttribute("healError", "You cant heal a survivor that is already on full health");
			}
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

	private boolean checkIfPlayerHasMedicineCards(Player player) {
		for (int i = 0; i < player.getPlayerItems().size(); i++) {
			if (player.getPlayerItems().get(i).getName().equalsIgnoreCase(Item.Type.MEDICINE.toString())) {
				return true;
			}
		}
		return false;
	}
	
	private void removeMedicineFromPlayer(Player player, GameMap map) {
		for (int i = 0; i < player.getPlayerItems().size(); i++) {
			if (player.getPlayerItems().get(i).getName().equalsIgnoreCase(Item.Type.MEDICINE.toString())) {
				player.getPlayerItems().remove(i);
				map.getColony().addCardToWastePile();
				break;
			}
		}
	}

}
