package controller;

import java.io.IOException;

import model.interfaces.IUserDao;
import model.interfaces.IUserDao.DataSource;
import model.user.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		if(password.isEmpty() || email.isEmpty() || request.getSession().getAttribute("loggedUser") == null){
			request.getSession().setAttribute("error", "You cant set your information to empty");
			response.sendRedirect("profile.jsp");
			return;
		}
		if(RegistrationServlet.validMail(email) && RegistrationServlet.validPwd(password)){
			User loggedUser = (User) request.getSession().getAttribute("loggedUser");
			loggedUser.setPassword(password);
			loggedUser.setEmail(email);
			IUserDao.getDAO(DataSource.DB).updateUser(loggedUser);
			request.getSession().setAttribute("profileMsg", "Your profile is successfully changed");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		else{
			request.getSession().setAttribute("error", "Your password must contain a number a symbol and must be at least 5 signs and you need to use a valid mail");
			response.sendRedirect("profile.jsp");
		}
		
	}
}
