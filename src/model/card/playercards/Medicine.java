package model.card.playercards;

import model.ability.Ability;
import model.card.Item;
import model.card.PlayerCard;

public class Medicine extends PlayerCard {
	
	
	public Medicine(Ability ability) {
		super("Medicine", ability, Item.Type.MEDICINE, "resources/medicine.png");
	}

}
