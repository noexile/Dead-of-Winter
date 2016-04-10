package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.interfaces.IPlayerDao;
import model.interfaces.IPlayerDao.DataSource;
import model.user.Player;
import model.user.User;

@WebServlet("/EndGameServlet")
public class EndGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		resp.setHeader("Pragma", "no-cache");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Player player = (Player) request.getSession().getAttribute("player");
		boolean result = (boolean) request.getSession().getAttribute("result");
		
		User u = (User) request.getSession().getAttribute("loggedUser");
		IPlayerDao.getDAO(DataSource.DB).updateGamePlayed(player);
		
		if(result){
			IPlayerDao.getDAO(DataSource.DB).updateGameWon(player);
			request.getRequestDispatcher("CleanSavedInfoServlet").forward(request, response);
		}
		
		request.getRequestDispatcher("loseResult.jsp").forward(request, response);
	}

}
