package model.objective.secretobjectives;

import model.card.Item;
import model.objective.SecretObjectiveGoal;
import model.user.Player;

public class Hypochondriac extends SecretObjectiveGoal {

	public static final int MEDICINE_NEEDED = 2;

	private static Hypochondriac instance = null;
	
	public Hypochondriac() {
		super("Hypochondriac", Item.Type.MEDICINE.toString(), "resources/hypochondriac.png");
	}

	public static Hypochondriac getInstance(){
		if(instance == null)
			instance = new Hypochondriac();
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
		
		if(counter >= MEDICINE_NEEDED) {
			return true;
		}
		
		return false;
	}
}
