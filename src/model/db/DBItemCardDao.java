package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.card.Item;
import model.character.Survivor;
import model.interfaces.IItemCardDao;

public class DBItemCardDao implements IItemCardDao{

	public List<Item> allItems = new ArrayList<Item>();
	private DBManager manager;
	private static DBItemCardDao instance;
	
	private DBItemCardDao() {
		manager = DBManager.getInstance();
	}
	
	public static DBItemCardDao getInstance(){
		if(instance == null)
			instance = new DBItemCardDao();
		return instance;
	}

	@Override
	public List<Item> getItemCards() {
		if(this.allItems.size()<1){
			try (Statement st = DBManager.getInstance().getConnection().createStatement()) {
				String query = "SELECT name, type,link FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.ITEMS.toString() + "";
				ResultSet rs = st.executeQuery(query);
				
				while (rs.next()) {
					String name = rs.getString("name");
					String type = rs.getString("type");
					String link = rs.getString("link");
					
					Item item = new Item(name, type, link);
					this.allItems.add(item);
				}
			} catch (SQLException e) {
			} 
		}
		
		return this.allItems;
		
	}
}
