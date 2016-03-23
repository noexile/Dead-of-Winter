package model.ability;

import model.location.Location;

public abstract class Ability {
	
	private String abilityName;
	private Location abilityLocation;
	
	
	public Ability(String abilityName, Location abilityLocation) {
		this.abilityName = abilityName;
		this.abilityLocation = abilityLocation;
	}


	// --------------------- METHODS --------------------- 
	public boolean useAbility() {
		
		// TODO using ability
		// return true;
		
		return false;
	}
	
	
	// --------------------- GETTERS AND SETTERS --------------------- 
	public String getAbilityName() {
		return abilityName;
	}

	Location getAbilityLocation() {
		return abilityLocation;
	}

}
