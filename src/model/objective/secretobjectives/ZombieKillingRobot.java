package model.objective.secretobjectives;

import model.objective.SecretObjectiveGoal;

public class ZombieKillingRobot extends SecretObjectiveGoal {
	
	public static final int WEAPONS_NEEDED = 1;
	public static final int TOOLS_NEEDED = 2;
	
	
	public ZombieKillingRobot() {
		super("Zombie Killing Robot", "resources/zombie_killing_robot.png");
	}

}
