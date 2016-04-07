package model.objective.crises;

import model.card.Item;
import model.character.Survivor;
import model.location.GameMap;
import model.location.Location;
import model.objective.Crisis;
import model.user.Player;

public class Overpopulation extends Crisis {
	
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
		Survivor smaller = null;
		Survivor bigger = null;
		
		for (int i = 0; i < player.getSurvivors().size(); i++) {
			Survivor survivor = player.getSurvivors().get(i);
			if (i == 1) {
				smaller = survivor;
				continue;
			} else if (i == 2) {
				if (smaller.getInfluence() > survivor.getInfluence()) {
					bigger = smaller;
					smaller = survivor;
				} else {
					bigger = survivor;
				}
				continue;
			}
			
			if (survivor.getInfluence() < bigger.getInfluence()) {
				if (survivor.getInfluence() < smaller.getInfluence()) {
					bigger = smaller;
					smaller = survivor;
				} else {
					bigger = survivor;
				}
			}
		}
		
		willSurvive(smaller, player, map);
		willSurvive(bigger, player, map);
	}

	private void willSurvive(Survivor survivor, Player player, GameMap map) {
		if (survivor != null) {
			survivor.die();

			System.out.println(survivor.getName() + " dies!");
			
			Location survivorLocation = survivor.getCurrentLocation();
			survivorLocation.getSurvivors().remove(survivor);
			player.getSurvivors().remove(survivor);
			player.loseMorale();
		}		
	}

	@Override
	public void meetCrisisObjective(Player player, GameMap map) {
		// gain 1 morale
		player.gainMorale();
	}

}
