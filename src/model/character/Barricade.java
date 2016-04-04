package model.character;

import model.interfaces.IOccupant;

public class Barricade implements IOccupant {
	
	private static int BARRICADE_UNIQUE_ID = 1;
	private int barricadeId;
	private String link;
	
	public Barricade() {
		this.barricadeId = BARRICADE_UNIQUE_ID++;
		this.link = "resources/barricade_token.png";
	}

	public int getBarricadeId() {
		return barricadeId;
	}
	
	@Override
	public String getLink() {
		return link;
	}
	
}
