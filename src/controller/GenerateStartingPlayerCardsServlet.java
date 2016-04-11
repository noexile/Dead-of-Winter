package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.card.Item;
import model.db.DBItemCardDao;
import model.user.Player;

@WebServlet("/GenerateStartingPlayerCardsServlet")
public class GenerateStartingPlayerCardsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		
		final int NORMAL_MODE_ITEMS_REMOVED = 6;
		final int HARD_MODE_ITEMS_REMOVED = 8;
		
		
		Player player = (Player) request.getSession().getAttribute("player");
		boolean isHardMode = player.getMainObjective().isHardMode();
		
		List<Item> playerStartingCards;
		List<Item> randomizedPlayerStartingCards;
		
		if (request.getSession().getAttribute("player_cards") == null) {
			playerStartingCards = generatePlayerCards();
		} else {
			playerStartingCards = (List<Item>) request.getSession().getAttribute("player_cards");
		}
		
		randomizedPlayerStartingCards = playerStartingCards; // 16
		
		System.out.println("before " + randomizedPlayerStartingCards.size());
		
		Collections.shuffle(randomizedPlayerStartingCards);
		Collections.shuffle(randomizedPlayerStartingCards);
		Collections.shuffle(randomizedPlayerStartingCards);
		
		int itemsRemoved = NORMAL_MODE_ITEMS_REMOVED;
		if (isHardMode) {
			itemsRemoved = HARD_MODE_ITEMS_REMOVED;
		} 
		
		for (int i = 0; i < itemsRemoved; i++) {
			randomizedPlayerStartingCards.remove(i);
		}
		
		System.out.println("after " + randomizedPlayerStartingCards.size());

		request.getSession().setAttribute("randomizedPlayerStartingCards", randomizedPlayerStartingCards);
		request.getSession().setAttribute("playerStartingCards", playerStartingCards);
		request.getRequestDispatcher("playerStartingCardsPage.jsp").forward(request, response);
		
	}
	

	private List<Item> generatePlayerCards() {
		List<Item> playerCards = new ArrayList<Item>();
		List<Item> cards = DBItemCardDao.getInstance().getItemCards();
		  
		for (int i = 0; i < cards.size(); i++) {
			playerCards.addAll(cards);
		}

		return playerCards;
	}

}
