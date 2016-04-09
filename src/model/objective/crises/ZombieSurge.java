package model.objective.crises;

import java.util.ArrayList;
import java.util.List;

import model.card.Item;
import model.character.Survivor;
import model.character.Zombie;
import model.location.GameMap;
import model.location.Location;
import model.location.map.Colony;
import model.objective.Crisis;
import model.user.Player;

public class ZombieSurge extends Crisis {
	
	private final int COLONY_CRISIS_ZOMBIES = 6;
	private final int NON_COLONY_LOCATION_ZOMBIES = 1;
	private static ZombieSurge instance = null;
	
	public static ZombieSurge getInstance(){
		if(instance == null)
			instance = new ZombieSurge();
		return instance;
	}
	
	public ZombieSurge() {
		super("Zombie Surge", "resources/zombie_surge.png", Item.Type.TOOL.toString());
	}
	
	
	@Override
	public void loseCrisisObjective(Player player, GameMap map) {
		// add 6 zombies to the colony
		// add 1 zombie to each non-colony location
		
		List<Survivor> locationSurvivors = null;		
		int enteringZombies = 0;
		
		for (int i = 0; i < map.getMap().size(); i++) {

			Location currentLocation = map.getMap().get(i);
			int currentZombiesInLocation = currentLocation.getEntrance().getOcupiedPlaces();
			
			if (map.getMap().get(i) instanceof Colony) {
				enteringZombies = COLONY_CRISIS_ZOMBIES;
			} else {
				enteringZombies = NON_COLONY_LOCATION_ZOMBIES;
			}
			
			for (int m = currentZombiesInLocation; m < currentZombiesInLocation + enteringZombies; m++) {
				if (m < currentLocation.getEntrance().MAX_FREE_PLACES) {
					currentLocation.getEntrance().getPlaces().get(m).setOccupant(new Zombie());
				} else {
					locationSurvivors = getLocationSurvivors(player, map, currentLocation);
					Survivor survivorWithLowestInfluence = getLowestInfluenceSurvivor(locationSurvivors);
					
					if (survivorWithLowestInfluence == null) {
						continue;
					}
					System.out.println(survivorWithLowestInfluence.getName() + " died in the " + survivorWithLowestInfluence.getCurrentLocation().getLocationName() + " because of zombie breach!");
					locationSurvivors.remove(survivorWithLowestInfluence);
					currentLocation.getSurvivors().remove(survivorWithLowestInfluence);
					player.getSurvivors().remove(survivorWithLowestInfluence);
					player.loseMorale();
				}
			}
		}
		
	}

	private Survivor getLowestInfluenceSurvivor(List<Survivor> locationSurvivors) {
		Survivor survivor = null;
		
		for (int i = 0; i < locationSurvivors.size(); i++) {
			if (i == 0) {
				survivor = locationSurvivors.get(i);
				continue;
			}
			
			if (survivor.getInfluence() > locationSurvivors.get(i).getInfluence()) {
				survivor = locationSurvivors.get(i);
			}
		}
		
		return survivor;
	}

	@Override
	public void meetCrisisObjective(Player player, GameMap map) {
		// gain 1 morale
		player.gainMorale();
	}

	private List<Survivor> getLocationSurvivors(Player player, GameMap map, Location location) {
		List<Survivor> survivors = new ArrayList<Survivor>();
		
		for (int i = 0; i < player.getSurvivors().size(); i++) {
			if (player.getSurvivors().get(i).getCurrentLocation().equals(location)) {
				survivors.add(player.getSurvivors().get(i));
			}
		}
		
		return survivors;
	}

}
