package model.character;

import java.util.ArrayList;
import java.util.List;

import model.ability.Ability;
import model.card.Item;
import model.interfaces.Equipable;
import model.interfaces.ICardUser;
import model.interfaces.ISurvivalist;
import model.interfaces.ISurvivor;
import model.interfaces.ItemCarrier;
import model.location.Location;

public abstract class Survivor implements ISurvivalist, ISurvivor, ItemCarrier, Equipable, ICardUser {
	
	public final static int SURVIVOR_MAX_LIFE = 3;
	private String name;
	private String occupation;
	private final byte influence;
	private final byte attackValue;
	private final byte searchValue;
	private Location currentLocation;
	private List<Ability> abilities;
	private List<Item> backpack;
	private boolean hasMoved;	
	private int receivedDamage;
	private boolean hasFrostBite;
	private String link;
	
	
	public Survivor(String name, String occupation, byte influence, byte attackValue, byte searchValue, Location currentLocation, Ability ability, String link) {
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
		this.link = link;
	}
	
	
	// ---------------------- methods ----------------------
	@Override
	public void attack() {
		//TO DO
//		if(ability != "when attack dont roll die"){
			this.rollZombieDie();
//		}
		
	}
	private void rollZombieDie() {
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
	public boolean useCardAbility(Item item) {
		// TODO Auto-generated method stub
		return false;
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
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	public void addAbility(Ability a){
		this.abilities.add(a);
	}
	
	public void addItemToBackpack(Item i){
		this.backpack.add(i);
	}
	
	public void moveTo(Location currentLocation) {
		this.currentLocation = currentLocation;
		this.hasMoved = true;
	}
	
	public String getName() {
		return name;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public byte getInfluence() {
		return influence;
	}
	
	public byte getAttackValue() {
		return attackValue;
	}
	
	public byte getSearchValue() {
		return searchValue;
	}
	
	public List<Ability> getAbility() {
		return abilities;
	}
	
	public boolean getHasMoved() {
		return this.hasMoved;
	}
	
	public void resetMove(){
		this.hasMoved = false;
	}

	public List<Ability> getAbilities() {
		return abilities;
	}

	public List<Item> getBackpack() {
		return backpack;
	}

	public int getReceivedDamage() {
		return receivedDamage;
	}

	public boolean isHasFrostBite() {
		return hasFrostBite;
	}

	public String getLink() {
		return link;
	}

}
