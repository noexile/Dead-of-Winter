package model.card;

public  class Item {

	public static enum Type { FUEL, FOOD, MEDICINE, TOOL, SURVIVOR}
	private String name;
	private String type;
	private String link;
	

	public Item(String name, String type, String link) {
		this.name = name;
		this.link = link;
		this.type = type;
	}
	
	
	// --------------------- GETTERS AND SETTERS --------------------- 
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLink() {
		return link;
	}
	
}
