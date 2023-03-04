package sportStoreSupplierConsumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import sportStoreSupplierProducer.Sport;
import sportStoreSupplierProducer.SportSupplierService;

public class Activator implements BundleActivator {

	ServiceReference SportSupplierServiceReference;
	Scanner input = new Scanner(System.in);

	boolean exit = false;

	@Override
	public void start(BundleContext context) throws Exception {//Start life cycle method
		
		System.out.println("\t\t\t===========================================Walmart Sport Accessories Store.=============================================\n");
		
		SportSupplierServiceReference = context.getServiceReference(SportSupplierService.class.getName());
		
		@SuppressWarnings("unchecked")
		
		SportSupplierService  sportSupplierService = (SportSupplierService) context.getService(SportSupplierServiceReference);		//Instance of managerService
		
		do {
		int selection = 7;
		do {
		System.out.println("\n-----------------------Welcome to Walmart Sport Accessories Store Supplier Interface--------------------------\n");
	
		System.out.println("<..........Please Select an option to continue..........>");
		
		System.out.println("<!Options!>");
		
		System.out.println("1.Add  new Sport Equipment to Walmart Sport Accessories Store ");
		System.out.println("2.Remove  an exsisiting Sport Equipment");
		System.out.println("3.List Of Available Sport Equipments");
		System.out.println("4.Search  available Sport Equipments by name");
		System.out.println("5.Exit from Supplier Interface \n");
		
		System.out.println("Enter your selection :");
		 selection = input.nextInt();
		
		 input.nextLine();
		 if(selection == 5) {
			 exit = true;
		 }
		 
		 if(selection !=1 &&  selection !=2 && selection !=3 && selection !=4 && selection!=5) {
			 System.out.println(".............Please enter a valid selection............");
		 }
		}while(selection !=1  && selection !=2 && selection !=3 && selection !=4 && selection!=5 );
		
	
        String  backToHome = null;
		if (selection == 1) {//Handles the adding process of new items to the list
			do {
				
			System.out.println("Enter the Equipment  Name: ");
			String equipmentName = input.nextLine();

			System.out.println("Enter the Equipment Price: ");
			double itemPrice = input.nextDouble();

			System.out.println("Enter Discount Percentege (%): ");
			double itemDiscount = input.nextDouble();
			input.nextLine();
			
			int result =sportSupplierService.addItems(equipmentName, itemPrice, itemDiscount);//Consumes the ManagerService addItems()
			 String msg = (result ==1) ? "<------Successfully added the item!------>" :"please enter a valid name";
			   System.out.println(msg);
			System.out.println("Do you want to add more equipments to the store(Yes/No):");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("No")));

		}
		else if (selection == 2) {//Handles the removing process of an existing item in the list 
			do {
			System.out.println("Enter the equipment name:");

			String equipmentName = input.nextLine();
			int result =sportSupplierService.removeItems1(equipmentName);//Consumes the ManagerService removeItems()
			   String msg = (result ==1) ? "<<<<Successfully Removed the Equipment!>>>>" :"please enter a valid name";
			   System.out.println(msg);
              System.out.println("Do you want to delete more items from the Store(Yes/No):");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("No")));

		}
		else if(selection == 3) {//Handles displaying all items in the list
			do {
				List<Sport> itemsList =sportSupplierService.listItems();//Consumes the ManagerService listItems()
				System.out.println("\n----------------------------------------Walmart Sport Supplier Item list------------------------------------------\n");
				System.out.println("Equip ID"+"\t" +" Equipment Name "+"\t" + " Equipment Price "+"\t" + " Discount Percentage "+"\t" +" Price After the Discount"+"\t" );
				
			for(Sport tempItem: itemsList ) {
				System.out.println(tempItem.getEquipmentID()+"\t\t"+tempItem.getEquipmentName()+"\t\t\t"+tempItem.getItemPrice()+"\t\t\t"+tempItem.getDiscount()+"%\t\t\t" +tempItem.getFinalPriceinEquipment()+"\t\t\n");
								
			}
			System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("Press 0 to navigate back----->");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 4) {//Handles the searching process of an existing item in the list
			do {
			
			System.out.println("Enter the Sport equipment name-->");
			

			String equipmentName = input.nextLine();
			int result =sportSupplierService.searchitems(equipmentName);//Consumes the ManagerService searchItems()
			 String msg = (result ==1) ? "Sport Equipment found!" :"Equipment not found!Add Equipment to Store Database If the Equipment is Available\n";
			   System.out.println(msg);
			
			System.out.println("Do you want to search another Sport Equipment(Yes/No):");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("No")));
		}
		else if(selection == 5) {//Exits form the Manager consumer program
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop life cycle method
		System.out.println("================================Walmart Sport Accesories Store consumer stopped.================================");
		context.ungetService(SportSupplierServiceReference);
	}

}

