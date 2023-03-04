package sportStoreSupplierProducer;

import java.util.List;

import sportStoreSupplierProducer.Sport;
import sportStoreSupplierProducer.SportDataStore;

public class SportSupplierServiceImpl implements SportSupplierService {
	@Override
	public synchronized int  addItems(String equipmentName,double itemPrice,double discount) {

		Sport newItem = new Sport(SportDataStore.itemsList.size() + 1, equipmentName, itemPrice, discount);
		SportDataStore.itemsList.add(newItem);

	return 1;		
	}

	@Override
	public  synchronized int updateItems(String updatedItemName,double updatedItemPrice,double updatedItemDiscount) {
		Sport itemToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Sport tempItem : SportDataStore.itemsList) {
			count++;
			if (tempItem.getEquipmentName().equalsIgnoreCase(updatedItemName)) {

				itemToBeUpdated = tempItem;
				invalid = false;
				break;
			}
		
		}
		if (!invalid) {

			itemToBeUpdated.setEquipmentName(updatedItemName);
			itemToBeUpdated.setItemPrice(updatedItemPrice);
			itemToBeUpdated.setDiscount(updatedItemDiscount);
			itemToBeUpdated.calculatefinalPriceInEquipment();

			SportDataStore.itemsList.set(count, itemToBeUpdated);
			return 1;

		} else {
			return -1;
		}
				
	}

	@Override
	public  synchronized int removeItems1(String equipmentName) {

		boolean invalid = true;
		int count = -1;
		for (Sport tempItem :SportDataStore.itemsList) {
			count++;
			if (tempItem.getEquipmentName().equalsIgnoreCase(equipmentName)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			SportDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String equipmentName) {
		boolean valid = false;
	
		for (Sport tempItem : SportDataStore.itemsList) {
		
			if (tempItem.getEquipmentName().equalsIgnoreCase(equipmentName)) {

				valid = true;
				break;

			}			

		}
		if(valid) {
			return 1;
			
		}
		else {
			return -1;
		}
		
	}

	@Override
	public List<Sport> listItems() {

		return SportDataStore.itemsList;
	}

	@Override
	public List<Sport> listItems1() {
		// TODO Auto-generated method stub
		return null;
	}
}


