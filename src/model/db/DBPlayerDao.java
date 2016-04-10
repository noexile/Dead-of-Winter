package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.interfaces.IPlayerDao;
import model.user.Player;

public class DBPlayerDao implements IPlayerDao{
	

	private DBManager manager;
	private static DBPlayerDao instance;
	
	private DBPlayerDao() {
		manager = DBManager.getInstance();
	}
	
	public static DBPlayerDao getInstance(){
		if(instance == null)
			instance = new DBPlayerDao();
		return instance;
	}

	@Override
	public int getGamesPlayed(Player player) {
		try (Statement st = DBManager.getInstance().getConnection().createStatement()) {
			String query = "SELECT game_played FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.STATS.toString() + "WHERE player_id = '" + player.getId() +"';";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			return rs.getInt("game_won");
		} catch (SQLException e) {
			return 0;
		} 
	}

	@Override
	public int getGameWon(Player player) {
		try (Statement st = DBManager.getInstance().getConnection().createStatement()) {
			String query = "SELECT game_won FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.STATS.toString() + "WHERE player_id = '" + player.getId() +"';";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			return rs.getInt("game_won");
		} catch (SQLException e) {
			return 0;
		} 
	}

	@Override
	public void updateGameWon(Player player) {
		try (Statement st = DBManager.getInstance().getConnection().createStatement()) {
			String query = "UPDATE STATS SET game_won = game_won+1 WHERE player_id='" + player.getId() + "'";
			ResultSet rs = st.executeQuery(query);
		}
		catch (SQLException e) {
		}
	}

	@Override
	public void updateGamePlayed(Player player) {
		try (Statement st = DBManager.getInstance().getConnection().createStatement()) {
			String query = "UPDATE STATS SET game_played = game_won+1 WHERE player_id='" + player.getId() + "'";
			ResultSet rs = st.executeQuery(query);
		}
		catch (SQLException e) {
		}
	}
	
	

}
