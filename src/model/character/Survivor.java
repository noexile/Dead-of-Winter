package model.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.card.Item;
import model.interfaces.ISurvivalist;
import model.interfaces.ISurvivor;
import model.location.GameMap;
import model.location.Location;

public class Survivor implements ISurvivalist, ISurvivor, Comparable<Survivor> {

	public final static int SURVIVOR_MAX_LIFE = 3;
	private String name;
	private final int influence;
	private final int attackValue;
	private final int searchValue;
	private Location currentLocation;
	private List<Item> backpack;
	private boolean hasMoved;
	private int receivedDamage;
	private boolean hasFrostBite;
	private boolean isAlive;
	private String link;

	public Survivor(String name, int influence, int attackValue, int searchValue, String currentLocation, String link) {
		this.name = name;
		this.influence = influence;
		this.attackValue = attackValue;
		this.searchValue = searchValue;
		this.currentLocation = getStartingLocation(currentLocation);
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

				if (((Survivor) locationSurvivors.get(i)).getInfluence() < lowestInfluenceSurvivor.getInfluence()) {
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

	public void addItemToBackpack(Item i) {
		this.backpack.add(i);
	}

	@Override
	public String getName() {
		return name;
	}

	public int getInfluence() {
		return influence;
	}

	public int getAttackValue() {
		return attackValue;
	}

	public int getSearchValue() {
		return searchValue;
	}

	public boolean getHasMoved() {
		return this.hasMoved;
	}

	public void resetMove() {
		this.hasMoved = false;
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
		this.receivedDamage -= 1;
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

	private Location getStartingLocation(String currentLocation) {
		List<Location> allLocations = GameMap.getMap();
		Location location = null;

		for (int i = 0; i < allLocations.size(); i++) {
			if (allLocations.get(i).getLocationName().equalsIgnoreCase(currentLocation)) {
				location = allLocations.get(i);
				break;
			}
		}

		return location;
	}

}
