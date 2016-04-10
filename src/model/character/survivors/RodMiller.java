package model.character.survivors;

import model.character.Survivor;
import model.location.Location;

public class RodMiller extends Survivor {

	
	public RodMiller(Location currentLocation) {
		super("Rod Miller", "Truck Driver", (byte) 40, (byte) 3, (byte) 3, currentLocation, "resources/rod_miller.png");
	}

}
