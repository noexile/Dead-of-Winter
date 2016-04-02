package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.character.Survivor;
import model.user.Player;

@WebServlet("/ChosenSurvivorServlet")
public class ChosenSurvivorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final int STARTING_SURVIVORS = 2;
		String[] chosenSurvivors = request.getParameterValues("chosenSurvivor");

		
		if (chosenSurvivors == null || chosenSurvivors.length != STARTING_SURVIVORS) {
			request.getSession().setAttribute("survivorChoosingError", "You must choose " + STARTING_SURVIVORS + " Survivors!");
			request.getRequestDispatcher("survivorPage.jsp").forward(request, response);
			return;
		} 
		
		List<Survivor> survivorsList = (ArrayList<Survivor>) request.getSession().getAttribute("survivors");
		List<Survivor> pickedSurvivors = new ArrayList<Survivor>();

		for (int i = 0; i < chosenSurvivors.length; i++) {
			for (int j = 0; j < survivorsList.size(); j++) {
				if (chosenSurvivors[i].equals(survivorsList.get(j).getName())) {
					pickedSurvivors.add(survivorsList.get(j));
					break;
				}
			}
			if (pickedSurvivors.size() == STARTING_SURVIVORS) {
				break;
			}
		}
		
		Player player = (Player) request.getSession().getAttribute("player");
		player.setSurvivors(pickedSurvivors);
		request.getSession().setAttribute("player", player); // update player in session
		
		// remove unused attributes from session
		request.getSession().removeAttribute("survivors");
		request.getSession().removeAttribute("randomizedSurvivors"); 
		request.getRequestDispatcher("GenerateStartingPlayerCardsServlet").forward(request, response);
	}

}
