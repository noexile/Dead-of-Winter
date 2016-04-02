package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.interfaces.IUserDAO;
import model.interfaces.IUserDAO.DataSource;
import model.user.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try{
			for(Map.Entry<String, User> entry : IUserDAO.getDAO(DataSource.DB).getAllUsers().entrySet()){
				if(entry.getKey().equals(username) && entry.getValue().getPassword().equals(password)){
					request.getSession().setAttribute("loggedUser", entry.getValue());
					request.getRequestDispatcher("mainPage.jsp").forward(request, response);
					return;
				}
			}
		}
		catch(Exception e){
		}
		
		request.getSession().setAttribute("error", "Invalid input information");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
