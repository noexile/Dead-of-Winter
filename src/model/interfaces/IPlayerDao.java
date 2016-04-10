package model.interfaces;

import model.db.DBPlayerDao;
import model.user.Player;
import model.user.User;

public interface IPlayerDao {
	
	enum DataSource {
		DB, JSON, XML, CSV, PLC
	}
	
	static IPlayerDao getDAO(DataSource ds) {
		switch (ds) {
		case DB:
			return DBPlayerDao.getInstance();
		default:
			throw new IllegalArgumentException();
		}
	}
	int getGameWon(User user);
	int getGamesPlayed(User user);
	void updateGameWon(Player player);
	void updateGamePlayed(Player player);
}
