package model.card;

import model.ability.Ability;
import model.interfaces.Dropable;

public abstract class Item extends Card implements Dropable {

	public static enum Type { FUEL, FOOD, MEDICINE, TOOL, SURVIVOR}

	private String type;
	
	
	public Item(String name, Ability ability, Type type, String link) {
		super(name, ability, link);
		this.type = type.toString().toLowerCase();
	}
	
	
	// --------------------- METHODS --------------------- 

	public boolean useItem(Item item) {
		
		// use item implementation
		// return true;
		
		return false;
	}

	
	// --------------------- GETTERS AND SETTERS --------------------- 
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
