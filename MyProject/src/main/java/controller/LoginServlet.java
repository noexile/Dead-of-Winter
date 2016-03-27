package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.UserManager;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserManager userManager = new UserManager();
		
		if (username == null || password == null || !userManager.checkIfUserExists(username)) {
			request.getSession().setAttribute("error", "wrong username or password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		request.getSession().removeAttribute("error");
		
		// zashivame user id-to v sesiyata

		request.getSession().setAttribute("manager", userManager);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
