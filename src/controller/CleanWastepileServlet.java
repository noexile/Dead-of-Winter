package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.character.Survivor;
import model.location.GameMap;
import model.user.Player;

@WebServlet("/CleanWastepileServlet")
public class CleanWastepileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String survivorName = request.getParameter("selected_survivor");
		String dice = request.getParameter("picked_dice");

		System.out.println("clean wastepile servlet picked dice: " + dice);
		GameMap map = (GameMap) request.getSession().getAttribute("map");
		Player player = (Player) request.getSession().getAttribute("player");
		List<Survivor> playerSurvivors = player.getSurvivors();
		Survivor pickedSurvivor = getSurvivor(survivorName ,playerSurvivors);
		
		if (survivorName == null) {
			request.getSession().setAttribute("cleanWastepileError", "You must select a survivor to clean the wastepile!");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		}
		
		if (!pickedSurvivor.getCurrentLocation().equals(map.getColony())) {
			request.getSession().setAttribute("cleanWastepileError", "The survivor must be in the colony to clean the wastepile!");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		}
		
		if (dice.trim().isEmpty()) {
			request.getSession().setAttribute("cleanWastepileError", "No dice selected for cleaning wastelipe!");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		}
		
		if (map.getColony().getWastePileSize() == 0) {
			request.getSession().setAttribute("cleanWastepileError", "The wastepile is empty!");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		}
		
		
		for (int i = 0; i < player.getRolledDice().size(); i++) {
			if (player.getRolledDice().get(i).equals(Integer.valueOf(dice))) {
				player.getRolledDice().remove(i);
				break;
			}
		}
				
		map.getColony().clearWastePile();
		
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
