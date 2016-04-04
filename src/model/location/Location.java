package model.location;

public abstract class Location {
	
	private String locationName;
	private Entrance[] entrances;
	
	protected Location(int size, String locationName) {
		this.entrances = new Entrance[size];
		this.locationName = locationName;
	}

	
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
}
