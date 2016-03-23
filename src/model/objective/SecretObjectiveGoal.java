package model.objective;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.card.Item;

public class SecretObjectiveGoal {
	
	private final String[] listOfNames = {"Zombie Killing Robot", "A New Destination", "Historian", "Protected", "Junkie", "Hypochondriac", "Hunger", "Desire To Live" };
	
	private Map<String, String> listOfSecretObjectiveGoals;
	private String name;
	private byte weaponCardsNeeded;
	private byte fuelCardsNeeded;
	private byte educationCardsNeeded;
	private byte foodCardsNeeded;
	private byte medicineCardsNeeded;
	private byte toolCardsNeeded;
	
	public SecretObjectiveGoal(String name) {
		this.listOfSecretObjectiveGoals = new HashMap<String, String>();
		generateSecretObjectiveGoals();
		this.name = name;
		
		List<String> objectiveNames = new ArrayList<String>();
		for(Map.Entry<String, String> entry : this.listOfSecretObjectiveGoals.entrySet()) {
			objectiveNames.add(entry.getKey());
		}
		
		if (name.equals(objectiveNames.get(0))) { // "Zombie Killing Robot"
			this.weaponCardsNeeded = 1;
			this.toolCardsNeeded = 2;
		} else if (name.equals(objectiveNames.get(1))) { // "A New Destination"
			this.fuelCardsNeeded = 3;
		} else if (name.equals(objectiveNames.get(2))) { // "Historian"
			this.educationCardsNeeded = 2;
		} else if (name.equals(objectiveNames.get(3))) { // "Protected"
			this.weaponCardsNeeded = 2;
		} else if (name.equals(objectiveNames.get(4))) { // "Junkie"
			this.medicineCardsNeeded = 3;
		} else if (name.equals(objectiveNames.get(5))) { // "Hypochondriac"
			this.medicineCardsNeeded = 2;
		} else if (name.equals(objectiveNames.get(6))) { // "Hunger"
			this.foodCardsNeeded = 2;
		} else if (name.equals(objectiveNames.get(7))) { // "Desire To Live"
			this.weaponCardsNeeded = 1;
			this.fuelCardsNeeded = 1;
			this.foodCardsNeeded = 1;
			this.medicineCardsNeeded = 1;
		}		
	}

	private void generateSecretObjectiveGoals() {
		for (int i = 0; i < listOfNames.length; i++) {
			this.listOfSecretObjectiveGoals.put(modifyName(listOfNames[i]), listOfNames[i]);
		}
	}
	
	private String modifyName(String name){
		char firstChar = name.charAt(0);
		int ascii = (int)firstChar - 26;
		char newChar = (char)ascii;
		String modifiedName = name.replace(name.charAt(0), newChar);
		modifiedName = modifiedName.replaceAll(" ", "");
		return modifiedName;
	}
}
