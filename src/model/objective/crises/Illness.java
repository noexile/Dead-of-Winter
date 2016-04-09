package model.objective.crises;

import model.card.Item;
import model.character.Survivor;
import model.location.GameMap;
import model.location.Location;
import model.objective.Crisis;
import model.user.Player;

public class Illness extends Crisis {
	
	private static Illness instance = null;
	
	public static Illness getInstance(){
		if(instance == null)
			instance = new Illness();
		return instance;
	}
	
	public Illness() {
		super("Illness", "resources/illness.png", Item.Type.MEDICINE.toString());
	}
	
	
	@Override
	public void loseCrisisObjective(Player player, GameMap map) {
		// place 1 wound token on all survivors
		for (int i = 0; i < player.getSurvivors().size(); i++) {
			Survivor survivor = player.getSurvivors().get(i);
			survivor.takeDamage();
			
			// checks if surviver will survive ?!?!
			if (survivor.getReceivedDamage() >= Survivor.SURVIVOR_MAX_LIFE) {
				survivor.die();
			}
			
			if (!survivor.isAlive()) {
				Location survivorLocation = player.getSurvivors().get(i).getCurrentLocation();
				survivorLocation.getSurvivors().remove(survivor);
				player.getSurvivors().remove(i);
				player.loseMorale();
				i--;
				System.out.println(survivor.getName() + " dies!");
			}
		}
		
		// lose 1 morale
		player.loseMorale();
	}

	@Override
	public void meetCrisisObjective(Player player, GameMap map) {
		// gain 1 morale
		player.gainMorale();
	}

}
