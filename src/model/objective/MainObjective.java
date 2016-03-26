package model.objective;

public class MainObjective extends Objective {
	
	private static final int NORMAL_MODE_STARTING_MORALE = 6;
	private static final int NORMAL_MODE_STARTING_ROUND = 6;
	private static final int HARDCORE_MODE_STARTING_MORALE = 6;
	private static final int HARDCORE_MODE_STARTING_ROUND = 5;
	
	private Setup setUp;
	private MainObjectiveGoal goal;
	private String time;
	private boolean isHardMode;
	private int startingMorale;
	private int startingRound;
	
	public MainObjective(boolean isHardMode) {
		this.isHardMode = isHardMode;

		super.setName("We need more samples");
		this.setUp = Setup.getInstance(isHardMode);
		this.goal = MainObjectiveGoal.getInstance(isHardMode);
		this.time = "Short";
		
		if (isHardMode) {
			this.startingMorale = HARDCORE_MODE_STARTING_MORALE;
			this.startingRound = HARDCORE_MODE_STARTING_ROUND;
		} else {
			this.startingMorale = NORMAL_MODE_STARTING_MORALE;
			this.startingRound = NORMAL_MODE_STARTING_ROUND;
		}
	}
	
	
	public Setup getSetUp() {
		return setUp;
	}

	public MainObjectiveGoal getGoal() {
		return goal;
	}

	public String getTime() {
		return time;
	}

	public boolean isHardMode() {
		return isHardMode;
	}

	public int getStartingMorale() {
		return startingMorale;
	}

	public int getStartingRound() {
		return startingRound;
	}
	
}
