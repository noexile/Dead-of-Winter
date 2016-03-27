package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.objective.MainObjective;
import model.user.Player;

@WebServlet("/ChooseMainObjectiveServlet")
public class ChooseMainObjectiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String normal = "normal_mode";
		final String hardcore = "hardcore_mode";
		
		String mode = request.getParameter("mode");
		
		request.getSession().removeAttribute("mainObjectiveError");
		
		boolean checkedMode = false;
		
		if (mode == null) {
			request.getSession().setAttribute("mainObjectiveError", "You must choose an Objective!");
			request.getRequestDispatcher("mainObjectivePage.jsp").forward(request, response);
		} else if (mode.equalsIgnoreCase(normal)) {
			checkedMode = false;
		} else if(mode.equalsIgnoreCase(hardcore)) {
			checkedMode = true;
		} 
		
		MainObjective mainObjective = new MainObjective(checkedMode); // TODO with Beans
		Player player = (Player) request.getSession().getAttribute("player");
		player.setMainObjective(mainObjective);
		
		request.getSession().setAttribute("player", player);
		request.getRequestDispatcher("GenerateSecretObjectivesServlet").forward(request, response);
	}
		
}
