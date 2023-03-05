package sports_storekeeper_producer;

public class Sports {

	private int  sportsId;
	private String sportsName;
	private int quantity;

	
	public Sports(int sportsId, String sportsName, int quantity) {
		super();
		this.sportsId = sportsId;
		this.sportsName = sportsName;
		this.quantity = quantity;
	
		
	}
	

	public int getSportsID() {
		return sportsId;
	}

	public void setSportsID(int sportId) {
		this.sportsId = sportsId;
	}


	public String getSportsName() {
		return sportsName;
	}


	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
