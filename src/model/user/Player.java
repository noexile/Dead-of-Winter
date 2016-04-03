package model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import model.card.CrisisCard;
import model.card.PlayerCard;
import model.character.Survivor;
import model.objective.MainObjective;
import model.objective.SecretObjective;

public class Player {
	
	private MainObjective mainObjective;
	private SecretObjective secretObjective;
	private Queue<CrisisCard> crisisCards;
	private CrisisCard currentCrisisCard;
	private List<PlayerCard> playerItems;
	private List<Survivor> survivors;
	private int morale;
	private int round;
	private int id;
	

	public Player(int id) {
		this.id = id;
	}
	
	// --------------------- METHODS --------------------- 
	
	public void getNextCrisisCard() {
		this.currentCrisisCard = this.crisisCards.poll();
	}
	// --------------------- GETTERS AND SETTERS --------------------- 
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

	public Queue<CrisisCard> getCrisisCards() {
		return crisisCards;
	}

	public void setCrisisCards(Queue<CrisisCard> crisisCards) {
		this.crisisCards = crisisCards;
	}

	public CrisisCard getCurrentCrisisCard() {
		return currentCrisisCard;
	}

	public void setCurrentCrisisCard(CrisisCard currentCrisisCard) {
		this.currentCrisisCard = currentCrisisCard;
	}

	public List<PlayerCard> getPlayerItems() {
		return playerItems;
	}

	public void setPlayerItems(ArrayList<PlayerCard> startingCards) {
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
