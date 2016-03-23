package model.objective;

public class MainObjective extends Objective {

	private Setup setUp;
	private MainObjectiveGoal goal;
	private String time;
	private boolean isHardMode;
	
	public MainObjective(boolean isHardMode) {
		this.isHardMode = isHardMode;
		if(isHardMode){
			super.setName("We need more samples");
			this.setUp = Setup.getInstance(isHardMode);
			this.goal = MainObjectiveGoal.getInstance(isHardMode);
			this.time = "Short";
		}
		else{
			super.setName("We need more samples");
			this.setUp = Setup.getInstance(isHardMode);
			this.goal = MainObjectiveGoal.getInstance(isHardMode);
			this.time = "Short";
		}
		
	}
	
}
