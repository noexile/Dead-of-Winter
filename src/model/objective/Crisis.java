package model.objective;

import model.location.GameMap;
import model.user.Player;

public abstract class Crisis {
	
	public static final int CRISIS_CARDS_NEEDED_FOR_COMPLETING_OBJECTIVE = 2;
	
	private String name;
	private String link;
	private String type;
	private int neededCardsForCrisis;
	
	
	public Crisis(String name, String link, String type) {
		this.name = name;
		this.link = link;
		this.type = type;
		this.neededCardsForCrisis = CRISIS_CARDS_NEEDED_FOR_COMPLETING_OBJECTIVE;
	}
	
	
	// METHODS
	public abstract void loseCrisisObjective(Player player, GameMap map);
	public abstract void meetCrisisObjective(Player player, GameMap map);
	
	
	// GETTERS AND SETTERS
	public String getType() {
		return type;
	}

	public int getNeededCardsForCrisis() {
		return neededCardsForCrisis;
	}

	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}
	
}
