package model.objective.secretobjectives;

import model.card.Item;
import model.objective.SecretObjectiveGoal;
import model.user.Player;

public class Hunger extends SecretObjectiveGoal {
	
	public static final int FOOD_NEEDED = 3;

	private static Hunger instance = null;

	public Hunger() {
		super("Hunger", Item.Type.FOOD.toString(), "resources/hunger.png");
	}

	public static Hunger getInstance(){
		if(instance == null)
			instance = new Hunger();
		return instance;
	}

	
	@Override
	public boolean meetRequirements(Player player) {
		int counter = 0;
		
		for (int i = 0; i < player.getPlayerItems().size(); i++) {
			if (player.getPlayerItems().get(i).getType().equalsIgnoreCase(this.getType())) {
				counter++;
			}
		}
		
		if(counter >= FOOD_NEEDED) {
			return true;
		}
		
		return false;
	}
	
}
