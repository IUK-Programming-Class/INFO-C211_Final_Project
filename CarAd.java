package finalProject;


public class CarAd extends Classified {
	
	private int horsepower;
    private int numberWheels;
    private int engineSize;
    private int tireSize;
    
    public CarAd() {
        this.horsepower = 0;
        this.numberWheels = 0;
        this.engineSize = 0;
        this.tireSize = 0;
    }
    
    public CarAd(int horsepower, int numberWheels, int engineSize, int tireSize, int adNumber, String make, String model, int year, String contactName, String contactNumber) {
        super(adNumber, make, model, year, contactName, contactNumber);
        this.setHorsepower(horsepower);
        this.setNumberWheels(numberWheels);
        this.setEngineSize(engineSize);
        this.setTireSize(tireSize);
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
    
    public int getEngineSize() {
        return engineSize;
    }
    
    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }
    
    public int getTireSize() {
        return tireSize;
    }
    
    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }
    
    public String toString() {
        return "Horsepower: " + this.horsepower
              +"\nNumber of Wheels: " + this.numberWheels
              +"\nEngine Size: " + this.engineSize
              +"\nTire Size: " + this.tireSize;
    }
}
