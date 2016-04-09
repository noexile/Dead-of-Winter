package model.objective.crises;

import java.util.ArrayList;
import java.util.List;

import model.card.Item;
import model.character.Survivor;
import model.character.Zombie;
import model.location.GameMap;
import model.objective.Crisis;
import model.user.Player;

public class UnendingHordes extends Crisis {
	
	private final int CRISIS_ZOMBIES = 8;
	private static UnendingHordes instance = null;
	
	public static UnendingHordes getInstance(){
		if(instance == null)
			instance = new UnendingHordes();
		return instance;
	}
	
	public UnendingHordes() {
		super("Unending Hordes", "resources/unending_hordes.png", Item.Type.TOOL.toString());
	}
	
	@Override
	public void loseCrisisObjective(Player player, GameMap map) {
		// add 8 zombies to the colony
		
		int currentZombiesInColony = map.getColony().getEntrance().getOcupiedPlaces();
		List<Survivor> colonySurvivors = getColonySurvivors(player, map);
		
		for (int i = currentZombiesInColony; i < currentZombiesInColony + CRISIS_ZOMBIES; i++) {
			if (i < map.getColony().getEntrance().MAX_FREE_PLACES) {
				map.getColony().getEntrance().getPlaces().get(i).setOccupant(new Zombie());
			} else {
				if (map.getColony().getSurvivors().size() != 0) {
					Survivor survivorWithLowestInfluence = getLowestInfluenceSurvivor(colonySurvivors);
					
					System.out.println(survivorWithLowestInfluence.getName() + " died because of zombie breach!");
					colonySurvivors.remove(survivorWithLowestInfluence);
					map.getColony().getSurvivors().remove(survivorWithLowestInfluence);
					player.getSurvivors().remove(survivorWithLowestInfluence);
					player.loseMorale();
				}
			}
		}
	}

	private Survivor getLowestInfluenceSurvivor(List<Survivor> colonySurvivors) {
		Survivor survivor = null;
		
		for (int i = 0; i < colonySurvivors.size(); i++) {
			if (i == 0) {
				survivor = colonySurvivors.get(i);
				continue;
			}
			
			if (survivor.getInfluence() > colonySurvivors.get(i).getInfluence()) {
				survivor = colonySurvivors.get(i);
			}
		}
		
		return survivor;
	}

	@Override
	public void meetCrisisObjective(Player player, GameMap map) {
		// gain 1 morale
		player.gainMorale();
	}

	private List<Survivor> getColonySurvivors(Player player, GameMap map) {
		List<Survivor> survivors = new ArrayList<Survivor>();
		
		for (int i = 0; i < player.getSurvivors().size(); i++) {
			if (player.getSurvivors().get(i).getCurrentLocation().equals(map.getColony())) {
				survivors.add(player.getSurvivors().get(i));
			}
		}
		
		return survivors;
	}

}
