package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.Player;

@WebServlet("/CreatePlayerServlet")
public class CreatePlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userId = (String) request.getSession().getAttribute("user_id");
//		
//		if (userId == null) {
//			request.getSession(false).invalidate();
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		}
		
//		int id = Integer.valueOf(userId);
		int id = 11;
		
		Player player = new Player(id);
		request.getSession().setAttribute("player", player);
		request.getRequestDispatcher("mainObjectivePage.jsp").forward(request, response);
	}
	
}