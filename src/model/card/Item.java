package model.card;

public abstract class Item extends Card {

	public static enum Type { FUEL, FOOD, MEDICINE, TOOL, SURVIVOR}

	private String type;
	
	
	public Item(String name, Type type, String link) {
		super(name, link);
		this.type = type.toString().toLowerCase();
	}
	
	
	// --------------------- GETTERS AND SETTERS --------------------- 
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
