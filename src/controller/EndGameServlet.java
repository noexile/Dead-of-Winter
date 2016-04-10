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

@WebServlet("/EndGameServlet")
public class EndGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Player player = (Player) request.getSession().getAttribute("player");
		IPlayerDao.getDAO(DataSource.DB).updateGamePlayed(player);
		if((boolean) request.getSession().getAttribute("result")){
			IPlayerDao.getDAO(DataSource.DB).updateGameWon(player);
		}
		System.out.println("Eeeeemi chestito ... poradi edna ili druga prichina si tuk :)");
	}

}
