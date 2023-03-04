package sportStoreSupplierProducer;

import java.util.List;

import sportStoreSupplierProducer.Sport;

public interface SportSupplierService {
	
List<Sport> listItems();
	public  int  addItems(String equipmentName,double itemPrice,double itemDiscount);//Adds the new items to the item list
	public   int  updateItems(String updatedItemName,double updatedItemPrice,double updatedItemDiscount);//Updates the item details
	public   int removeItems1(String itemName);//Removes the items from the list
	public   int searchitems(String itemName);//Searches and item by name
	public   List<Sport> listItems1();//Returns the item list

}
