package model.interfaces;

import model.character.Survivor;
import model.location.Location;

public interface ISurvivor {
	
	void die();
	void moveToLocation(Location location);
	int rollForExposure();
	Survivor spreadDisease(Location location);
	
}
