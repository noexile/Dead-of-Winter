package model.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.interfaces.IPlayerDao;
import model.user.Player;
import model.user.User;

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
	public int getGamesPlayed(User user) {
		String query = "SELECT game_played FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.STATS.toString() + " WHERE player_id =  ? ;";
		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(query)) {
			st.setInt(1, user.getId());
			ResultSet rs = st.executeQuery();
			rs.next();
			int gamesPlayed = rs.getInt("game_played");
			return gamesPlayed;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} 
	}

	@Override
	public int getGameWon(User user) {
		String query = "SELECT game_won FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.STATS.toString() + " WHERE player_id =  ? ;";
		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(query)) {
			st.setInt(1, user.getId());
			ResultSet rs = st.executeQuery();
			rs.next();
			int gamesPlayed = rs.getInt("game_won");
			return gamesPlayed;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} 
	}

	@Override
	public void updateGameWon(Player player) {
		try (PreparedStatement ps = DBManager.getInstance().getConnection().prepareStatement("UPDATE STATS SET game_won = game_won+1 WHERE player_id='" + player.getId() + "'")) {
			ps.executeUpdate();
			ps.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateGamePlayed(Player player) {
		try (PreparedStatement ps = DBManager.getInstance().getConnection().prepareStatement("UPDATE STATS SET game_played = game_played+1 WHERE player_id='" + player.getId() + "'")) {
			ps.executeUpdate();
			ps.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertPlayerInDb(User user) {
		String query = "INSERT INTO " + DBManager.getDbName() + "." + DBManager.ColumnNames.STATS.toString() + " (player_id, game_played, game_won) VALUES ( ? , ? , ? )";
		
		try (PreparedStatement prepStatement = DBManager.getInstance().getConnection().prepareStatement(query)) {	
			prepStatement.setInt(1, user.getId());
			prepStatement.setInt(2, 0);
			prepStatement.setInt(3, 0);
			prepStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void updateZombieKills(Player player) {
		try (PreparedStatement ps = DBManager.getInstance().getConnection().prepareStatement("UPDATE STATS SET zombies_killed = zombies_killed+" + player.getZombieKills()+ " WHERE player_id='" + player.getId() + "'")) {
			ps.executeUpdate();
			ps.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getZombieKills(User user) {
		String query = "SELECT zombies_killed FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.STATS.toString() + " WHERE player_id =  ? ;";
		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(query)) {
			st.setInt(1, user.getId());
			ResultSet rs = st.executeQuery();
			rs.next();
			int zombiesKilled = rs.getInt("zombies_killed");
			return zombiesKilled;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} 
	}
	
	

}
