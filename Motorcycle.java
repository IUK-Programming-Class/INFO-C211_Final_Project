package application;


public class Motorcycle extends Classified {

	private static final long serialVersionUID = 6191811345973245193L;
	private int ccs;
	private int miles;	
	
	public Motorcycle(int adNumber, String make, String model, int year, String contactName, String contactNumber, int ccs, int miles) {
		super(adNumber, make, model, year, contactName, contactNumber);
	
	}

	public int getCcs() {
		return ccs;
	}

	public void setCcs(int ccs) {
		this.ccs = ccs;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}
}
