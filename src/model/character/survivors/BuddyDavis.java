package model.character.survivors;

import model.ability.Ability;
import model.character.Survivor;
import model.location.Location;

public class BuddyDavis extends Survivor {

	
	public BuddyDavis(Location currentLocation, Ability ability) {
		super("Buddy Davis", "Fitness Trainer", (byte) 36, (byte) 2, (byte) 4, currentLocation, ability, "resources/buddy_davis.png");
	}

}
