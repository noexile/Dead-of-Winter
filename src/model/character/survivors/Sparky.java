package model.character.survivors;

import model.ability.Ability;
import model.character.Survivor;
import model.location.Location;

public class Sparky extends Survivor {

	
	public Sparky(Location currentLocation, Ability ability) {
		super("Sparky", "Stunt Dog", (byte) 10, (byte) 2, (byte) 2, currentLocation, ability, "resources/sparky.png");
	}

}
