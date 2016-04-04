package model.character;

import model.interfaces.IOccupant;

public class Barricade implements IOccupant {
	
	private static int BARRICADE_UNIQUE_ID = 1;
	private int barricadeId;

	public Barricade() {
		this.barricadeId = BARRICADE_UNIQUE_ID++;
	}

	public int getSurvivorId() {
		return barricadeId;
	}
	
}
