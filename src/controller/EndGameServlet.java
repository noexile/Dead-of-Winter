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
		System.out.println(player.getId());
		User u = (User) request.getSession().getAttribute("loggedUser");
		System.out.println(u.getId());
		IPlayerDao.getDAO(DataSource.DB).updateGamePlayed(player);
		if((boolean) request.getSession().getAttribute("result")){
			IPlayerDao.getDAO(DataSource.DB).updateGameWon(player);
		}
		System.out.println("Eeeeemi chestito ... poradi edna ili druga prichina si tuk :)");
		request.getRequestDispatcher("endGame.jsp").forward(request, response);
	}

}
