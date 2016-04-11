package model.interfaces;

import java.util.List;

import model.character.Survivor;
import model.db.DBSurvivorDao;

public interface ISurvivorDao {


	enum DS {
		DB, JSON, XML, CSV, PLC
	}
	
	static ISurvivorDao getDAO(DS ds) {
		switch (ds) {
		case DB:
			return DBSurvivorDao.getInstance();
		default:
			throw new IllegalArgumentException();
		}
	}
	
	List<Survivor> getSurvivors();
}
