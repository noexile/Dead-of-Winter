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
import model.character.survivors.AlexisGrey;
import model.character.survivors.AndrewEvans;
import model.character.survivors.AshleyRoss;
import model.character.survivors.BevRussell;
import model.character.survivors.BrandonKane;
import model.character.survivors.BuddyDavis;
import model.character.survivors.DavidGarcia;
import model.character.survivors.JanetTaylor;
import model.character.survivors.RodMiller;
import model.character.survivors.Sparky;
import model.location.map.Colony;

@WebServlet("/GenerateSurvivorsServlet")
public class GenerateSurvivorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		// TODO Beans
		// TODO singleton classes
		Colony colony = Colony.getInstance();
		survivorsList.add(new AlexisGrey(colony, null));
		survivorsList.add(new AndrewEvans(colony, null));
		survivorsList.add(new AshleyRoss(colony, null));
		survivorsList.add(new BevRussell(colony, null));
		survivorsList.add(new BrandonKane(colony, null));
		survivorsList.add(new BuddyDavis(colony, null));
		survivorsList.add(new DavidGarcia(colony, null));
		survivorsList.add(new JanetTaylor(colony, null));
		survivorsList.add(new RodMiller(colony, null));
		survivorsList.add(new Sparky(colony, null));
		
		return survivorsList;
	}

}
