package model.character.survivors;

import model.character.Survivor;
import model.location.Location;

public class AndrewEvans extends Survivor {

	
	public AndrewEvans(Location currentLocation) {
		super("Andrew Evans", "Farmer", (byte) 12, (byte) 3, (byte) 3, currentLocation, "resources/andrew_evans.png");
	}

}
