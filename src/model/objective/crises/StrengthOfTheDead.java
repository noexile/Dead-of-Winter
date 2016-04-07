package model.objective.crises;

import model.card.Item;
import model.location.GameMap;
import model.objective.Crisis;
import model.user.Player;

public class StrengthOfTheDead extends Crisis {
	
	private static StrengthOfTheDead instance = null;
	
	public static StrengthOfTheDead getInstance(){
		if(instance == null)
			instance = new StrengthOfTheDead();
		return instance;
	}
	
	public StrengthOfTheDead() {
		super("Strength of the dead", "resources/strength_of_the_dead.png", Item.Type.FUEL.toString());
	}
	
	
	@Override
	public void loseCrisisObjective(Player player, GameMap map) {
		// TODO
		// add 10 zombies to the colony
	}

	@Override
	public void meetCrisisObjective(Player player, GameMap map) {
		// TODO
		// gain 1 morale
	}

}
