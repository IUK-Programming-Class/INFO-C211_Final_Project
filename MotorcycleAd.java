package finalProject;


public class MotorcycleAd extends Classified {

	private int ccs;
	private int miles;	
	
	public MotorcycleAd(int adNumber, String make, String model, int year, String contactName, String contactNumber, int ccs, int miles) {
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
		
	}// toString for the class to be printed and includes parent class details
	public String toString() {
		String message =

				"\nMotorcycle\n" + "Ad Number: " + super.getAdNumber() + "\n" + "Make: " + super.getMake() + "\n" + "Model: "
						+ super.getModel() + "\n" + "Year: " + super.getYear() + "\n" + "Engine Size (cc): "
						+ this.getCcs() + "\n" + "Miles: " + this.getMiles() + "\n" + "Contact Name: "
						+ super.getContactName() + "\n" + "Contact Number: " + super.getContactNumber() + "\n";
		return message;

	}
	
}
