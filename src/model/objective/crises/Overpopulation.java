package model.objective.crises;

import java.util.List;

import model.card.Item;
import model.character.Survivor;
import model.location.GameMap;
import model.location.Location;
import model.objective.Crisis;
import model.user.Player;

public class Overpopulation extends Crisis {
	
	private final int SURVIVORS_KILLED = 2;
	private static Overpopulation instance = null;
	
	public static Overpopulation getInstance(){
		if(instance == null)
			instance = new Overpopulation();
		return instance;
	}
	
	public Overpopulation() {
		super("Overpopulation", "resources/overpopulation.png", Item.Type.FOOD.toString());
	}
	
	
	@Override
	public void loseCrisisObjective(Player player, GameMap map) {
		// kill 2 survivors with lowest influence
		
		for (int i = 0; i < SURVIVORS_KILLED; i++) {
			Survivor survivorWithLowestInfluence = getLowestInfluenceSurvivor(player.getSurvivors());
			
			if (survivorWithLowestInfluence != null) {
				System.out.println(survivorWithLowestInfluence.getName() + " died because of Overpopulation crisis!");

				Location survivorLocation = survivorWithLowestInfluence.getCurrentLocation();
				survivorLocation.getSurvivors().remove(survivorWithLowestInfluence);
				player.getSurvivors().remove(survivorWithLowestInfluence);
				player.loseMorale();
			}
		}
	}

	@Override
	public void meetCrisisObjective(Player player, GameMap map) {
		// gain 1 morale
		player.gainMorale();
	}

	private Survivor getLowestInfluenceSurvivor(List<Survivor> survivors) {
		Survivor survivor = null;
		
		for (int i = 0; i < survivors.size(); i++) {
			if (i == 0) {
				survivor = survivors.get(i);
				continue;
			}
			
			if (survivor.getInfluence() > survivors.get(i).getInfluence()) {
				survivor = survivors.get(i);
			}
		}
		
		return survivor;
	}
}
