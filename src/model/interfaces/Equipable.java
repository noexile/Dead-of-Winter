package model.interfaces;

import model.card.Item;

public interface Equipable {

	void equipItem(Item item);
	void unEquipItem(Item item);
	void pickUpItem(Item item);
}
