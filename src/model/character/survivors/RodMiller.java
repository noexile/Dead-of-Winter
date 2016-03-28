package model.character.survivors;

import model.ability.Ability;
import model.character.Survivor;
import model.location.Location;

public class RodMiller extends Survivor {

	
	public RodMiller(Location currentLocation, Ability ability) {
		super("Rod Miller", "Truck Driver", (byte) 40, (byte) 3, (byte) 3, currentLocation, ability, "resources/rod_miller.png");
	}

}
