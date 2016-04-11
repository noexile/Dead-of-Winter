package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.interfaces.IPlayerDao;
import model.interfaces.IPlayerDao.Source;
import model.user.Player;
import model.user.User;

@WebServlet("/EndGameServlet")
public class EndGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		
		Player player = (Player) request.getSession().getAttribute("player");
		boolean result = (boolean) request.getSession().getAttribute("result");
		
		User u = (User) request.getSession().getAttribute("loggedUser");
		IPlayerDao.getDAO(Source.DB).updateGamePlayed(player);
		IPlayerDao.getDAO(Source.DB).updateZombieKills(player);
		if(result){
			IPlayerDao.getDAO(Source.DB).updateGameWon(player);
			request.getRequestDispatcher("CleanSavedInfoServlet").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("loseResult.jsp").forward(request, response);
	}

}
