package model.character.survivors;

import model.character.Survivor;
import model.location.Location;

public class DavidGarcia extends Survivor {

	
	public DavidGarcia(Location currentLocation) {
		super("David Garcia", "Accountant", (byte) 50, (byte) 4, (byte) 3, currentLocation, "resources/david_garcia.png");
	}

}
