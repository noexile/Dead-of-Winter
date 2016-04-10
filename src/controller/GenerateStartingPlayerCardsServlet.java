package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.card.PlayerCard;
import model.card.playercards.Food;
import model.card.playercards.Fuel;
import model.card.playercards.Junk;
import model.card.playercards.Medicine;
import model.user.Player;

@WebServlet("/GenerateStartingPlayerCardsServlet")
public class GenerateStartingPlayerCardsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		
		final int STARTING_MEDICINE_CARDS = 5;
		final int STARTING_FOOD1_CARDS = 10;
		final int STARTING_JUNK_CARDS = 5;
		final int STARTING_FUEL_CARDS = 5;
		final int NORMAL_MODE_STARTING_CARDS = 10;
		final int HARD_MODE_STARTING_CARDS = 8;
		
		Player player = (Player) request.getSession().getAttribute("player");
		boolean isHardMode = player.getMainObjective().isHardMode();
		int displayedCards = (isHardMode ? HARD_MODE_STARTING_CARDS : NORMAL_MODE_STARTING_CARDS);
		
		List<PlayerCard> playerStartingCards;
		List<PlayerCard> randomizedPlayerStartingCards;
		List<PlayerCard> randomizedPlayerStartingCardsPartOne = new ArrayList<PlayerCard>();
		List<PlayerCard> randomizedPlayerStartingCardsPartTwo = new ArrayList<PlayerCard>();
		
		if (request.getSession().getAttribute("player_cards") == null) {
			playerStartingCards = generatePlayerCards(STARTING_MEDICINE_CARDS, STARTING_FOOD1_CARDS, STARTING_JUNK_CARDS, STARTING_FUEL_CARDS);
		} else {
			playerStartingCards = (List<PlayerCard>) request.getSession().getAttribute("player_cards");
		}
		
		randomizedPlayerStartingCards = randomizePlayerCards(playerStartingCards, displayedCards);
		
		for (int i = 0; i < randomizedPlayerStartingCards.size(); i++) {
			if (i % 2 == 0) {
				randomizedPlayerStartingCardsPartOne.add(randomizedPlayerStartingCards.get(i));
			} else {
				randomizedPlayerStartingCardsPartTwo.add(randomizedPlayerStartingCards.get(i));
			}
		}
		
		
		if (isHardMode) {
			request.getSession().setAttribute("isHardMode", HARD_MODE_STARTING_CARDS / 2);
		} else {
			request.getSession().setAttribute("isHardMode", NORMAL_MODE_STARTING_CARDS / 2);
		}

		request.getSession().setAttribute("randomizedPlayerStartingCards", randomizedPlayerStartingCards);
		request.getSession().setAttribute("playerStartingCards", playerStartingCards);
		request.getSession().setAttribute("randomizedPlayerStartingCardsPartOne", randomizedPlayerStartingCardsPartOne);
		request.getSession().setAttribute("randomizedPlayerStartingCardsPartTwo", randomizedPlayerStartingCardsPartTwo);
		request.getRequestDispatcher("playerStartingCardsPage.jsp").forward(request, response);
		
	}
	
	
	private ArrayList<PlayerCard> randomizePlayerCards(List<PlayerCard> playerStartingCards, int displayedCards) {
		ArrayList<PlayerCard> playerCards = new ArrayList<PlayerCard>();
		
		Random rand = new Random();
		
		for (int i = 0; i < displayedCards; i++) {
			PlayerCard card = playerStartingCards.get(rand.nextInt(playerStartingCards.size()));
			if (playerCards.contains(card)) {
				i = i - 1;
				continue;
			}
			playerCards.add(card);
		}
		
		return playerCards;
	}

	private ArrayList<PlayerCard> generatePlayerCards(int STARTING_MEDICINE_CARDS, int STARTING_FOOD1_CARDS, int STARTING_JUNK_CARDS, int STARTING_FUEL_CARDS) {
		ArrayList<PlayerCard> playerCards = new ArrayList<PlayerCard>();
		
		// ADD ABILITY TO ALL CARDS
		for (int i = 0; i < STARTING_MEDICINE_CARDS; i++) {
			playerCards.add(new Medicine()); 
		}
		
		for (int i = 0; i < STARTING_FOOD1_CARDS; i++) {
			playerCards.add(new Food()); 
		}
		
		for (int i = 0; i < STARTING_JUNK_CARDS; i++) {
			playerCards.add(new Junk()); 
		}
		
		for (int i = 0; i < STARTING_FUEL_CARDS; i++) {
			playerCards.add(new Fuel()); 
		}
		
		return playerCards;
	}

}
