package finalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClassifiedsMenu extends Application {
	// ArrayLists to store account and customer data
	ArrayList<Classified> classifieds = new ArrayList<Classified>();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// File storage for Classifieds ArrayList
		final String FILENAME = "classifieds.txt";
		File f = new File(FILENAME);

		if (f.exists()) {
			// Exception handling for reading files using Try/ Catch
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));

				classifieds = (ArrayList<Classified>) in.readObject(); // requires casting

				in.close();
			} catch (Exception e) {
				System.out.println("Error occurred during reading the file");
				System.out.println(e.getMessage());
				e.printStackTrace();
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("Error occurred during reading the file");
				alert.show();
			}
		}
		
		
		// Set the highest Ad Number in the arraylist as the Latest ID in Classified class
		int id = 0;
		for (Classified ad : classifieds) {
			if (ad.getAdNumber() > id) {
				id = ad.getAdNumber();
			}
        }
		Classified.setLatestID(id);

		// Action to handle closing program and saving data when close X button is used

		primaryStage.setOnCloseRequest(e -> {
			e.consume();
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Exit Program");
			confirm.setHeaderText("Exit the program?");
			if (confirm.showAndWait().get() == ButtonType.OK) {

				// Exception handling for saving files using Try/ Catch

				// Exception handling for saving files using Try/ Catch
				try {
					// Create the file then save all classifieds records into it
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
					out.writeObject(classifieds);
					out.flush();
					out.close();
				} catch (Exception e1) {
					System.out.println("Unable to save classifieds information");
					System.out.println(e1.getMessage());
					e1.printStackTrace();
					System.exit(0);
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setContentText("Unable to save classifieds information");
					alert.show();
				}
				System.exit(0);
			}
		});

		// Setting up Stage to include Radio button menu
		primaryStage.setTitle("Team 1 Classifieds");

		RadioButton radioButton1 = new RadioButton("Create Boat Classified");
		RadioButton radioButton2 = new RadioButton("Create Car Classified");
		RadioButton radioButton3 = new RadioButton("Create Motorcycle Classified");
		RadioButton radioButton4 = new RadioButton("Remove Classified");
		RadioButton radioButton5 = new RadioButton("Display Classifieds");
		RadioButton radioButton6 = new RadioButton("Exit");

		ToggleGroup radioGroup = new ToggleGroup();

		radioButton1.setToggleGroup(radioGroup);
		radioButton2.setToggleGroup(radioGroup);
		radioButton3.setToggleGroup(radioGroup);
		radioButton4.setToggleGroup(radioGroup);
		radioButton5.setToggleGroup(radioGroup);
		radioButton6.setToggleGroup(radioGroup);

		// Adding radio buttons and formatting the menu's style
		VBox menu = new VBox(radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6);
		menu.setSpacing(10);
		menu.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-color: black;");

		// Pane for handling boat classified creations
		GridPane boatAd = new GridPane();
		boatAd.setPadding(new Insets(10, 10, 10, 10));
		boatAd.setVgap(8);
		boatAd.setHgap(10);

		// Radio Button Boat Ad Pane
		Label makeLabel1 = new Label("Make:");
		GridPane.setConstraints(makeLabel1, 0, 0);

		// Radio Button Boat Ad Pane
		TextField makeInput1 = new TextField();
		makeInput1.setPromptText("Bayliner");
		GridPane.setConstraints(makeInput1, 1, 0);

		// Radio Button Boat Ad Pane
		Label modelLabel1 = new Label("Model:");
		GridPane.setConstraints(modelLabel1, 0, 1);

		// Radio Button Boat Ad Pane
		TextField modelInput1 = new TextField();
		modelInput1.setPromptText("X-15");
		GridPane.setConstraints(modelInput1, 1, 1);

		// Radio Button Boat Ad Pane
		Label yearLabel1 = new Label("Year:");
		GridPane.setConstraints(yearLabel1, 0, 2);

		// Radio Button Boat Ad Pane
		TextField yearInput1 = new TextField();
		yearInput1.setPromptText("2015");
		GridPane.setConstraints(yearInput1, 1, 2);

		// Radio Button Boat Ad Pane
		Label horsepowerLabel1 = new Label("Horsepower:");
		GridPane.setConstraints(horsepowerLabel1, 0, 3);

		// Radio Button Boat Ad Pane
		TextField horsepowerInput1 = new TextField();
		horsepowerInput1.setPromptText("75");
		GridPane.setConstraints(horsepowerInput1, 1, 3);

		// Radio Button Boat Ad Pane
		Label hoursLabel1 = new Label("Hours:");
		GridPane.setConstraints(hoursLabel1, 0, 4);

		// Radio Button Boat Ad Pane
		TextField hoursInput1 = new TextField();
		hoursInput1.setPromptText("175");
		GridPane.setConstraints(hoursInput1, 1, 4);

		// Radio Button Boat Ad Pane
		Label contactNameLabel1 = new Label("Contact Name:");
		GridPane.setConstraints(contactNameLabel1, 0, 5);

		// Radio Button Boat Ad Pane
		TextField contactNameInput1 = new TextField();
		contactNameInput1.setPromptText("John Doe");
		GridPane.setConstraints(contactNameInput1, 1, 5);

		// Radio Button Boat Ad Pane
		Label contactNumberLabel1 = new Label("Contact Number:");
		GridPane.setConstraints(contactNumberLabel1, 0, 6);

		// Radio Button Boat Ad Pane
		TextField contactNumberInput1 = new TextField();
		contactNumberInput1.setPromptText("xxx-xxx-xxxx");
		GridPane.setConstraints(contactNumberInput1, 1, 6);

		// Radio Button Boat Ad Pane
		Label statusLabel = new Label("Processing Errors:");
		GridPane.setConstraints(statusLabel, 0, 10);

		// Radio Button Boat Ad Pane
		TextArea errorMessage = new TextArea();
		GridPane.setConstraints(errorMessage, 1, 10);
		errorMessage.setMaxHeight(100);
		errorMessage.setEditable(false);

		// Radio Button Boat Ad Pane
		Button createButton1 = new Button("Create");
		GridPane.setConstraints(createButton1, 1, 7);

		// Radio Button Boat Panes
		boatAd.getChildren().addAll(makeLabel1, makeInput1, modelLabel1, modelInput1, yearLabel1, yearInput1, horsepowerLabel1,
				horsepowerInput1, hoursLabel1, hoursInput1, contactNameLabel1, contactNameInput1, contactNumberLabel1,
				contactNumberInput1, statusLabel, errorMessage, createButton1);
		
		// Pane for handling Car classified creations
		GridPane carAd = new GridPane();
		carAd.setPadding(new Insets(10, 10, 10, 10));
		carAd.setVgap(8);
		carAd.setHgap(10);
		                
		// Radio Button Car Ad Pane
		Label makeLabel2 = new Label("Make:");
		GridPane.setConstraints(makeLabel2, 0, 0);
		                
		// Radio Button Car Ad Pane
		TextField makeInput2 = new TextField();
		makeInput2.setPromptText("Toyota");
		GridPane.setConstraints(makeInput2, 1, 0);
		                
		// Radio Button Car Ad Pane
		Label modelLabel2 = new Label("Model:");
		GridPane.setConstraints(modelLabel2, 0, 1);
		                
		// Radio Button Car Ad Pane
		TextField modelInput2 = new TextField();
		modelInput2.setPromptText("Camry");
		GridPane.setConstraints(modelInput2, 1, 1);
		                
		// Radio Button Car Ad Pane
		Label yearLabel2 = new Label("Year:");
		GridPane.setConstraints(yearLabel2, 0, 2);
		                
		// Radio Button Car Ad Pane
		TextField yearInput2 = new TextField();
		yearInput2.setPromptText("2018");
		GridPane.setConstraints(yearInput2, 1, 2);
		                
		// Radio Button Car Ad Pane
		Label horsepowerLabel2 = new Label("Horsepower:");
		GridPane.setConstraints(horsepowerLabel2, 0, 3);
		                
		// Radio Button Car Ad Pane
		TextField horsepowerInput2 = new TextField();
		horsepowerInput2.setPromptText("250");
		GridPane.setConstraints(horsepowerInput2, 1, 3);
		                
		// Radio Button Car Ad Pane
		Label numberWheelsLabel2 = new Label("Number of Wheels: ");
		GridPane.setConstraints(numberWheelsLabel2, 0, 4);
		                
		// Radio Button Car Ad Pane
		TextField numberWheelsInput2 = new TextField();
		numberWheelsInput2.setPromptText("4");
		GridPane.setConstraints(numberWheelsInput2, 1, 4);
		                
		// Radio Button Car Ad Pane
		Label contactNameLabel2 = new Label("Contact Name:");
		GridPane.setConstraints(contactNameLabel2, 0, 5);
		                
		// Radio Button Car Ad Pane
		TextField contactNameInput2 = new TextField();
		contactNameInput2.setPromptText("John Doe");
		GridPane.setConstraints(contactNameInput2, 1, 5);
		                
		// Radio Button Car Ad Pane
		Label contactNumberLabel2 = new Label("Contact Number:");
		GridPane.setConstraints(contactNumberLabel2, 0, 6);
		                
		// Radio Button Car Ad Pane
		TextField contactNumberInput2 = new TextField();
		contactNumberInput2.setPromptText("xxx-xxx-xxxx");
		GridPane.setConstraints(contactNumberInput2, 1, 6);
		                
		// Radio Button Car Ad Pane
		Label statusLabel2 = new Label("Processing Errors:");
		GridPane.setConstraints(statusLabel2, 0, 10);
		                
		// Radio Button Car Ad Pane
		TextArea errorMessage2 = new TextArea();
		GridPane.setConstraints(errorMessage2, 1, 10);
		errorMessage2.setMaxHeight(100);
		errorMessage2.setEditable(false);
		              
		// Radio Button Car Ad Pane
		Button createButton2 = new Button("Create");
		GridPane.setConstraints(createButton2, 1, 7);
		              
		// Radio Button Car Panes
		carAd.getChildren().addAll(makeLabel2, makeInput2, modelLabel2, modelInput2, yearLabel2, yearInput2, horsepowerLabel2,
				horsepowerInput2, numberWheelsLabel2, numberWheelsInput2, contactNameLabel2, contactNameInput2, contactNumberLabel2,
				contactNumberInput2, statusLabel2, errorMessage2, createButton2);
		
		
		// Pane for handling motorcycle classified creations
		GridPane motorcycleAd = new GridPane();
		motorcycleAd.setPadding(new Insets(10, 10, 10, 10));
		motorcycleAd.setVgap(8);
		motorcycleAd.setHgap(10);

		// Radio Button motorcycle Ad Pane
		Label makeLabel3 = new Label("Make:");
		GridPane.setConstraints(makeLabel3, 0, 0);

		// Radio Button motorcycle Ad Pane
		TextField makeInput3 = new TextField();
		makeInput3.setPromptText("Yamaha");
		GridPane.setConstraints(makeInput3, 1, 0);

		// Radio Button motorcycle Ad Pane
		Label modelLabel3 = new Label("Model:");
		GridPane.setConstraints(modelLabel3, 0, 1);

		// Radio Button motorcycle Ad Pane
		TextField modelInput3 = new TextField();
		modelInput3.setPromptText("Special");
		GridPane.setConstraints(modelInput3, 1, 1);

		// Radio Button motorcycle Ad Pane
		Label yearLabel3 = new Label("Year:");
		GridPane.setConstraints(yearLabel3, 0, 2);

		// Radio Button motorcycle Ad Pane
		TextField yearInput3 = new TextField();
		yearInput3.setPromptText("1980");
		GridPane.setConstraints(yearInput3, 1, 2);

		// Radio Button motorcycle Ad Pane
		Label ccsLabel3 = new Label("Engine Size (cc):");
		GridPane.setConstraints(ccsLabel3, 0, 3);

		// Radio Button motorcycle Ad Pane
		TextField ccsInput3 = new TextField();
		ccsInput3.setPromptText("400");
		GridPane.setConstraints(ccsInput3, 1, 3);

		// Radio Button motorcycle Ad Pane
		Label milesLabel3 = new Label("Miles:");
		GridPane.setConstraints(milesLabel3, 0, 4);

		// Radio Button motorcycle Ad Pane
		TextField milesInput3 = new TextField();
		milesInput3.setPromptText("5000");
		GridPane.setConstraints(milesInput3, 1, 4);

		// Radio Button motorcycle Ad Pane
		Label contactNameLabel3 = new Label("Contact Name:");
		GridPane.setConstraints(contactNameLabel3, 0, 5);

		// Radio Button motorcycle Ad Pane
		TextField contactNameInput3 = new TextField();
		contactNameInput3.setPromptText("John Doe");
		GridPane.setConstraints(contactNameInput3, 1, 5);

		// Radio Button motorcycle Ad Pane
		Label contactNumberLabel3 = new Label("Contact Number:");
		GridPane.setConstraints(contactNumberLabel3, 0, 6);

		// Radio Button motorcycle Ad Pane
		TextField contactNumberInput3 = new TextField();
		contactNumberInput3.setPromptText("xxx-xxx-xxxx");
		GridPane.setConstraints(contactNumberInput3, 1, 6);

		// Radio Button motorcycle Ad Pane
		Label statusLabel3 = new Label("Processing Errors:");
		GridPane.setConstraints(statusLabel3, 0, 10);

		// Radio Button motorcycle Ad Pane
		TextArea errorMessage3 = new TextArea();
		GridPane.setConstraints(errorMessage3, 1, 10);
		errorMessage3.setMaxHeight(100);
		errorMessage3.setEditable(false);

		// Radio Button motorcycle Ad Pane
		Button createButton3 = new Button("Create");
		GridPane.setConstraints(createButton3, 1, 7);

		// Radio Button motorcycle Panes
		motorcycleAd.getChildren().addAll(makeLabel3, makeInput3, modelLabel3, modelInput3, yearLabel3, yearInput3, ccsLabel3,
				ccsInput3, milesLabel3, milesInput3, contactNameLabel3, contactNameInput3, contactNumberLabel3,
				contactNumberInput3, statusLabel3, errorMessage3, createButton3);

		// Pane for handling removing of accounts
		GridPane removeAd = new GridPane();
		removeAd.setPadding(new Insets(10, 10, 10, 10));
		removeAd.setVgap(8);
		removeAd.setHgap(10);

		// Radio Button Remove Pane
		Label adNumberLabel = new Label("Ad Number:");
		GridPane.setConstraints(adNumberLabel, 0, 2);

		// Radio Button Remove Pane
		TextField adNumberInput = new TextField();
		adNumberInput.setPromptText("123");
		GridPane.setConstraints(adNumberInput, 1, 2);

		// Radio Button Remove Pane
		Label statusLabel1 = new Label("Processing Errors:");
		GridPane.setConstraints(statusLabel1, 0, 10);

		// Radio Button Remove Pane
		TextArea errorMessage1 = new TextArea();
		GridPane.setConstraints(errorMessage1, 1, 10);
		errorMessage1.setMaxHeight(100);
		errorMessage1.setEditable(false);

		// Radio Button Remove Pane
		Button removeButton = new Button("Remove");
		GridPane.setConstraints(removeButton, 1, 5);

		// Radio Button Remove Pane
		removeAd.getChildren().addAll(adNumberLabel, adNumberInput, statusLabel1, errorMessage1, removeButton);

		// Radio Button Exit Pane
		TextArea txtOutput = new TextArea();
		txtOutput.setMaxWidth(500);
		txtOutput.setMaxHeight(500);
		txtOutput.setEditable(false);

		// Formatting the radio button menu's location
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(20, 20, 20, 20));
		borderPane.setLeft(menu);

		// Radio dial button actions
		radioGroup.selectedToggleProperty().addListener((observableValue, old_toggle, new_toggle) -> {

			// Radio Button 1 = Boat Classified
			if (radioGroup.getSelectedToggle() == radioButton1) {
				borderPane.setCenter(boatAd);

				createButton1.setOnAction(e -> {
					// Exception handling for mismatch of field requirements using Try/ Catch

					String make = makeInput1.getText();
					String model = modelInput1.getText();
					String year = yearInput1.getText();
					String horsepower = horsepowerInput1.getText();
					String hours = hoursInput1.getText();
					String contactName = contactNameInput1.getText();
					String contactNumber = contactNumberInput1.getText();
				
					int yearInt = Integer.parseInt(year);
					int horsepowerInt = Integer.parseInt(horsepower);
					int hoursInt = Integer.parseInt(hours);

					classifieds.add(new BoatAd(make, model, yearInt, contactName, contactNumber,
							horsepowerInt, hoursInt));

					makeInput1.clear();
					modelInput1.clear();
					yearInput1.clear();
					horsepowerInput1.clear();
					hoursInput1.clear();
					contactNameInput1.clear();
					contactNumberInput1.clear();

					// Alert when classified is opened
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setContentText("Classified Created Successfully!");
					alert.show();

				});
				
			}

			
			// Radio Button 2 = Car Classified
			if (radioGroup.getSelectedToggle() == radioButton2) {
				borderPane.setCenter(carAd);
				createButton2.setOnAction(e -> {
					// Exception handling for mismatch of field requirements using Try/ Catch
					String make = makeInput2.getText();
					String model = modelInput2.getText();
					String year = yearInput2.getText();
					String horsepower = horsepowerInput2.getText();
					String numberWheels = numberWheelsInput2.getText();
					String contactName = contactNameInput2.getText();
					String contactNumber = contactNumberInput2.getText();
				
					int yearInt = Integer.parseInt(year);
					int horsepowerInt = Integer.parseInt(horsepower);
					int numberWheelsInt = Integer.parseInt(numberWheels);
					classifieds.add(new CarAd(make, model, yearInt, contactName, contactNumber,
							horsepowerInt, numberWheelsInt));
					makeInput2.clear();
					modelInput2.clear();
					yearInput2.clear();
					horsepowerInput2.clear();
					numberWheelsInput2.clear();
					contactNameInput2.clear();
					contactNumberInput2.clear();
					// Alert when classified is opened
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setContentText("Classified Created Successfully!");
					alert.show();
				});
			}	
			
			// Radio Button 3 = MotorcycleAd Classified
			if (radioGroup.getSelectedToggle() == radioButton3) {
				borderPane.setCenter(motorcycleAd);

				createButton3.setOnAction(e -> {
					// Exception handling for mismatch of field requirements using Try/ Catch

				String make = makeInput3.getText();
				String model = modelInput3.getText();
				String year = yearInput3.getText();
				String ccs = ccsInput3.getText();
				String miles = milesInput3.getText();
				String contactName = contactNameInput3.getText();
				String contactNumber = contactNumberInput3.getText();
			
				int yearInt = Integer.parseInt(year);
				int ccsInt = Integer.parseInt(ccs);
				int milesInt = Integer.parseInt(miles);

				classifieds.add(new MotorcycleAd(make, model, yearInt, contactName, contactNumber,
						ccsInt, milesInt));

				makeInput3.clear();
				modelInput3.clear();
				yearInput3.clear();
				ccsInput3.clear();
				milesInput3.clear();
				contactNameInput3.clear();
				contactNumberInput3.clear();

				// Alert when classified is opened
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("Classified Created Successfully!");
				alert.show();

			});

		}

			// Radio Button 4 = Removes ad from ArrayList classifieds
			if (radioGroup.getSelectedToggle() == radioButton4) {
				borderPane.setCenter(removeAd);
					
				removeButton.setOnAction(e -> {
					// Exception handling for mismatch of field requirements using Try/ Catch
					try {
						String specifiedAd = adNumberInput.getText();
						int classifiedRemove = Integer.parseInt(specifiedAd);
						Classified temp4 = null;
						for (Classified ad : classifieds) {
							if (ad.getAdNumber() == classifiedRemove) 
								temp4 = ad;
						}
						if (temp4 != null) {
							Alert confirm = new Alert(AlertType.CONFIRMATION);
							confirm.setTitle("Remove Ad");
							confirm.setHeaderText("Remove " + temp4.getMake() + " " + temp4.getModel() + ", Ad #" + temp4.getAdNumber());
							confirm.setContentText("Are you sure?");
						
							if (confirm.showAndWait().get() == ButtonType.OK) {
								classifieds.remove(temp4);
								adNumberInput.clear();
								errorMessage1.clear();
								Alert alert = new Alert(Alert.AlertType.INFORMATION);
								alert.setContentText("Ad Removed!");
								alert.show();
							}
						} else {
							errorMessage1.setText("Ad Number " + specifiedAd + " not found!\n");
							adNumberInput.clear();
						}
					} catch (NumberFormatException er) {
						errorMessage1.setText("Ad Number must be an integer");
						adNumberInput.clear();
					}

				});
			
			}

			// Displays Classifieds
			if (radioGroup.getSelectedToggle() == radioButton5) {

				borderPane.setCenter(txtOutput);
				txtOutput.setText("************   CLASSIFIEDS   ***********\n" + classifieds);
			}


			// Radio Button 6 = Confirms exit of the program. Closes program and saves data
			// upon confirmation
			if (radioGroup.getSelectedToggle() == radioButton6) {
				radioButton6.setOnAction(e -> {

					Alert confirm = new Alert(AlertType.CONFIRMATION);
					confirm.setTitle("Exit Program");
					confirm.setHeaderText("Exit the program?");
					if (confirm.showAndWait().get() == ButtonType.OK) {

						// Exception handling for saving files using Try/ Catch
						try {
							// Create the file then save all account records into it
							ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
							out.writeObject(classifieds);
							out.flush();
							out.close();
						} catch (Exception e1) {
							System.out.println("Unable to save classifieds information");
							System.out.println(e1.getMessage());
							e1.printStackTrace();
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.setContentText("Unable to save classifieds information");
							alert.show();

							System.exit(0);
						}
						System.exit(0);
					}
				});
			}
		});

		Scene scene = new Scene(borderPane, 1000, 500);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}