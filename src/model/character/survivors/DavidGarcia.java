package model.character.survivors;

import model.ability.Ability;
import model.character.Survivor;
import model.location.Location;

public class DavidGarcia extends Survivor {

	
	public DavidGarcia(Location currentLocation, Ability ability) {
		super("David Garcia", "Accountant", (byte) 50, (byte) 4, (byte) 3, currentLocation, ability, "resources/david_garcia.png");
	}

}
