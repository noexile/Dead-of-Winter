package model.location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.card.Item;
import model.card.playercards.Food1;
import model.card.playercards.Fuel;
import model.card.playercards.Junk;
import model.card.playercards.Medicine;
import model.character.Survivor;

public abstract class NonColonyLocation extends Location {

	private static final int starting_fuel = 10;
	private static final int starting_food = 10;
	private static final int starting_medicine = 10;
	private static final int starting_tools = 10;

	List<Item> items;
	List<Survivor> survivors;
	
	protected NonColonyLocation(int size, String locationname) {
		super(size, locationname);
		this.items = new LinkedList<Item>();
		this.survivors = new ArrayList<Survivor>();
		generateItemsInLocation();
	}
	
	
	// METHODS
	protected void generateItemsInLocation() {
		for (int i = 0; i < starting_fuel; i++) {
			items.add(new Fuel(null));
		}
		
		for (int i = 0; i < starting_food; i++) {
			items.add(new Food1(null));	
		}
		
		for (int i = 0; i < starting_medicine; i++) {
			items.add(new Medicine(null));
		}
		
		for (int i = 0; i < starting_tools; i++) {
			items.add(new Junk(null));
		}
		
		Collections.shuffle(this.items);
		Collections.shuffle(this.items);
	}
	
	
	// GETTERS AND SETTERS
	public List<Item> getItems() {
		return items;
	}

	public List<Survivor> getSurvivors() {
		return survivors;
	}
	
}
