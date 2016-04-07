package model.objective.crises;

import model.card.Item;
import model.objective.Crisis;

public class Illness extends Crisis {
	
	private static Illness instance = null;
	
	public static Illness getInstance(){
		if(instance == null)
			instance = new Illness();
		return instance;
	}
	
	public Illness() {
		super("Illness", "resources/illness.png", Item.Type.MEDICINE.toString());
	}
	
	
	@Override
	public void loseCrisisObjective() {
		// TODO
		// place 1 wound token on all survivors
		// lose 1 morale
	}

	@Override
	public void meetCrisisObjective() {
		// TODO
		// gain 1 morale
	}

}
