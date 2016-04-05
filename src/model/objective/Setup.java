package model.objective;

public class Setup {

	private static final int HARD_CORE_STARTING_ROUNDS = 5;
	private static final int HARD_CORE_STARTING_MORALE = 6;
	private static final int HARD_CORE_STARTING_ZOMBIES_AT_COLONY = 3;
	private static final int HARD_CORE_STARTING_ZOMBIES_AT_NON_COLONY_LOCATIONS = 3;
	private static final int NORMAL_STARTING_ROUNDS = 6;
	private static final int NORMAL_STARTING_MORALE = 6;
	private static final int NORMAL_STARTING_ZOMBIES_AT_COLONY = 1;
	private static final int NORMAL_STARTING_ZOMBIES_AT_NON_COLONY_LOCATIONS = 1;
	
	private int startingZombiesAtColony;
	private int startingZombiesAtNoNColonyLocations;
	private int startingMorale;
	private int startingRound;
	

	private static Setup instance;
	
	private Setup(boolean isHardMode) {
		if(isHardMode) {
			this.startingRound = HARD_CORE_STARTING_ROUNDS;
			this.startingMorale = HARD_CORE_STARTING_MORALE;
			
			this.startingZombiesAtColony = HARD_CORE_STARTING_ZOMBIES_AT_COLONY;
			this.startingZombiesAtNoNColonyLocations = HARD_CORE_STARTING_ZOMBIES_AT_NON_COLONY_LOCATIONS;
		} else {
			this.startingRound = NORMAL_STARTING_ROUNDS;
			this.startingMorale = NORMAL_STARTING_MORALE;
			this.startingZombiesAtColony = NORMAL_STARTING_ZOMBIES_AT_COLONY;
			this.startingZombiesAtNoNColonyLocations = NORMAL_STARTING_ZOMBIES_AT_NON_COLONY_LOCATIONS;
		}
	}
	
	public static Setup getInstance(boolean isHardMode) {
		
		if (instance == null) {
			instance = new Setup(isHardMode);
		}
		
		return instance;
	}
	
	
	// GETTERS AND SETTERS
	public int getStartingZombiesAtColony() {
		return startingZombiesAtColony;
	}

	public int getStartingZombiesAtNoNColonyLocations() {
		return startingZombiesAtNoNColonyLocations;
	}

	public int getStartingMorale() {
		return startingMorale;
	}

	public int getStartingRound() {
		return startingRound;
	}
	
}
