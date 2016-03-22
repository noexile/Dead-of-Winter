package model.character;

import model.ability.Ability;
import model.interfaces.ItemCarrier;
import model.item.Item;
import model.location.Location;

public class SurvivorManager {
	
	Survivor survivor;
	
	
	public SurvivorManager(Survivor survivor) {
		this.survivor = survivor;
	}
	
	
	// ---------------------- methods ----------------------
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	public void search(Location location) {
		// TODO Auto-generated method stub
		
	}

	public void barricade(Location location) {
		// TODO Auto-generated method stub
		
	}

	public void cleanWaste() {
		// TODO Auto-generated method stub
		
	}

	public void attractZombies(Location location) {
		// TODO Auto-generated method stub
		
	}

	public void pickUpItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	public void dropItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	public void equipItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	public void unequipItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	public void transferItem(Item item, ItemCarrier to) {
		// TODO Auto-generated method stub
	}	

	public void takeItemFromStash(Item item) {
		// TODO Auto-generated method stub
		
	}
	

	public void useAbility(Ability ability) {
		// TODO Auto-generated method stub
		
	}
	

	public void die() {

		spreadDisease();
	}
	
	private void spreadDisease() {
		// TODO Auto-generated method stub
		
	}
	
	
}
