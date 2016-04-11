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

	private static List<Location> map;

	public GameMap(Colony colony, PoliceStation policeStation, GroceryStore groceryStore, School school, Library library, Hospital hospital, GasStation gasStation) {
		map = new ArrayList<Location>();

		// adding items to a list for printing
		map.add(colony);
		map.add(policeStation);
		map.add(groceryStore);
		map.add(school);
		map.add(library);
		map.add(hospital);
		map.add(gasStation);
	}

	// GETTERS AND SETTERS
	public static Colony getColony() {
		return (Colony) map.get(0);
	}

	public static PoliceStation getPoliceStation() {
		return (PoliceStation) map.get(1);
	}

	public static GroceryStore getGroceryStore() {
		return (GroceryStore) map.get(2);
	}

	public static School getSchool() {
		return (School) map.get(3);
	}

	public static Library getLibrary() {
		return (Library) map.get(4);
	}

	public static Hospital getHospital() {
		return (Hospital) map.get(5);
	}

	public static GasStation getGasStation() {
		return (GasStation) map.get(6);
	}

	public static List<Location> getMap() {
		return map;
	}

}