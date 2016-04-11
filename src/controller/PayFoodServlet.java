package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.card.Item;
import model.location.GameMap;
import model.user.Player;

@WebServlet("/PayFoodServlet")
public class PayFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GameMap map = (GameMap) request.getSession().getAttribute("map");
		Player player = (Player) request.getSession().getAttribute("player");
		boolean doesNotHaveFoodToPay = true;
		
		for (int i = 0; i < player.getPlayerItems().size(); i++) {
			if (player.getPlayerItems().get(i).getName().equalsIgnoreCase(Item.Type.FOOD.toString())) {
				doesNotHaveFoodToPay = false;
				player.getPlayerItems().remove(i);
				map.getColony().addFoodToColony();
				map.getColony().addCardToWastePile();
				break;
			}
		}
		
		if (doesNotHaveFoodToPay) {
			request.getSession().setAttribute("foodError", "You do not have food to contribute!");
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		}

		player.addValueToLog("Contributed 1 food for the colony food supply!");
		request.getSession().setAttribute("map", map);
		request.getSession().setAttribute("player", player);
		request.getRequestDispatcher("boardgame.jsp").forward(request, response);
	}

}
