package model.location;

public class Entrance {
	
	private Place[] places;
	private int freePlaces;
	
	
	public Entrance(int size) {
		this.places = new Place[size];
		this.freePlaces = size;
	}
	
	
	public int getFreePlaces() {
		return freePlaces;
	}
	
}
