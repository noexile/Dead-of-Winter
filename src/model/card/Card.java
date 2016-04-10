package model.card;


public abstract class Card {

	private String cardId;
	private String name;
	private String link;
	
	
	public Card(String name, String link) {
		this.name = name;
		this.link = link;
	}
	
	
	public String getName() {
		return name;
		
	}

	public String getCardId() {
		return cardId;
	}
	
	public String getLink() {
		return link;
	}
	
}
