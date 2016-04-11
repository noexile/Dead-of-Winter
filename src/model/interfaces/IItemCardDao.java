package model.interfaces;

import java.util.List;

import model.card.Item;
import model.db.DBItemCardDao;

public interface IItemCardDao {


	enum DataS {
		DB, JSON, XML, CSV, PLC
	}
	
	static IItemCardDao getDAO(DataS ds) {
		switch (ds) {
		case DB:
			return DBItemCardDao.getInstance();
		default:
			throw new IllegalArgumentException();
		}
	}
	

	List<Item> getItemCards();
}
