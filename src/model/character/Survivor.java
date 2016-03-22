package model.character;

import java.util.ArrayList;
import java.util.List;

import model.ability.Ability;
import model.interfaces.ISurvivor;
import model.interfaces.ItemCarrier;
import model.item.Item;
import model.location.Location;

class Survivor implements ISurvivor, ItemCarrier, Equipable{
	
	private String name;
	private String occupation;
	private final byte influence;
	private final byte attackValue;
	private final byte searchValue;
	private Location currentLocation;
	private List<Ability> abilities;
	private List<Item> backpack;
	private boolean hasMoved;
	private final static int MAX_LIFE = 3;
	private int receivedDamage;
	private boolean hasFrostBite;
	
	
	Survivor(String name, String occupation, byte influence, byte attackValue, byte searchValue, Location currentLocation, Ability ability) {
		this.name = name;
		this.occupation = occupation;
		this.influence = influence;
		this.attackValue = attackValue;
		this.searchValue = searchValue;
		this.currentLocation = currentLocation;
		this.abilities = new ArrayList<Ability>();
		this.backpack = new ArrayList<Item>();
		this.hasMoved = false;
		this.receivedDamage = 0;
		this.hasFrostBite = false;
	}
	
	
	// ---------------------- methods ----------------------
	@Override
	public void attack() {
		//TO DO
//		if(ability != "when attack dont roll dice"){
//			this.rollZombieDice();
//		}
		
	}
	private void rollZombieDice() {
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
	public void equipItem(Item item) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void unEquipItem(Item item) {
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
	
	void addAbility(Ability a){
		this.abilities.add(a);
	}
	
	void addItemToBackpack(Item i){
		this.backpack.add(i);
	}
	
	void moveTo(Location currentLocation) {
		this.currentLocation = currentLocation;
		this.hasMoved = true;
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
	
	List<Ability> getAbility() {
		return abilities;
	}
	
	boolean getHasMoved() {
		return this.hasMoved;
	}
	
	void resetMove(){
		this.hasMoved = false;
	}
}
