package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.objective.SecretObjective;
import model.user.Player;

@WebServlet("/ChosenSecretObjective")
public class ChosenSecretObjective extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		
		String secret = request.getParameter("secret");
		
		if (secret == null) {
			request.getSession().setAttribute("secretObjectiveError", "You must choose a Secret Objective!");
			request.getRequestDispatcher("secretObjectivePage.jsp").forward(request, response);
		}
		
		List<SecretObjective> secretObjectives = (ArrayList<SecretObjective>) request.getSession().getAttribute("objectives");
		SecretObjective chosenSecret = null;
		
		for (int i = 0; i < secretObjectives.size(); i++) {
			if (secret.equals(secretObjectives.get(i).getSecretObjectiveGoal().getName())) {
				chosenSecret = secretObjectives.get(i);
				break;
			}
		}
		
		Player player = (Player) request.getSession().getAttribute("player");
		player.setSecretObjective(chosenSecret);
		request.getSession().setAttribute("player", player); // update player in session
		
		// remove unused attributes from session
		request.getSession().removeAttribute("objectives");
		request.getSession().removeAttribute("randomizedObjectives"); 

		request.getRequestDispatcher("GenerateSurvivorsServlet").forward(request, response);
	}

}
