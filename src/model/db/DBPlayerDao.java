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
		String query = "SELECT game_played FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.STATS.toString() + "WHERE player_id = ( ? );";
		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(query)) {
			st.setInt(1, user.getId());
			ResultSet rs = st.executeQuery();
			int gamesPlayed = rs.getInt("game_played");
			return gamesPlayed;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} 
	}

	@Override
	public int getGameWon(User user) {
		try (Statement st = DBManager.getInstance().getConnection().createStatement()) {
			System.out.println("1");
			String query = "SELECT game_won FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.STATS.toString() + "WHERE player_id = ( ? );";
			System.out.println("2");
			
			
			
			ResultSet rs = st.executeQuery(query);
			System.out.println(rs.getInt("game_won"));
			rs.next();
			return rs.getInt("game_won");
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
	
	

}
