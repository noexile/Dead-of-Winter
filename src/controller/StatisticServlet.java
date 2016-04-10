package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.interfaces.IPlayerDao;
import model.interfaces.IPlayerDao.DataSource;
import model.user.User;


@WebServlet("/StatisticServlet")
public class StatisticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		
		if(request.getSession().getAttribute("loggedUser") !=null){		
			User u = (User) request.getSession().getAttribute("loggedUser");
			System.out.println(u.getId());
			int played = IPlayerDao.getDAO(DataSource.DB).getGamesPlayed(u);
			System.out.println(played);
			int won = IPlayerDao.getDAO(DataSource.DB).getGameWon(u);
			System.out.println(won);
			request.getSession().setAttribute("gamePlayed", played);
			request.getSession().setAttribute("gameWon", won);
		}
		else{
			request.getSession().setAttribute("notLogged", "You need to be logged in in order to see your stats");
		}
		request.getRequestDispatcher("statsPage.jsp").forward(request, response);
	}

}
