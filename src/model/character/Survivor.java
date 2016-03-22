package model.character;

import model.ability.Ability;
import model.interfaces.ISurvivor;
import model.interfaces.ItemCarrier;
import model.item.Item;
import model.location.Location;

abstract class Survivor implements ISurvivor, ItemCarrier{
	
	private String name;
	private String occupation;
	private byte influence;
	private byte attackValue;
	private byte searchValue;
	private Location currentLocation;
	private Ability ability;
	
	
	Survivor(String name, String occupation, byte influence, byte attackValue, byte searchValue, Location currentLocation, Ability ability) {
		this.name = name;
		this.occupation = occupation;
		this.influence = influence;
		this.attackValue = attackValue;
		this.searchValue = searchValue;
		this.currentLocation = currentLocation;
		this.ability = ability;
	}
	
	
	// ---------------------- methods ----------------------
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void search(Location location) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void barricade(Location location) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void cleanWaste() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void attractZombies(Location location) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pickUpItem(Item item) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dropItem(Item item) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void equipItem(Item item) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void unequipItem(Item item) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void transferItem(Item item, ItemCarrier to) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void takeItemFromStash(Item item) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void useAbility(Ability ability) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void die() {

		spreadDisease();
	}
	
	private void spreadDisease() {
		// TODO Auto-generated method stub
		
	}
	
	
	// ---------------------- getters and setters ----------------------
	Location getCurrentLocation() {
		return currentLocation;
	}
	
	void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	String getName() {
		return name;
	}
	
	String getOccupation() {
		return occupation;
	}
	
	byte getInfluence() {
		return influence;
	}
	
	byte getAttackValue() {
		return attackValue;
	}
	
	byte getSearchValue() {
		return searchValue;
	}
	
	Ability getAbility() {
		return ability;
	}

	
}
