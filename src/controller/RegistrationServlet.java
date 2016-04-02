package controller;

import java.io.IOException;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.interfaces.IUserDAO;
import model.interfaces.IUserDAO.DataSource;
import model.user.User;



@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String username = request.getParameter("user");
		String email = request.getParameter("email");
		if(password.isEmpty() || email.isEmpty() || username.isEmpty()){
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		else if(validUser(username) && validMail(email) && validPwd(password)){
			IUserDAO.getDAO(DataSource.DB).registerUser(new User(username,password,email));
			User user = IUserDAO.getDAO(DataSource.DB).getUser(username);
			request.getSession().setAttribute("loggedUser", user);
			request.getRequestDispatcher("mainPage.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	public static boolean validPwd(String password) {
		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=-])(?=\\S+$).{5,}$";
		if(!password.matches(pattern)){
			return false;
		}
		return true;
	}

	public static boolean validMail(String email) {
		 boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
	}

	public boolean validUser(String username) {
		return IUserDAO.getDAO(DataSource.DB).usernameValidate(username);
	}

}
