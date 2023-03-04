package sportStoreSupplierProducer;

public class Sport {
	
	private int  equipmentId;
	private String equipmentName;
	private double itemPrice;
	private double discount;
	private double finalPriceinEquipment;
	
	public Sport(int equipmentId, String equipmentName, double itemPrice, double discount) {
		super();
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.itemPrice = itemPrice;
		this.discount = discount;
		calculatefinalPriceInEquipment();
		
	}
	

	public int getEquipmentID() {
		return equipmentId;
	}

	public void setEquipmentID(int equipmentId) {
		this.equipmentId = equipmentId;
	}


	public String getEquipmentName() {
		return equipmentName;
	}


	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}


	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalPriceinEquipment() {
		return finalPriceinEquipment;
	}

	public void setFinalPriceinEquipment(double finalPriceinEquipment) {
		this.finalPriceinEquipment = finalPriceinEquipment;
	}


	void calculatefinalPriceInEquipment() {
		this.finalPriceinEquipment = itemPrice * ((100.00- discount)/100.00) ;
		// TODO Auto-generated method stub
		
	}
	
	



}
