package model.card;

import model.ability.Ability;

public abstract class Card {

	private String cardId;
	private String name;
	private Ability ability;
	private String link;
	
	
	public Card(String name, Ability ability, String link) {
		this.name = name;
		this.ability = ability;
		this.link = link;
	}
	
	
	public String getName() {
		return name;
		
	}
	
	public Ability getAbility() {
		return ability;
	}

	public String getCardId() {
		return cardId;
	}
	
	public String getLink() {
		return link;
	}
	
}
