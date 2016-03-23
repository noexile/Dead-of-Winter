package model.character;

import model.interfaces.ISurvivalist;

public class HelplessSurvivor implements ISurvivalist {
	
	private static int HELPLESS_SURVIVOR_UNIQUE_ID = 1;
	private int survivorId;

	public HelplessSurvivor() {
		this.survivorId = HELPLESS_SURVIVOR_UNIQUE_ID++;
	}

	public int getSurvivorId() {
		return survivorId;
	}
	
}
