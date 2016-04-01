package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.card.PlayerCard;
import model.user.Player;

@WebServlet("/GameBeginServlet")
public class GameBeginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Player player = (Player) request.getSession().getAttribute("player");
		ArrayList<PlayerCard> startingCards = (ArrayList<PlayerCard>) request.getSession().getAttribute("randomizedPlayerStartingCards");
		
		request.removeAttribute("playerStartingCards");
		request.removeAttribute("randomizedPlayerStartingCards");
		request.removeAttribute("randomizedPlayerStartingCardsPartOne");
		request.removeAttribute("randomizedPlayerStartingCardsPartTwo");
		
		player.setPlayerItems(startingCards);
		player.setMorale(player.getMainObjective().getStartingMorale());
		player.setRound(player.getMainObjective().getStartingRound());
		
		// TODO crisis cards
		// TODO fix Secret Objective
		printPlayerCurrentStuff(player);
		
	}

	private void printPlayerCurrentStuff(Player player) {
		System.out.println(player.getMainObjective().getName());
		System.out.println(player.getSecretObjective().getName());
		System.out.println(player.getId());
		System.out.println("Items:");
		for (int i = 0; i < player.getPlayerItems().size(); i++) {
			System.out.println("- " + player.getPlayerItems().get(i).getName());
		}
		System.out.println("Survivors:");
		for (int i = 0; i < player.getSurvivors().size(); i++) {
			System.out.println("- " + player.getSurvivors().get(i).getName());
		}
	}

}
