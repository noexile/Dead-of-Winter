package model.objective;

public class Setup {

	private int rounds;
	private int morale;
	//To Do/ adding zombies
	private static final int HARD_CORE_STARTING_ROUNDS = 5;
	private static final int HARD_CORE_STARTING_MORALE =6;
	private static final int NORMAL_STARTING_ROUNDS = 6;
	private static final int NORMAL_STARTING_MORALE =6;
	
	private static Setup instance;
	
	private Setup(boolean isHardMode) {
		if(isHardMode){
			this.rounds = HARD_CORE_STARTING_ROUNDS;
			this.morale = HARD_CORE_STARTING_MORALE;
		}
		else{
			this.rounds = NORMAL_STARTING_ROUNDS;
			this.morale = NORMAL_STARTING_MORALE;
		}
	}
	
	public static Setup getInstance(boolean isHardMode) {
		
		if (instance == null) {
			instance = new Setup(isHardMode);
		}
		
		return instance;
	}
}
