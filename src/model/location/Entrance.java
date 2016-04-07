package model.location;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IOccupant;

public class Entrance {
	
	public static int zombieCounter = 1;
	
	public final int MAX_FREE_PLACES;
	private List<Place> places;
	private int freePlaces;
	
	
	public Entrance(int size) {
		this.MAX_FREE_PLACES = size;
		this.freePlaces = this.MAX_FREE_PLACES;
		this.places = new ArrayList<Place>();
		for(int i = 0; i < MAX_FREE_PLACES; i++){
			places.add(new Place());
		}
	}

	
	// GETTERS AND SETTERS
	public int getFreePlaces() {
		return freePlaces;
	}
	
	public void occupyPlace() {
		this.freePlaces--;
	}
	
	public int getMaxFreePlaces() {
		return MAX_FREE_PLACES;
	}

	public List<Place> getPlaces() {
		return places;
	}
	
	public int getZombieCounter() {
		return zombieCounter++;
	}
	
	public void resetZombieCounter() {
		Entrance.zombieCounter = 1;
	}
	
	public int getOcupiedPlaces(){
		int occupied = 0;
		for(Place p : places){
			if(p.isOccupied()){
				occupied++;
			}
		}
		return occupied;
	}
	
	public void removeOccupant(){
		for(Place p : places){
			if(p.isOccupied()){
				p.setOccupant(null);
				this.freePlaces++;
			}
			
		}
	}
}
