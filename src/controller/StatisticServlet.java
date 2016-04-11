package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.interfaces.IPlayerDao;
import model.interfaces.IPlayerDao.Source;
import model.user.User;


@WebServlet("/StatisticServlet")
public class StatisticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		
		if(request.getSession().getAttribute("loggedUser") !=null){		
			User user = (User) request.getSession().getAttribute("loggedUser");
			int played = IPlayerDao.getDAO(Source.DB).getGamesPlayed(user);
			int won = IPlayerDao.getDAO(Source.DB).getGameWon(user);
			int zombiesKilled = IPlayerDao.getDAO(Source.DB).getZombieKills(user);
			request.getSession().setAttribute("gamePlayed", played);
			request.getSession().setAttribute("gameWon", won);
			request.getSession().setAttribute("zombiesKilled", zombiesKilled);
		}
		else{
			request.getSession().setAttribute("notLogged", "You need to be logged in in order to see your stats");
		}
		request.getRequestDispatcher("statsPage.jsp").forward(request, response);
	}

}
