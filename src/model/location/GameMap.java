package model.location;

import java.util.ArrayList;
import java.util.List;

import model.location.map.Colony;
import model.location.map.GasStation;
import model.location.map.GroceryStore;
import model.location.map.Hospital;
import model.location.map.Library;
import model.location.map.PoliceStation;
import model.location.map.School;

public class GameMap {
	
	private Colony colony;
	private PoliceStation policeStation;
	private GroceryStore groceryStore;
	private School school;
	private Library library;
	private Hospital hospital;
	private GasStation gasStation;
	
	private List<Location> map;
	
	
	public GameMap(Colony colony, PoliceStation policeStation, GroceryStore groceryStore, School school, Library library, Hospital hospital, GasStation gasStation) {
		this.colony = colony;
		this.gasStation = gasStation;
		this.groceryStore = groceryStore;
		this.policeStation = policeStation;
		this.hospital = hospital;
		this.library = library;
		this.school = school;
		this.map = new ArrayList<Location>();
		
		// adding items to a list for printing
		this.map.add(colony);
		this.map.add(policeStation);
		this.map.add(groceryStore);
		this.map.add(school);
		this.map.add(library);
		this.map.add(hospital);
		this.map.add(gasStation);
	}

	
	// GETTERS AND SETTERS
	public Colony getColony() {
		return colony;
	}

	public PoliceStation getPoliceStation() {
		return policeStation;
	}

	public GroceryStore getGroceryStore() {
		return groceryStore;
	}

	public School getSchool() {
		return school;
	}

	public Library getLibrary() {
		return library;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public GasStation getGasStation() {
		return gasStation;
	}

	public List<Location> getMap() {
		return map;
	}
	
}
