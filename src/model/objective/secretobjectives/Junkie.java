package model.objective.secretobjectives;

import model.card.Item;
import model.objective.SecretObjectiveGoal;
import model.user.Player;

public class Junkie extends SecretObjectiveGoal{
	
	public static final int MEDICINE_NEEDED = 3;
	
	private static Junkie instance = null;
	
	public Junkie() {
		super("Junkie", Item.Type.MEDICINE.toString(), "resources/junkie.png");
	}

	public static Junkie getInstance(){
		if(instance == null)
			instance = new Junkie();
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
