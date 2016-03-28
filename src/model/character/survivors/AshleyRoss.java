package model.character.survivors;

import model.ability.Ability;
import model.character.Survivor;
import model.location.Location;

public class AshleyRoss extends Survivor {

	
	public AshleyRoss(Location currentLocation, Ability ability) {
		super("Ashley Ross", "Construction Worker", (byte) 52, (byte) 2, (byte) 5, currentLocation, ability, "resources/ashley_ross.png");
	}

}
