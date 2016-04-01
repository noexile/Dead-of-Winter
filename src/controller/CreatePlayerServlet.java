package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.Player;
import model.user.User;

@WebServlet("/CreatePlayerServlet")
public class CreatePlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("loggedUser");
//		
//		if (userId == null) {
//			request.getSession(false).invalidate();
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		}
		
//		int id = Integer.valueOf(userId);
		int id = user.getId();
		
		Player player = new Player(id);
		request.getSession().setAttribute("player", player);
		request.getRequestDispatcher("mainObjectivePage.jsp").forward(request, response);
	}
	
}
