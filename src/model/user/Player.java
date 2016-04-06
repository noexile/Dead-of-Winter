package model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import model.card.Item;
import model.character.Survivor;
import model.objective.Crisis;
import model.objective.MainObjective;
import model.objective.SecretObjective;

public class Player {
	
	private MainObjective mainObjective;
	private SecretObjective secretObjective;
	private Queue<Crisis> allCrisis;
	private Crisis currentCrisis;
	private List<Item> playerItems;
	private List<Survivor> survivors;
	private int morale;
	private int round;
	private int id;
	private List<Integer> rolledDice;
	

	public Player(int id) {
		this.id = id;
		this.rolledDice = new ArrayList<Integer>();
	}
	
	// --------------------- METHODS --------------------- 
	
	public void getNextCrisisCard() {
		this.currentCrisis = this.allCrisis.poll();
	}
	
	public void rollDice() {
		Random rand = new Random();
		
		for (int i = 0; i < survivors.size() + 1; i++) {
			this.rolledDice.add(1 + rand.nextInt(6));
		}
	}
	// --------------------- GETTERS AND SETTERS --------------------- 
	
	public List<Integer> getRolledDice() {
		return rolledDice;
	}
	
	public MainObjective getMainObjective() {
		return mainObjective;
	}

	public void setMainObjective(MainObjective mainObjective) {
		this.mainObjective = mainObjective;
	}

	public SecretObjective getSecretObjective() {
		return secretObjective;
	}

	public void setSecretObjective(SecretObjective secretObjective) {
		this.secretObjective = secretObjective;
	}

	public Queue<Crisis> getAllCrisis() {
		return allCrisis;
	}

	public void setAllCrisis(Queue<Crisis> crisis) {
		this.allCrisis = crisis;
	}

	public Crisis getCurrentCrisis() {
		return currentCrisis;
	}

	public void setCurrentCrisis(Crisis currentCrisis) {
		this.currentCrisis = currentCrisis;
	}

	public List<Item> getPlayerItems() {
		return playerItems;
	}

	public void setPlayerItems(ArrayList<Item> startingCards) {
		this.playerItems = startingCards;
	}

	public List<Survivor> getSurvivors() {
		return survivors;
	}

	public void setSurvivors(List<Survivor> survivors) {
		this.survivors = survivors;
	}

	public int getMorale() {
		return morale;
	}

	public void setMorale(int morale) {
		this.morale = morale;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
}
