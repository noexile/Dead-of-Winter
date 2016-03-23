package model.character;

import model.card.Item;
import model.interfaces.ItemCarrier;

public interface Equipable {

	void equipItem(Item item);
	void unEquipItem(Item item);
	void transferItem(Item item, ItemCarrier carrier);
	void pickUpItem(Item item);
}
