package model.character;

import model.interfaces.IOccupant;

public class Zombie implements IOccupant {
	
	private static int ZOMBIE_UNIQUE_ID = 1;
	private int zombieId;
	private String link;
	
	public Zombie() {
		this.zombieId = ZOMBIE_UNIQUE_ID++;
		this.link = "resources/zombie_token.png";
	}

	public int getZombieId() {
		return zombieId;
	}

	@Override
	public String getLink() {
		return link;
	}

}
