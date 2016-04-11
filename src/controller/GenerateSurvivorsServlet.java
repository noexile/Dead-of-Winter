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

import model.character.Survivor;
import model.interfaces.ISurvivorDao;
import model.interfaces.ISurvivorDao.DS;
import model.location.GameMap;

@WebServlet("/GenerateSurvivorsServlet")
public class GenerateSurvivorsServlet extends HttpServlet {
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
		
		final int displayedCards = 4;
		List<Survivor> survivors;
		List<Survivor> randomizedSurvivors;
		
		if (request.getSession().getAttribute("survivors") == null) {
			survivors = generateSurvivors();
		} else {
			survivors = (List<Survivor>) request.getSession().getAttribute("survivors");
		}
		
		randomizedSurvivors = randomizeSurvivors(survivors, displayedCards);
		
		request.getSession().setAttribute("survivors", survivors);
		request.getSession().setAttribute("randomizedSurvivors", randomizedSurvivors);
		request.getRequestDispatcher("survivorPage.jsp").forward(request, response);
	}

	private ArrayList<Survivor> randomizeSurvivors(List<Survivor> survivors, int displayedCards) {
		ArrayList<Survivor> survivorsList = new ArrayList<Survivor>();
		
		Random rand = new Random();
		
		for (int i = 0; i < displayedCards; i++) {
			Survivor surv = survivors.get(rand.nextInt(survivors.size()));
			if (survivorsList.contains(surv)) {
				i = i - 1;
				continue;
			}
			survivorsList.add(surv);
		}
		
		return survivorsList;
	}

	private List<Survivor> generateSurvivors() {
		List<Survivor> survivorsList = new ArrayList<Survivor>();
				
		
		// get from db
		for (int i = 0; i < ISurvivorDao.getDAO(DS.DB).getSurvivors().size(); i++) {
			survivorsList.add(ISurvivorDao.getDAO(DS.DB).getSurvivors().get(i));
			survivorsList.get(i).setCurrentLocation(GameMap.getColony());
		}
		
		return survivorsList;
	}

}
