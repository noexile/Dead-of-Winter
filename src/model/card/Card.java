package model.card;

import model.ability.Ability;

public abstract class Card {

	private String cardId;
	private String name;
	private Ability ability;
	
	public Card(String name, Ability ability) {
		this.name = name;
		this.ability = ability;
	}
	
	String getName() {
		return name;
		
	}
	
	Ability getAbility() {
		return ability;
	}

	public String getCardId() {
		return cardId;
	}
	
}
