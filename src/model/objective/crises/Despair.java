package model.objective.crises;

import model.card.Item;
import model.objective.Crisis;

public class Despair extends Crisis {
	
	private static Despair instance = null;
	
	public static Despair getInstance(){
		if(instance == null)
			instance = new Despair();
		return instance;
	}
	
	public Despair() {
		super("Despair", "resources/despair.png", Item.Type.MEDICINE.toString());
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
