package model.objective.crises;

import model.card.Item;
import model.objective.Crisis;

public class FuelShortage extends Crisis {
	
	private static FuelShortage instance = null;
	
	public static FuelShortage getInstance(){
		if(instance == null)
			instance = new FuelShortage();
		return instance;
	}
	
	public FuelShortage() {
		super("Fuel Shortage", "resources/fuel_shortage.png", Item.Type.FUEL.toString());
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
