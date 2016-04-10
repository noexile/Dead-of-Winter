package model.character.survivors;

import model.character.Survivor;
import model.location.Location;

public class AlexisGrey extends Survivor {

	
	public AlexisGrey(Location currentLocation) {
		super("Alexis Grey", "Librarian", (byte) 46, (byte) 5, (byte) 4, currentLocation, "resources/alexis_grey.png");
	}

}
