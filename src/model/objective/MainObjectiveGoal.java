package model.objective;

public class MainObjectiveGoal {

	private int zombieKills;
	private int maxZombieKills;
	private String victory;
	private static int PLAYER_COUNT;//TO DO
	private final static int NORMAL_OBJECTIVE_ZOMBIE_KILLS = 3*PLAYER_COUNT;
	private final static int HARD_CORE_OBJEECTIVE_ZOMBIE_KILLS = 4*PLAYER_COUNT;
	
	private static MainObjectiveGoal instance = null;
	
	private MainObjectiveGoal(boolean isHardMode) {
		this.zombieKills = 0;
		if(isHardMode){
			this.maxZombieKills = HARD_CORE_OBJEECTIVE_ZOMBIE_KILLS;
		}
		else{
			this.maxZombieKills = NORMAL_OBJECTIVE_ZOMBIE_KILLS;
		}
		this.victory = "Every time a zombie is killed roll a die. If the die result is 4 or higher add a zombie token to this objective. Accumulate " + 
		(isHardMode ? HARD_CORE_OBJEECTIVE_ZOMBIE_KILLS : NORMAL_OBJECTIVE_ZOMBIE_KILLS) + " zombies on this main objective for each player that started the game";
	}
	
	public static MainObjectiveGoal getInstance(boolean isHardMode) {
		if(instance == null) {
	         instance = new MainObjectiveGoal(isHardMode);
	      }
	      return instance;
	}
	public int getZombieKills() {
		return zombieKills;
	}
	public void setZombieKills(int zombieKills) {
		this.zombieKills = zombieKills;
	}
	public String getVictory() {
		return victory;
	}
	public int getMaxZombieKills(){
		return maxZombieKills;
	}
	
}
