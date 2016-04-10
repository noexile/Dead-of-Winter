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
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		resp.setHeader("Pragma", "no-cache");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String username = request.getParameter("user");
		String email = request.getParameter("email");
		String rePassword = request.getParameter("re-password");
		if(password.isEmpty() || email.isEmpty() || username.isEmpty()){
			request.getSession().setAttribute("error", "You cant leave a field empty");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		else if(validUser(username) && validMail(email) && validPwd(password) && password.equals(rePassword)){
			IUserDAO.getDAO(DataSource.DB).registerUser(new User(username,password,email));
			User user = IUserDAO.getDAO(DataSource.DB).getUser(username);
			request.getSession().setAttribute("loggedUser", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else{
			if(!validUser(username))
				request.getSession().setAttribute("error", "Sorry this username already exists");
			else if(!validMail(email))
				request.getSession().setAttribute("error", "The email u just entered is not valid");
			else if(!validPwd(password))
				request.getSession().setAttribute("error", "Your password should be 5 characters long and should contain a symbol and a digit");
			else if(!password.equals(rePassword))
				request.getSession().setAttribute("error", "Your passwords doesnt match");
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
