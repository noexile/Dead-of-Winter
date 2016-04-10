package model.character.survivors;

import model.character.Survivor;
import model.location.Location;

public class BuddyDavis extends Survivor {

	
	public BuddyDavis(Location currentLocation) {
		super("Buddy Davis", "Fitness Trainer", (byte) 36, (byte) 2, (byte) 4, currentLocation, "resources/buddy_davis.png");
	}

}
