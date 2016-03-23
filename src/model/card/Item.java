package model.card;

import model.ability.Ability;
import model.interfaces.Dropable;

public abstract class Item extends Card implements Dropable {

	public static enum Type { WEAPON, FUEL, EDUCATION, FOOD, MEDICINE, TOOL, SURVIVOR, ANY_CARD}

	private String type;
	
	
	public Item(String name, Ability ability, Type type) {
		super(name, ability);
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
