package model.objective;

public class MainObjective extends Objective {
	
	private Setup setUp;
	private MainObjectiveGoal goal;
	private String time;
	private boolean isHardMode;
	
	
	public MainObjective(boolean isHardMode) {
		this.isHardMode = isHardMode;

		super.setName("We need more samples");
		this.setUp = Setup.getInstance(isHardMode);
		this.goal = MainObjectiveGoal.getInstance(isHardMode);
		this.time = "Short";
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
	
}
