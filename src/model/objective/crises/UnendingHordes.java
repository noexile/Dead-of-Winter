package model.objective.crises;

import model.card.Item;
import model.objective.Crisis;

public class UnendingHordes extends Crisis {
	
	private static UnendingHordes instance = null;
	
	public static UnendingHordes getInstance(){
		if(instance == null)
			instance = new UnendingHordes();
		return instance;
	}
	
	public UnendingHordes() {
		super("Unending Hordes", "resources/unending_hordes.png", Item.Type.TOOL.toString());
	}
	
	
	@Override
	public void loseCrisisObjective() {
		// TODO
		// add 8 zombies to the colony
		// loose 1 morale
	}

	@Override
	public void meetCrisisObjective() {
		// TODO
		// gain 1 morale
	}

}
