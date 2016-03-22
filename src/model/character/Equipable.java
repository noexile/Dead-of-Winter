package model.character;

import model.interfaces.ItemCarrier;
import model.item.Item;

public interface Equipable {

	void equipItem(Item item);
	void unEquipItem(Item item);
	void transferItem(Item item, ItemCarrier carrier);
	void pickUpItem(Item item);
}
