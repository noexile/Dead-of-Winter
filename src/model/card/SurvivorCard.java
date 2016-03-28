package model.card;

import java.util.List;

import model.ability.Ability;
import model.interfaces.Equipable;

public class SurvivorCard extends Item implements Equipable {

	
	public SurvivorCard(String name, Ability ability, Type type, String link) {
		super(name, ability, type, link);
	}

	
	@Override
	public void dropItems(List<Item> items) {
		// TODO Auto-generated method stub
	}

	@Override
	public void equipItem(Item item) {
		// TODO Auto-generated method stub
	}

	@Override
	public void unEquipItem(Item item) {
		// TODO Auto-generated method stub
	}

	@Override
	public void pickUpItem(Item item) {
		// TODO Auto-generated method stub
	}

}
