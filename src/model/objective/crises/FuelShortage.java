package model.objective.crises;

import model.card.Item;
import model.location.GameMap;
import model.objective.Crisis;
import model.user.Player;

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
	public void loseCrisisObjective(Player player, GameMap map) {
		// loose 2 morale
		player.loseMorale();
		player.loseMorale();
	}

	@Override
	public void meetCrisisObjective(Player player, GameMap map) {
		// gain 1 morale
		player.gainMorale();
	}

}
