package model.character;

import model.interfaces.IOccupant;

public class Zombie implements IOccupant {
	
	private static int ZOMBIE_UNIQUE_ID = 1;
	private int zombieId;

	public Zombie() {
		this.zombieId = ZOMBIE_UNIQUE_ID++;
	}

	public int getSurvivorId() {
		return zombieId;
	}
}
