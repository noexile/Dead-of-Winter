package model.objective.crises;

import model.card.Item;
import model.location.GameMap;
import model.objective.Crisis;
import model.user.Player;

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
