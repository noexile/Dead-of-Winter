package model.objective;

import model.user.Player;

public class SecretObjectiveGoal {
	
	private String name;
	private String type;
	private String link;
	private int needed;
	
	
	public SecretObjectiveGoal(String name, String type, String link, int needed) {
		this.name = name;
		this.link = link;
		this.type = type;
		this.needed = needed;
	}

	
	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}
	
	
	public boolean meetRequirements(Player player){

		int counter = 0;
		
		for (int i = 0; i < player.getPlayerItems().size(); i++) {
			if (player.getPlayerItems().get(i).getType().equalsIgnoreCase(type)) {
				counter++;
			}
		}
		
		if(counter >= needed) {
			return true;
		}
		
		return false;
	}
}
