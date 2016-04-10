package model.interfaces;

import model.db.DBPlayerDao;
import model.user.Player;

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
	int getGameWon(Player player);
	int getGamesPlayed(Player player);
	void updateGameWon(Player player);
	void updateGamePlayed(Player player);
}
