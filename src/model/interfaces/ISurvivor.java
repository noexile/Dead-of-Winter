package model.interfaces;

import model.ability.Ability;
import model.item.Item;
import model.location.Location;

public interface ISurvivor {
	
	void attack();
	void search(Location location);
	void barricade(Location location);
	void cleanWaste();
	void attractZombies(Location location);
	void takeItemFromStash(Item item);
	void useAbility(Ability ability);
	void die();
	
}
