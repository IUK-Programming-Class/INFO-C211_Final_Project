package finalProject;

public class BoatAd extends Classified {
	
	private int horsepower;
	private int hours;

	public BoatAd(int adNumber, String make, String model, int year, String contactName, String contactNumber,
			int horsepower, int hours) {
		super(adNumber, make, model, year, contactName, contactNumber);
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	// toString for the class to be printed and includes parent class details
	public String toString() {
		String message =

				"\nBoat\n" + "Ad Number: " + super.getAdNumber() + "\n" + "Make: " + super.getMake() + "\n" + "Model: "
						+ super.getModel() + "\n" + "Year: " + super.getYear() + "\n" + "Horsepower: "
						+ this.getHorsepower() + "\n" + "Hours: " + this.getHours() + "\n" + "Contact Name: "
						+ super.getContactName() + "\n" + "Contact Number: " + super.getContactNumber() + "\n";
		return message;

	}

}
