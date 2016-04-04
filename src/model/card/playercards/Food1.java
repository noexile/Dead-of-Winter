package model.card.playercards;

import model.ability.Ability;
import model.card.Item;
import model.card.PlayerCard;

public class Food1 extends PlayerCard {

	
	public Food1(Ability ability) {
		super("Food", ability, Item.Type.FOOD, "resources/food1.png");
	}

}
