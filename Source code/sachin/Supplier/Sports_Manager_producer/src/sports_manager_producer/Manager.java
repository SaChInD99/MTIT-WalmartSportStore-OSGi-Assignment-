package sports_manager_producer;


public class Manager {

	private int  qty;
	private int price;
	private String model;
	private int totalvalue;
	
	
	public Manager(int qty, int price, String model) {
		super();
		this.qty=qty;
		this.price = price;
		this.model = model;
		caltotalValue();	
	}
	

	public int getqty() {
		return qty;
	}

	public void setqty(int qty) {
		this.qty = qty;
	}


	public int getprice() {
		return price;
	}


	public void setprice(int price) {
		this.price = price;
	}


	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}

	public int gettotal() {
		return totalvalue;
	}

	public void settotal(int totalvalue) {
		this.totalvalue = totalvalue;
	}


	void caltotalValue() {
		this.totalvalue=this.qty*this.price;
		
	}
	

}













