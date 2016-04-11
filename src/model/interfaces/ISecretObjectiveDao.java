package model.interfaces;

import java.util.List;

import model.db.DBSecretObjectiveDao;
import model.db.DBUserDao;
import model.objective.SecretObjective;
import model.objective.SecretObjectiveGoal;

public interface ISecretObjectiveDao {


	enum Data {
		DB, JSON, XML, CSV, PLC
	}
	
	static ISecretObjectiveDao getDAO(Data ds) {
		switch (ds) {
		case DB:
			return DBSecretObjectiveDao.getInstance();
		default:
			throw new IllegalArgumentException();
		}
	}
	

	List<SecretObjectiveGoal> getSecretObjectives();
}
