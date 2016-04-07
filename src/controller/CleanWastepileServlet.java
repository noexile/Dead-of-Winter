package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.location.GameMap;
import model.user.Player;

@WebServlet("/CleanWastepileServlet")
public class CleanWastepileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dice = request.getParameter("rolled_dice");

		GameMap map = (GameMap) request.getSession().getAttribute("map");
		Player player = (Player) request.getSession().getAttribute("player");
		
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

}