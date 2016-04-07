package model.objective.crises;

import model.card.Item;
import model.objective.Crisis;

public class ZombieSurge extends Crisis {
	
	private static ZombieSurge instance = null;
	
	public static ZombieSurge getInstance(){
		if(instance == null)
			instance = new ZombieSurge();
		return instance;
	}
	
	public ZombieSurge() {
		super("Zombie Surge", "resources/zombie_surge.png", Item.Type.TOOL.toString());
	}
	
	
	@Override
	public void loseCrisisObjective() {
		// TODO
		// add 6 zombies to the colony and 1 to each non-colony location
	}

	@Override
	public void meetCrisisObjective() {
		// TODO
		// gain 1 morale
	}

}
