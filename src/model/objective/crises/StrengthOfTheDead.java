package model.objective.crises;

import model.card.Item;
import model.objective.Crisis;

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
	public void loseCrisisObjective() {
		// TODO
		// add 10 zombies to the colony
	}

	@Override
	public void meetCrisisObjective() {
		// TODO
		// gain 1 morale
	}

}
