package sports_storekeeper_consumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import sports_storekeeper_producer.Sports;
import sports_storekeeper_producer.StoreKeeperService;

public class Activator implements BundleActivator {

	ServiceReference StoreKeeperServiceReference;
	Scanner input = new Scanner(System.in);

	boolean exit = false;

	
		
	@Override
	public void start(BundleContext context) throws Exception {    //Start life cycle method
		
		StoreKeeperServiceReference = context.getServiceReference(StoreKeeperService.class.getName());
		
		@SuppressWarnings("unchecked")
		
		StoreKeeperService  StoreKeeperService = (StoreKeeperService) context.getService(StoreKeeperServiceReference);		//Instance of managerService
		
		do {
		int selection = 7;
		do {
		System.out.println("\n::::::::Welcome to Walmart Sports Accessories Shop Store:::::::: \n");
	
		System.out.println("Now You Can Select an option to continue forward-->>> \n");
		System.out.println("Enter the number that you need..... \n");
		System.out.println("1.Add new sports accessories to the store ");
		System.out.println("2.Remove sports accessories from the store");
		System.out.println("3.List of available sports accessories in store");
		System.out.println("4.Search available sports accessories by name");
		System.out.println("5.Exit to store keeper interface \n");
		
		System.out.println("Now you can enter your selection :");
		 selection = input.nextInt();
		
		 input.nextLine();
		 if(selection == 5) {
			 exit = true;
		 }
		 
		 if(selection !=1 &&  selection !=2 && selection !=3 && selection !=4 && selection!=5) {
			 System.out.println("Please enter a valid selection");
		 }
		}while(selection !=1  && selection !=2 && selection !=3 && selection !=4 && selection!=5 );
		
	
        String  backToHome = null;
		if (selection == 1) {//Handles the adding new items to the store
			do {
			System.out.println("Enter the new sports accessories name: ");
			String sportsName = input.nextLine();

			System.out.println("Enter the quantity of sports accessories: ");
			int quantity = input.nextInt();
			
			input.nextLine();
			
			
			int result =StoreKeeperService.addItems(sportsName, quantity);
			String msg = (result ==1) ? "Successfully added the new sports accessories!!! \n" : "please enter a valid name";
			System.out.println(msg);
			System.out.println("Press 0 to navigate back to home or press any other key to continue...");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if (selection == 2) {//Handles the removing an existing item in the store
			do {
			System.out.println("Enter the sports accessories name you need remove:");

			String sportsName = input.nextLine();
			int result =StoreKeeperService.removeItems1(sportsName);
			   String msg = (result ==1) ? "Successfully Removed the sports accessories!!! \n" :"please enter a valid name";
			   System.out.println(msg);
              System.out.println("Press 0 to navigate back to home or press any other key to continue...");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 3) {//Handles displaying all items in the store
			do {
				List<Sports> itemsList =StoreKeeperService.listItems();//Consumes the ManagerService listItems()
				System.out.println("=================Sports accessories in the store================");

				System.out.println("Accessories ID:"+"\t"+"Accessories Name:"+"\t"+"quantity:"+"\t" );
				
			for(Sports tempItem: itemsList ) {
				System.out.println(tempItem.getSportsID()+"\t\t"+tempItem.getSportsName()+"\t\t"+tempItem.getQuantity()+"\t ");
								
			}
			System.out.println("===================================================");
            System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 4) {//Handles the searching process of an existing item in the store
			do {
			
			System.out.println("Enter the sports accessories name you need search");
			

			String sportsName = input.nextLine();
			int result =StoreKeeperService.searchitems(sportsName);
			 String msg = (result ==1) ? "Item found!" :"Item not found!";
			   System.out.println(msg);
			
			System.out.println("Press 0 to navigate back to home or press any other key to continue...");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));
		}
		else if(selection == 5) { //Exits form the consumer program
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop life cycle method
		System.out.println("============Sports Accessories Store Keeper Consumer Stopped.============");
		context.ungetService(StoreKeeperServiceReference);
	}


}
