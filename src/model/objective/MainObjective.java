package model.objective;

public class MainObjective extends Objective {
	
	private Setup setUp;
	private MainObjectiveGoal goal;
	private String time;
	private boolean isHardMode;
	private String link;
	
	
	public MainObjective(boolean isHardMode) {
		this.isHardMode = isHardMode;

		super.setName("We need more samples");
		this.setUp = Setup.getInstance(isHardMode);
		this.goal = MainObjectiveGoal.getInstance(isHardMode);
		this.time = "Short";
		if (isHardMode) {
			this.link = "resources/we_need_more_samples_hardcore.png";
		} else {
			this.link = "resources/we_need_more_samples_normal.png";
		}
	}
	
	
	// GETTERS AND SETTERS
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

	public String getLink() {
		return link;
	}

}
