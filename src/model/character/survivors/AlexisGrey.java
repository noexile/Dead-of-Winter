package model.character.survivors;

import model.ability.Ability;
import model.character.Survivor;
import model.location.Location;

public class AlexisGrey extends Survivor {

	
	public AlexisGrey(Location currentLocation, Ability ability) {
		super("Alexis Grey", "Librarian", (byte) 46, (byte) 5, (byte) 4, currentLocation, ability, "resources/alexis_grey.png");
	}

}
