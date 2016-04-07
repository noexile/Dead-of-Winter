package model.objective.crises;

import model.card.Item;
import model.objective.Crisis;

public class HorrorInTheNight extends Crisis {
	
	private static HorrorInTheNight instance = null;
	
	public static HorrorInTheNight getInstance(){
		if(instance == null)
			instance = new HorrorInTheNight();
		return instance;
	}
	
	public HorrorInTheNight() {
		super("Horror in the Night", "resources/horror_in_the_night.png", Item.Type.FOOD.toString());
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
