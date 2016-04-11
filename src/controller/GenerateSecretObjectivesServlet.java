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

import model.interfaces.ISecretObjectiveDao;
import model.interfaces.ISecretObjectiveDao.Data;
import model.objective.SecretObjective;

@WebServlet("/GenerateSecretObjectivesServlet")
public class GenerateSecretObjectivesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doPost(req, resp);
	}
	
	@SuppressWarnings("unchecked")
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
		
		for (int i = 0; i < displayedCards; i++) {
			secretObjectives.add(objectives.get(i));
		}
		
		Collections.shuffle(secretObjectives);
		Collections.shuffle(secretObjectives);
		Collections.shuffle(secretObjectives);
		
		return secretObjectives;
	}

	private List<SecretObjective> generateSecretObjectives() {
		ArrayList<SecretObjective> secretObjectives = new ArrayList<SecretObjective>();
		
		for (int i = 0; i < ISecretObjectiveDao.getDAO(Data.DB).getSecretObjectives().size(); i++) {
			secretObjectives.add(new SecretObjective(ISecretObjectiveDao.getDAO(Data.DB).getSecretObjectives().get(i)));
		}

		return secretObjectives;
	}

}
