package sports_manager_producer;
import java.util.List;



public interface ManagerActivaterService {

	List<Manager> listItems();
	
	public  int  addItems(int qty,int price,String model);//Adds the new Sports Accessories to the Sports Accessories list
	
	public   int removeItems1(String model);//Removes the Sports Accessories from the list
	
	public   int searchitems(String model);//Searches the Sports Accessories by name
	
	public   List<Manager> listItems1();//Returns the Sports Accessories list







	

}
