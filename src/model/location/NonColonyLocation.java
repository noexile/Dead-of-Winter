package model.location;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.card.Item;
import model.card.playercards.Food;
import model.card.playercards.Fuel;
import model.card.playercards.Junk;
import model.card.playercards.Medicine;

public abstract class NonColonyLocation extends Location {

	private static final int starting_fuel = 3;
	private static final int starting_food = 3;
	private static final int starting_medicine = 3;
	private static final int starting_tools = 3;

	List<Item> items;
	
	protected NonColonyLocation(int size, String locationname, int survivorsLimit) {
		super(size, locationname, survivorsLimit);
		this.items = new LinkedList<Item>();
		generateItemsInLocation();
	}
	
	
	// METHODS
	protected void generateItemsInLocation() {
		for (int i = 0; i < starting_fuel; i++) {
			items.add(new Fuel());
		}
		
		for (int i = 0; i < starting_food; i++) {
			items.add(new Food());	
		}
		
		for (int i = 0; i < starting_medicine; i++) {
			items.add(new Medicine());
		}
		
		for (int i = 0; i < starting_tools; i++) {
			items.add(new Junk());
		}
		Collections.shuffle(this.items);
		Collections.shuffle(this.items);
	}
	
	
	// GETTERS AND SETTERS
	public List<Item> getItems() {
		return items;
	}
	
}
