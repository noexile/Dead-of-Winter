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

import model.objective.SecretObjective;
import model.objective.secretobjectives.ANewDestination;
import model.objective.secretobjectives.DesireToLive;
import model.objective.secretobjectives.Historian;
import model.objective.secretobjectives.Hunger;
import model.objective.secretobjectives.Hypochondriac;
import model.objective.secretobjectives.Junkie;
import model.objective.secretobjectives.Protected;
import model.objective.secretobjectives.ZombieKillingRobot;

@WebServlet("/GenerateSecretObjectivesServlet")
public class GenerateSecretObjectivesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final int displayedCards = 3;
		List<SecretObjective> objectives;
		List<SecretObjective> randomizedObjectives;
		
		if (request.getSession().getAttribute("objectives") == null) {
			objectives = generateSecretObjectives();
		} else {
			objectives = (List<SecretObjective>) request.getSession().getAttribute("objectives");
		}
		
		randomizedObjectives = randomizeSecretObjectives(objectives, displayedCards);
		
		request.getSession().setAttribute("objectives", objectives);
		request.getSession().setAttribute("randomizedObjectives", randomizedObjectives);
		request.getRequestDispatcher("secretObjectivePage.jsp").forward(request, response);
	}

	private List<SecretObjective> randomizeSecretObjectives(List<SecretObjective> objectives, final int displayedCards) {
		ArrayList<SecretObjective> secretObjectives = new ArrayList<SecretObjective>();
		
		Random rand = new Random();
		
		for (int i = 0; i < displayedCards; i++) {
			SecretObjective obj = objectives.get(rand.nextInt(objectives.size()));
			if (secretObjectives.contains(obj)) {
				i = i - 1;
				continue;
			}
			secretObjectives.add(obj);
		}
		
		return secretObjectives;
	}

	private List<SecretObjective> generateSecretObjectives() {
		ArrayList<SecretObjective> secretObjectives = new ArrayList<SecretObjective>();
		
		secretObjectives.add(new SecretObjective(new ANewDestination()));
		secretObjectives.add(new SecretObjective(new DesireToLive()));
		secretObjectives.add(new SecretObjective(new Historian()));
		secretObjectives.add(new SecretObjective(new Hunger()));
		secretObjectives.add(new SecretObjective(new Hypochondriac()));
		secretObjectives.add(new SecretObjective(new Junkie()));
		secretObjectives.add(new SecretObjective(new Protected()));
		secretObjectives.add(new SecretObjective(new ZombieKillingRobot()));
		
		return secretObjectives;
	}

}
