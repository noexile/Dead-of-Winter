package model.objective;

public class SecretObjective extends Objective {
	
	SecretObjectiveGoal secretObjectiveGoal;
	
	public SecretObjective(SecretObjectiveGoal secretObjectiveGoal) {
		this.secretObjectiveGoal = secretObjectiveGoal;
	}
	
	
	public SecretObjectiveGoal getSecretObjectiveGoal() {
		return secretObjectiveGoal;
	}
	
}
