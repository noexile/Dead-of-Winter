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
		
		String normalMode = request.getParameter("normal_mode");
		String hardcoreMode = request.getParameter("hardcore_mode");
		
		boolean mode = false;
		
		if (normalMode != null) {
			mode = false;
		} else if(hardcoreMode != null) {
			mode = true;
		}
		
		MainObjective mainObjective = new MainObjective(mode); // TODO with Beans
		Player player = (Player) request.getSession().getAttribute("player");
		player.setMainObjective(mainObjective);
		
		request.getSession().setAttribute("player", player);
		request.getRequestDispatcher("secretObjectivePage.jsp").forward(request, response);
	}
	
}
