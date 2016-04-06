package model.objective;


public class Crisis {

	private String name;
	private String link;
	private String type;
	private int neededCardsForCrisis;
	
	
	public Crisis(String name, String link, String type, int neededCardsForCrisis) {
		this.name = name;
		this.link = link;
		this.type = type;
		this.neededCardsForCrisis = neededCardsForCrisis;
	}
	
	
	// GETTERS AND SETTERS
	public String getType() {
		return type;
	}

	public int getNeededCardsForCrisis() {
		return neededCardsForCrisis;
	}

	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}
	
}
