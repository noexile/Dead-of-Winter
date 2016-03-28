package model.character.survivors;

import model.ability.Ability;
import model.character.Survivor;
import model.location.Location;

public class AndrewEvans extends Survivor {

	
	public AndrewEvans(Location currentLocation, Ability ability) {
		super("Andrew Evans", "Farmer", (byte) 12, (byte) 3, (byte) 3, currentLocation, ability, "resources/andrew_evans.png");
	}

}
