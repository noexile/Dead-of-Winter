package model.objective.crises;

import model.card.Item;
import model.objective.Crisis;

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
	public void loseCrisisObjective() {
		// TODO
		// loose 2 morale
	}

	@Override
	public void meetCrisisObjective() {
		// TODO
		// gain 1 morale
	}

}
