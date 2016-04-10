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


@WebServlet("/StatisticServlet")
public class StatisticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loggedUser") !=null){		
			Player player = (Player) request.getSession().getAttribute("player");
			int played = IPlayerDao.getDAO(DataSource.DB).getGamesPlayed(player);
			int won = IPlayerDao.getDAO(DataSource.DB).getGameWon(player);
			request.getSession().setAttribute("gamePlayed", played);
			request.getSession().setAttribute("gameWon", won);
		}
		else{
			request.getSession().setAttribute("notLogged", "You need to be logged in in order to see your stats");
		}
		request.getRequestDispatcher("statsPage.jsp").forward(request, response);
	}

}
