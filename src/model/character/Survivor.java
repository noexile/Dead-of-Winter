package model.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.ability.Ability;
import model.card.Item;
import model.interfaces.Equipable;
import model.interfaces.ICardUser;
import model.interfaces.ISurvivalist;
import model.interfaces.ISurvivor;
import model.interfaces.ItemCarrier;
import model.location.Location;

public class Survivor implements ISurvivalist, ISurvivor, ItemCarrier, Equipable, ICardUser, Comparable<Survivor> {
	
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
	private boolean isAlive;
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
		this.isAlive = true;
	}
	
	
	// ---------------------- METHODS ----------------------
	
	@Override
	public void moveToLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
		this.hasMoved = true;
	}

	@Override
	public int rollForExposure() {
		Random rand = new Random();
		
		return rand.nextInt(12);
	}

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
		this.isAlive = false;
	}
	
	@Override
	public Survivor spreadDisease(Location location) {
		List<ISurvivalist> locationSurvivors = location.getSurvivors();
		System.out.println("SPREAD DISEASE LOCATION NUMBER OF SURVIVORS = " + locationSurvivors.size());
		
		for (int i = 0; i < locationSurvivors.size(); i++) {
			System.out.println("- survivor: " + locationSurvivors.get(i).getName());
		}
		
		Survivor lowestInfluenceSurvivor = null;
		
		if (location.getSurvivors().size() > 1) {
			for (int i = 0; i < locationSurvivors.size(); i++) {
				if (locationSurvivors.get(i) == this) {
					continue;
				}
				
				if (lowestInfluenceSurvivor == null) {
					lowestInfluenceSurvivor = (Survivor) locationSurvivors.get(i);
					continue;
				}
				
				if (((Survivor)locationSurvivors.get(i)).getInfluence() < lowestInfluenceSurvivor.getInfluence()) {
					lowestInfluenceSurvivor = (Survivor) locationSurvivors.get(i);
				}
			}
		}
		
		return lowestInfluenceSurvivor;
	}
	
	public void takeDamage() {
		this.receivedDamage++;
	}
	
	public void receiveFrostBite() {
		this.hasFrostBite = true;
		takeDamage();
	}
	
	// ---------------------- GETTERS AND SETTERS ----------------------
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	public void addAbility(Ability a){
		this.abilities.add(a);
	}
	
	public void addItemToBackpack(Item i){
		this.backpack.add(i);
	}
	
	@Override
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

	public boolean isAlive() {
		return isAlive;
	}

	public void Heal() {
		this.receivedDamage-=1;
	}
	
	public void setHasFrostBite(boolean hasFrostBite) {
		this.hasFrostBite = hasFrostBite;
	}

	@Override
	public int compareTo(Survivor x) {
		if (this.getInfluence() > x.getInfluence()) {
			return 1;
		} else if (this.getInfluence() > x.getInfluence()) {
			return -1;
		}
		return 0;
	}

}
