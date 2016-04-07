package model.objective.crises;

import model.card.Item;
import model.location.GameMap;
import model.objective.Crisis;
import model.user.Player;

public class LegionsOfDeath extends Crisis {
	
	private static LegionsOfDeath instance = null;
	
	public static LegionsOfDeath getInstance(){
		if(instance == null)
			instance = new LegionsOfDeath();
		return instance;
	}
	
	public LegionsOfDeath() {
		super("Legions of Death", "resources/legions_of_death.png", Item.Type.FUEL.toString());
	}
	
	
	@Override
	public void loseCrisisObjective(Player player, GameMap map) {
		// add 12 zombies to the colony
		// TODO
	}

	@Override
	public void meetCrisisObjective(Player player, GameMap map) {
		// gain 1 morale
		player.gainMorale();
	}

}
