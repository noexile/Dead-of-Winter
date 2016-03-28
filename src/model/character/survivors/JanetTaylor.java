package model.character.survivors;

import model.ability.Ability;
import model.character.Survivor;
import model.location.Location;

public class JanetTaylor extends Survivor {


	public JanetTaylor(Location currentLocation, Ability ability) {
		super("Janet Taylor", "Nurse", (byte) 42, (byte) 3, (byte) 4, currentLocation, ability, "resources/janet_taylor.png");
	}
	
}
