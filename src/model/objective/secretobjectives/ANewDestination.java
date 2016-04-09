package model.objective.secretobjectives;

import model.card.Item;
import model.objective.SecretObjectiveGoal;
import model.user.Player;

public class ANewDestination extends SecretObjectiveGoal {
	
	public static final int FUEL_NEEDED = 3;
	
	private static ANewDestination instance = null;
		
	public ANewDestination() {
		super("A New Destination", Item.Type.FUEL.toString(), "resources/a_new_destination.png");
	}
	
	public static ANewDestination getInstance(){
		if(instance == null)
			instance = new ANewDestination();
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
		
		if(counter >= FUEL_NEEDED) {
			return true;
		}
		
		return false;
	}
}
