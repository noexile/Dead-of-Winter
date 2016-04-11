package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.card.Item;
import model.interfaces.ISecretObjectiveDao;
import model.objective.SecretObjective;
import model.objective.SecretObjectiveGoal;
import model.user.Player;

public class DBSecretObjectiveDao implements ISecretObjectiveDao{

	private List<SecretObjectiveGoal> allSecrets = new ArrayList<SecretObjectiveGoal>();
	private DBManager manager;
	private static DBSecretObjectiveDao instance;
	
	private DBSecretObjectiveDao() {
		manager = DBManager.getInstance();
	}
	
	public static DBSecretObjectiveDao getInstance(){
		if(instance == null)
			instance = new DBSecretObjectiveDao();
		return instance;
	}

	@Override
	public List<SecretObjectiveGoal> getSecretObjectives() {
		if(this.allSecrets.size()<1){
			try (Statement st = DBManager.getInstance().getConnection().createStatement()) {
				String query = "SELECT name, type, link, needed FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.SECRET_OBJECTIVES.toString();
				ResultSet rs = st.executeQuery(query);
				
				while (rs.next()) {
					String name = rs.getString("name");
					String type = rs.getString("type");
					String link = rs.getString("link");
					int needed = rs.getInt("needed");
					
					SecretObjectiveGoal obj = new SecretObjectiveGoal(name, type, link, needed);
					this.allSecrets.add(obj);
				}
				
			} catch (SQLException e) {
			} 
		}
		
		return this.allSecrets;
		
	}
		
}
