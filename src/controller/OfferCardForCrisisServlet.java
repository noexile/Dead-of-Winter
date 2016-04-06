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

@WebServlet("/OfferCardForCrisisServlet")
public class OfferCardForCrisisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardIndex = request.getParameter("card_index");
		
		if (cardIndex == null) {
			// TODO print error
			request.getRequestDispatcher("boardgame.jsp").forward(request, response);
			return;
		}
		
		int removedItem = Integer.valueOf(cardIndex);
		
		Player player = (Player) request.getSession().getAttribute("player");
		GameMap map = (GameMap) request.getSession().getAttribute("map");
		
		System.out.println("removed card index: " + cardIndex);
		player.getPlayerItems().remove(removedItem);
		map.getColony().addCrisisContributionCard();
		map.getColony().addCardToWastePile();
		
		request.getSession().setAttribute("player", player);
		request.getSession().setAttribute("map", map);
		request.getRequestDispatcher("boardgame.jsp").forward(request, response);
		
	}

}
