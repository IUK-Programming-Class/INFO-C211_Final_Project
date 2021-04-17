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

		// Radio Button Ad Panes
		Label makeLabel = new Label("Make:");
		GridPane.setConstraints(makeLabel, 0, 0);

		// Radio Button Ad Panes
		TextField makeInput = new TextField();
		makeInput.setPromptText("Bayliner");
		GridPane.setConstraints(makeInput, 1, 0);

		// Radio Button Ad Panes
		Label modelLabel = new Label("Model");
		GridPane.setConstraints(modelLabel, 0, 1);

		// Radio Button Ad Panes
		TextField modelInput = new TextField();
		modelInput.setPromptText("X-15");
		GridPane.setConstraints(modelInput, 1, 1);

		// Radio Button Ad Panes
		Label yearLabel = new Label("Year:");
		GridPane.setConstraints(yearLabel, 0, 2);

		// Radio Button Ad Panes
		TextField yearInput = new TextField();
		yearInput.setPromptText("2015");
		GridPane.setConstraints(yearInput, 1, 2);

		// Radio Button Boat Panes
		Label horsepowerLabel = new Label("Horsepower:");
		GridPane.setConstraints(horsepowerLabel, 0, 3);

		// Radio Button Boat Panes
		TextField horsepowerInput = new TextField();
		horsepowerInput.setPromptText("75");
		GridPane.setConstraints(horsepowerInput, 1, 3);

		// Radio Button Boat Panes
		Label hoursLabel = new Label("Hours:");
		GridPane.setConstraints(hoursLabel, 0, 4);

		// Radio Button Boat Panes
		TextField hoursInput = new TextField();
		hoursInput.setPromptText("175");
		GridPane.setConstraints(hoursInput, 1, 4);

		// Radio Button Ad Panes
		Label contactNameLabel = new Label("Contact Name:");
		GridPane.setConstraints(contactNameLabel, 0, 5);

		// Radio Button Ad Panes
		TextField contactNameInput = new TextField();
		contactNameInput.setPromptText("John Doe");
		GridPane.setConstraints(contactNameInput, 1, 5);

		// Radio Button Ad Panes
		Label contactNumberLabel = new Label("Contact Number:");
		GridPane.setConstraints(contactNumberLabel, 0, 6);

		// Radio Button Ad Panes
		TextField contactNumberInput = new TextField();
		contactNumberInput.setPromptText("xxx-xxx-xxxx");
		GridPane.setConstraints(contactNumberInput, 1, 6);

		// Radio Button Ad Panes
		Label statusLabel = new Label("Processing Errors:");
		GridPane.setConstraints(statusLabel, 0, 10);

		// Radio Button Ad Panes
		TextArea errorMessage = new TextArea();
		GridPane.setConstraints(errorMessage, 1, 10);
		errorMessage.setMaxHeight(100);
		errorMessage.setEditable(false);

		// Radio Button Ad Panes
		Button createButton = new Button("Create");
		GridPane.setConstraints(createButton, 1, 7);

		// Radio Button Boat Panes
		boatAd.getChildren().addAll(makeLabel, makeInput, modelLabel, modelInput, yearLabel, yearInput, horsepowerLabel,
				horsepowerInput, hoursLabel, hoursInput, contactNameLabel, contactNameInput, contactNumberLabel,
				contactNumberInput, statusLabel, errorMessage, createButton);

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

				createButton.setOnAction(e -> {
					// Exception handling for mismatch of field requirements using Try/ Catch

					String make = makeInput.getText();
					String model = modelInput.getText();
					String year = yearInput.getText();
					String horsepower = horsepowerInput.getText();
					String hours = hoursInput.getText();
					String contactName = contactNameInput.getText();
					String contactNumber = contactNumberInput.getText();
				
					int yearInt = Integer.parseInt(year);
					int horsepowerInt = Integer.parseInt(horsepower);
					int hoursInt = Integer.parseInt(hours);

					classifieds.add(new BoatClassified(123, make, model, yearInt, contactName, contactNumber,
							horsepowerInt, hoursInt));

					makeInput.clear();
					modelInput.clear();
					yearInput.clear();
					horsepowerInput.clear();
					hoursInput.clear();
					contactNameInput.clear();
					contactNumberInput.clear();

					// Alert when classified is opened
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setContentText("Classified Created Successfully!");
					alert.show();

				});
			}

//				// Radio Button 4 = Removes account from ArrayList Account
//				if (radioGroup.getSelectedToggle() == radioButton4) {
//					borderPane.setCenter(removeAccount);
//
//					removeButton.setOnAction(e -> {
//						// Exception handling for mismatch of field requirements using Try/ Catch
//						try {
//							String customerAccount = customerAccountInput4.getText();
//							int accountNumberRemove = Integer.parseInt(customerAccount);
//							Account temp4 = null;
//
//							for (Account account : accounts) {
//								if (account.getAccountNumber() == accountNumberRemove) {
//									temp4 = account;
//								}
//							}
//							if (temp4 != null) {
//
//								Alert confirm = new Alert(AlertType.CONFIRMATION);
//								confirm.setTitle("Remove Account");
//								confirm.setHeaderText("Remove " + temp4.getCustomer().getName() + "'s Account #"
//										+ temp4.getAccountNumber());
//								confirm.setContentText("Are you sure?");
//								if (confirm.showAndWait().get() == ButtonType.OK) {
//
//									accounts.remove(temp4);
//									customerAccountInput4.clear();
//									bankMessage4.clear();
//									Alert alert = new Alert(Alert.AlertType.INFORMATION);
//									alert.setContentText("Account Removed!");
//									alert.show();
//								}
//
//							} else {
//								bankMessage4.setText("Account Number not found!\n");
//							}
//
//						} catch (NumberFormatException er) {
//							bankMessage4.setText("Account/Amount: integers only");
//						}
//
//					});
//				}
//
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
