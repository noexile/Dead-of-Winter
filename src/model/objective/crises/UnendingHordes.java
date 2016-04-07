package model.objective.crises;

import model.card.Item;
import model.location.GameMap;
import model.objective.Crisis;
import model.user.Player;

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
	public void loseCrisisObjective(Player player, GameMap map) {
		// TODO
		// add 8 zombies to the colony
		// loose 1 morale
	}

	@Override
	public void meetCrisisObjective(Player player, GameMap map) {
		// TODO
		// gain 1 morale
	}

}
