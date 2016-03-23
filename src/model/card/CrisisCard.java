package model.card;

import model.ability.Ability;
import model.objective.Objective;

public class CrisisCard extends Card {

	private Objective objective;
	
	
	public CrisisCard(String name, Ability ability, Objective objective) {
		super(name, ability);
		this.objective = objective;
	}
	
	
	public Objective getObjective() {
		return objective;
	}
	
}
