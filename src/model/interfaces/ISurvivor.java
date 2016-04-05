package model.interfaces;

import model.ability.Ability;
import model.character.Survivor;
import model.location.Location;

public interface ISurvivor {
	
	void attack();
	void search(Location location);
	void barricade(Location location);
	void cleanWaste();
	void attractZombies(Location location);
	void useAbility(Ability ability);
	void die();
	void moveToLocation(Location location);
	int rollForExposure();
	Survivor spreadDisease(Location location);
	
}
