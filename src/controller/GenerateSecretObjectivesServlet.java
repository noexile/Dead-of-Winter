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
import model.objective.secretobjectives.Hunger;
import model.objective.secretobjectives.Hypochondriac;
import model.objective.secretobjectives.Junkie;

@WebServlet("/GenerateSecretObjectivesServlet")
public class GenerateSecretObjectivesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		
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
		
		secretObjectives.add(new SecretObjective(ANewDestination.getInstance()));
		secretObjectives.add(new SecretObjective(Hunger.getInstance()));
		secretObjectives.add(new SecretObjective(Hypochondriac.getInstance()));
		secretObjectives.add(new SecretObjective(Junkie.getInstance()));
		
		return secretObjectives;
	}

}
