package model.location;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.card.Item;
import model.db.DBItemCardDao;

public abstract class NonColonyLocation extends Location {
	
	List<Item> items;
	
	protected NonColonyLocation(int size, String locationname, int survivorsLimit) {
		super(size, locationname, survivorsLimit);
		this.items = new LinkedList<Item>();
		generateItemsInLocation();
	}
	
	
	// METHODS
	public void generateItemsInLocation() {
		for (int i = 1; i < DBItemCardDao.getInstance().getItemCards().size(); i++) {
			items.addAll(DBItemCardDao.getInstance().getItemCards());
		}
		
		Collections.shuffle(this.items);
		Collections.shuffle(this.items);
		
		for (int i = 0; i < items.size(); i++) {
			System.out.println("- " + items.get(i).getName());
		}
	}
	
	
	// GETTERS AND SETTERS
	public List<Item> getItems() {
		return items;
	}
	
}
