package model.character.survivors;

import model.character.Survivor;
import model.location.Location;

public class BrandonKane extends Survivor {

	
	public BrandonKane(Location currentLocation) {
		super("Brandon Kane", "Janitor", (byte) 26, (byte) 2, (byte) 4, currentLocation, "resources/brandon_kane.png");
	}

}
