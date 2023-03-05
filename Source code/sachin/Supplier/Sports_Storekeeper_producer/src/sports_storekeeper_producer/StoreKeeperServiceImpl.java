package sports_storekeeper_producer;

import java.util.List;

public class StoreKeeperServiceImpl implements StoreKeeperService {

	@Override
	public synchronized int  addItems(String sportsName,int quantity) {

		
		Sports newItem = new Sports(SportsDataStore.itemsList.size() + 1, sportsName, quantity);
		SportsDataStore.itemsList.add(newItem);

	return 1;		
	}


	@Override
	public  synchronized int removeItems1(String sportsName) {

		boolean invalid = true;
		int count = -1;
		for (Sports tempItem :SportsDataStore.itemsList) {
			count++;
			if (tempItem.getSportsName().equalsIgnoreCase(sportsName)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			SportsDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String sportsName) {
		boolean valid = false;
	
		for (Sports tempItem : SportsDataStore.itemsList) {
		
			if (tempItem.getSportsName().equalsIgnoreCase(sportsName)) {

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
	public List<Sports> listItems() {

		return SportsDataStore.itemsList;
	}

	@Override
	public List<Sports> listItems1() {
		// TODO Auto-generated method stub
		return null;
	
	}
}
