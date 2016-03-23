package model.interfaces;

import model.ability.Ability;
import model.location.Location;

public interface ISurvivor {
	
	void attack(); // TODO
	void search(Location location);
	void barricade(Location location);
	void cleanWaste();
	void attractZombies(Location location);
	void useAbility(Ability ability);
	void die();
	
}
