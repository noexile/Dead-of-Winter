package model.card;

import java.util.List;

import model.ability.Ability;
import model.interfaces.Dropable;
import model.location.Location;

public class PlayerCard extends Item implements Dropable {
	
	private Location useOnLocation;
	
	
	public PlayerCard(String name, Ability ability, Item.Type type, Location useOnLocation) {
		super(name, ability, type);
		this.setUseOnLocation(useOnLocation);
	}
	
	
	// --------------------- METHODS --------------------- 
	@Override
	public void dropItems(List<Item> items) {
		// TODO Auto-generated method stub
		
	}
	
	
	// --------------------- GETTERS AND SETTERS --------------------- 
	public Location getUseOnLocation() {
		return useOnLocation;
	}

	public void setUseOnLocation(Location useOnLocation) {
		this.useOnLocation = useOnLocation;
	}

}
