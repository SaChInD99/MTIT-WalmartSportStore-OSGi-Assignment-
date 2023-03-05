package manager_consumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import sports_manager_producer.Manager;
import sports_manager_producer.ManagerActivaterService;


public class Activator implements BundleActivator {
	ServiceReference ManagerService;
	Scanner input = new Scanner(System.in);

	boolean exit = false;
	@Override
	public void start(BundleContext context) throws Exception {//Start the life cycle method
		
		System.out.println("Walmart Sports Accessories consumer started !!!!!!!!!!!!!!!!!!");//display starting message
		
		ManagerService = context.getServiceReference(ManagerActivaterService.class.getName());
		
		@SuppressWarnings("unchecked")
		
		ManagerActivaterService  managerActivaterService = (ManagerActivaterService) context.getService(ManagerService);//Instance of managerService
		
		do {
		int selection = 7;
		do {
		System.out.println(" ::::::::::::::::::::::::::Welcome to Walmart Sports Accessories Store ::::::::::::::::::::::");
	
		System.out.println("Now You Can Select an option to continue forward -->>>");
		System.out.println("Press the number that you need......");
		System.out.println("1.Add new sports accessories To the stock ");
		System.out.println("2.Remove sports accessoriesfrom the Stock");
		System.out.println("3.List Of Current sports accessories Stock");
		System.out.println("4.Search  available sports accessories Stock by model");
		System.out.println("5.Exit to Manager Interface");
		
		System.out.println("Now you can enter your selection.........");
		 selection = input.nextInt();
		 input.nextLine();
		 if(selection == 5) {
			 exit = true;
		 }
		 
		 if(selection !=1 &&  selection !=2 && selection !=3 && selection !=4 && selection!=5) {
			 System.out.println("Please Enter a correct selection----->>>");
		 }
		}while(selection !=1  && selection !=2 && selection !=3 && selection !=4 && selection!=5 );
		
	
        String  backToHome = null;
		if (selection == 1) {//Handles the adding process of new items to the list
			do {
			System.out.println("Please Enter the Quaninty of sports accessories----->>>");
			int qty = input.nextInt();

			System.out.println("Please Enter the Price of sports accessories----->>>");
			int price = input.nextInt();

			System.out.println("Please Enter The Model Of the sports accessories----->>>");
			String model = input.nextLine();
			model=input.nextLine();
			
			int result =managerActivaterService.addItems(qty, price, model);//Consumes the ManagerService addItems()
			 String msg = (result ==1) ? "Successfully added the Stock!!!!" :"please enter a valid name";
			   System.out.println(msg);
			System.out.println("Please Press 0 to navigate back to Home or press any other key to continue----->>>");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if (selection == 2) {//Handles the removing process of an existing item in the list 
			do {
			System.out.println("Please Enter the Model name need to delete----->>>");

			String model = input.nextLine();
			int result =managerActivaterService.removeItems1(model);//Consumes the ManagerService removeItems()
			   String msg = (result ==1) ? "Successfully Deleted the item!!!!!!" :"please enter a valid name";
			   System.out.println(msg);
              System.out.println("Please Press 0 to navigate back to home or press any other key to continue----->>>");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 3) {//Handles displaying all items in the list
			do {
				List<Manager> itemsList =managerActivaterService.listItems();//Consumes the ManagerService listItems()
				System.out.println(":::::::::::::::::::::::::Here this is a Walmart Sports Accessories Stock list:::::::::::::::::::::::::::::::::");
				System.out.println("Quantity:"+"\t" +"Price:"+"\t"+"\t" +"Model:"+"\t"+"\t" +"Total Value:"+"\t" );
				
			for(Manager tempItem: itemsList ) {
				System.out.println(tempItem.getqty()+"\t         "+tempItem.getprice()+"\t         "+tempItem.getmodel()+"\t         "+tempItem.gettotal()+"\t              \n");
								
			}
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("Please Press 0 to navigate back to home or press any other key to continue !!!!");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 4) {//Handles the searching process of an existing item in the list
			do {
			
			System.out.println("Please Enter the model name to search----->>>");
			

			String model = input.nextLine();
			int result =managerActivaterService.searchitems(model);//Consumes the ManagerService searchItems()
			 String msg = (result ==1) ? "Item found!" :"Item not found!";
			   System.out.println(msg);
			
			System.out.println("Please Press 0 to navigate back to home or press any other key to continue------>>>");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));
		}
		else if(selection == 5) {//Exits form the Manager consumer program
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop life cycle method
		System.out.println("Walmart Sports Accessories Manager consumer stopped");
		context.ungetService(ManagerService);
	}

}