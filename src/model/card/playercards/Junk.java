package model.card.playercards;

import model.ability.Ability;
import model.card.Item;
import model.card.PlayerCard;

public class Junk extends PlayerCard {

	
	public Junk(Ability ability) {
		super("Junk", ability, Item.Type.TOOL, "resources/junk.png");
	}

}
