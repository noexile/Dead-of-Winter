package model.objective.crises;

import model.card.Item;
import model.objective.Crisis;

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
	public void loseCrisisObjective() {
		// TODO
		// kill 2 survivors with lowest influence
	}

	@Override
	public void meetCrisisObjective() {
		// TODO
		// gain 1 morale
	}

}
