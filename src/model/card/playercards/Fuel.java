package model.card.playercards;

import model.ability.Ability;
import model.card.Item;
import model.card.PlayerCard;

public class Fuel extends PlayerCard {

	
	public Fuel(Ability ability) {
		super("Fuel", ability, Item.Type.FUEL, "resources/fuel.png");
	}

}
