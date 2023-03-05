package sports_manager_producer;

import java.util.List;



public class ManagerServiceImpl implements ManagerActivaterService {


	@Override
	public synchronized int  addItems(int qty,int price,String model) {

		Manager newItem = new Manager( qty, price, model);
		ManagerDataStore.itemsList.add(newItem);

	return 1;		
	}


	@Override
	public  synchronized int removeItems1(String model) {//remove sports accessories

		boolean invalid = true;
		int count = -1;
		for (Manager tempItem :ManagerDataStore.itemsList) {
			count++;
			if (tempItem.getmodel().equalsIgnoreCase(model)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			ManagerDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String model) {//search sports accessories
		boolean valid = false;
	
		for (Manager tempItem : ManagerDataStore.itemsList) {
		
			if (tempItem.getmodel().equalsIgnoreCase(model)) {

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
	public List<Manager> listItems() {

		return ManagerDataStore.itemsList;
	}

	@Override
	public List<Manager> listItems1() {
		// TODO Auto-generated method stub
		return null;
	}
}