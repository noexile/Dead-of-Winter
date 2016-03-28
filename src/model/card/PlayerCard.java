package model.card;

import java.util.List;

import model.ability.Ability;
import model.interfaces.Dropable;
import model.location.Location;

public class PlayerCard extends Item implements Dropable {
	
	
	public PlayerCard(String name, Ability ability, Item.Type type, String link) {
		super(name, ability, type, link);
	}
	
	
	// --------------------- METHODS --------------------- 
	@Override
	public void dropItems(List<Item> items) {
		// TODO Auto-generated method stub
		
	}
	
	
	// --------------------- GETTERS AND SETTERS --------------------- 


}
