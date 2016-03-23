package model.location;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.card.Item;
import model.character.Survivor;

public abstract class NonColonyLocation extends Location {

	Queue<Item> items;
	List<Survivor> survivors;
	
	protected NonColonyLocation(int size, String locationname) {
		super(size, locationname);
		this.items = new LinkedList<Item>();
		this.survivors = new ArrayList<Survivor>();
	}
	
	protected abstract void generateItemsInLocation();
}
