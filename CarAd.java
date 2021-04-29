//George Adams

public class CarAd extends Classified {
    
    private int horsepower;
    private int numberWheels;
    
    public CarAd() {
        this.horsepower = 0;
        this.numberWheels = 0;
    }
    
    public CarAd(String make, String model, int year, String contactName, String contactNumber, int horsepower, int numberWheels) {
        super(make, model, year, contactName, contactNumber);
        this.setHorsepower(horsepower);
        this.setNumberWheels(numberWheels);
    }
    
    public int getHorsepower() {
        return horsepower;
    }
    
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    
    public int getNumberWheels() {
        return numberWheels;
    }
    
    public void setNumberWheels(int numberWheels) {
        this.numberWheels = numberWheels;
    }
    
    public String toString() {
    	String message
        = "\nCar\n" + "Ad Number: " + super.getAdNumber() + "\n" + "Make: " + super.getMake() + "\n" + "Model: "
        + super.getModel() + "\n" + "Year: " + super.getYear() + "\n" + "Horsepower: "
        + this.getHorsepower() + "\n" + "Number of Wheels: " + this.getNumberWheels() + "\n" + "Contact Name: "
        + super.getContactName() + "\n" + "Contact Number: " + super.getContactNumber() + "\n";
    	return message; 

    	
    }
}
