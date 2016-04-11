package model.interfaces;

import model.db.DBPlayerDao;
import model.user.Player;
import model.user.User;

public interface IPlayerDao {
	
	enum Source {
		DB, JSON, XML, CSV, PLC
	}
	
	static IPlayerDao getDAO(Source ds) {
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
	void insertPlayerInDb(User user);
	void updateZombieKills(Player player);
	int getZombieKills(User user);
}
