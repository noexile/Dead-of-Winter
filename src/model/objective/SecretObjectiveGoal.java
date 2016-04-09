package model.objective;

import model.user.Player;

public abstract class SecretObjectiveGoal {
	
	private String name;
	private String type;
	private String link;
	
	
	public SecretObjectiveGoal(String name, String type, String link) {
		this.name = name;
		this.link = link;
		this.type = type;
	}

	
	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}

	public String getType() {
		return type;
	}
	
	
	public abstract boolean meetRequirements(Player player);
}
