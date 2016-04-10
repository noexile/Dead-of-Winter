package model.character.survivors;

import model.character.Survivor;
import model.location.Location;

public class BevRussell extends Survivor {

	
	public BevRussell(Location currentLocation) {
		super("Bev Russell", "Mother", (byte) 34, (byte) 2, (byte) 4, currentLocation, "resources/bev_russell.png");
	}

}
