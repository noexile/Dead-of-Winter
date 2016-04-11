package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.character.Survivor;
import model.interfaces.ISurvivorDao;
import model.user.User;

public class DBSurvivorDao implements ISurvivorDao{

	private List<Survivor> allSurvivors = new ArrayList<Survivor>();
	private DBManager manager;
	private static DBSurvivorDao instance;
	
	private DBSurvivorDao() {
		manager = DBManager.getInstance();
	}
	
	public static DBSurvivorDao getInstance(){
		if(instance == null)
			instance = new DBSurvivorDao();
		return instance;
	}

	@Override
	public List<Survivor> getSurvivors() {
		if(this.allSurvivors.size()<1){
			try (Statement st = DBManager.getInstance().getConnection().createStatement()) {
				String query = "SELECT name, influence, attackValue, searchValue, link FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.SURVIVORS.toString();
				ResultSet rs = st.executeQuery(query);
				
				while (rs.next()) {
					String name = rs.getString("name");
					int influence = rs.getInt("influence");
					int attackValue = rs.getInt("attackValue");
					int searchValue = rs.getInt("searchValue");
					String link = rs.getString("link");
					
					Survivor survivor = new Survivor(name, influence, attackValue, searchValue, link);
					this.allSurvivors.add(survivor);
				}
			} catch (SQLException e) {
			} 
		}
		
		return this.allSurvivors;
	}
}
