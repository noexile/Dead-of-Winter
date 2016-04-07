package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		
		String md5Pass = convertToMd5(password);
		try{
			for(Map.Entry<String, User> entry : IUserDAO.getDAO(DataSource.DB).getAllUsers().entrySet()){
				if(entry.getKey().equals(username) && entry.getValue().getPassword().equals(md5Pass)){
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
	
	private static String convertToMd5(final String md5) throws UnsupportedEncodingException {
        StringBuffer sb=null;
        try {
            final java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            final byte[] array = md.digest(md5.getBytes("UTF-8"));
            sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (final java.security.NoSuchAlgorithmException e) {
        }
        return sb.toString();
    }

}
