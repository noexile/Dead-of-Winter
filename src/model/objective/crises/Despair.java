package model.objective.crises;

import model.card.Item;
import model.location.GameMap;
import model.objective.Crisis;
import model.user.Player;

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
