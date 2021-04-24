package finalProject;

import java.io.Serializable;

public class Classified implements Serializable{
	
	private int adNumber;
	private String make;
	private String model;
	private int year;
	private String contactName;
	private String contactNumber;
	private static int latestID;
	
	public Classified(){

	}
	
	public Classified(String make, String model, int year, String contactName, String contactNumber) {
		this.setAdNumber(generateID());
		this.setMake(make);
		this.setModel(model);
		this.setYear(year);
		this.setContactName(contactName);
		this.setContactNumber(contactNumber);
	}

	public int getAdNumber() {
		return adNumber;
	}

	public void setAdNumber(int adNumber) {
		this.adNumber = adNumber;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	private int generateID() 
	{
		int nextID = getLatestID() + 1;
		setLatestID(nextID);
		return nextID;
	}

	public int getLatestID() {
		return latestID;
	}

	public static void setLatestID(int id) {
		latestID = id;
	}
	
}
