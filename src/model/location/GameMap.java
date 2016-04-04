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
	private GasStation gasStation;
	private GroceryStore groceryStore;
	private PoliceStation policeStation;
	private Hospital hospital;
	private Library library;
	private School school;
	
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
	public void setColony(Colony colony) {
		this.colony = colony;
	}
	
	public void setGasStation(GasStation gasStation) {
		this.gasStation = gasStation;
	}
	
	public void setGroceryStore(GroceryStore groceryStore) {
		this.groceryStore = groceryStore;
	}
	
	public void setPoliceStation(PoliceStation policeStation) {
		this.policeStation = policeStation;
	}
	
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	public void setLibrary(Library library) {
		this.library = library;
	}
	
	public void setSchool(School school) {
		this.school = school;
	}

	public List<Location> getMap() {
		return map;
	}
	
}
