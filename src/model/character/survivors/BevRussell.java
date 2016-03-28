package model.character.survivors;

import model.ability.Ability;
import model.character.Survivor;
import model.location.Location;

public class BevRussell extends Survivor {

	
	public BevRussell(Location currentLocation, Ability ability) {
		super("Bev Russell", "Mother", (byte) 34, (byte) 2, (byte) 4, currentLocation, ability, "resources/bev_russell.png");
	}

}
