package application;

// Imports
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;

// imports I added.
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.DatePicker;


public class Main extends Application {
	
	// Initializing Labels, Buttons, etc
	// Labels
	Text mainHeader = new Text("Client/Vaccine App");
	
	// Primary Stage Buttons
	private Button CreateClientButton;
	

	// creating a button to test contents of mainClientList
	private Button testmCL;
	private Button removeClient;
	
	
	// creating new ClientCollection
	// will have to replace mainClientList with mainClientList2.
	public ClientCollection mainClientList2 = new ClientCollection();
	
	
	private Button findClientById;
	private TextField findClientByIDTF;
	
	// createClientWindow Labels
	Text firstNameLabel = new Text("First Name");
	Text lastNameLabel = new Text("Last Name");
	Text phoneNumberLabel = new Text("Phone Number");
	Text idLabel = new Text("ID");
	Text vaccineNameLabel = new Text("Vaccine Name");
	Text efficacyLabel = new Text("Efficacy");
	Text doseDateLabel = new Text("First Dose Date");
	
	// Database
	private Button deleteStatement;
	private TextField deleteClientByID;
	
	// createClientWindow TextFields
	private TextField firstNameTF;
	private TextField lastNameTF;
	private TextField uniqueIDTF;
	private TextField phoneNumberTF;
	private TextField vaccineNameTF;
	private TextField efficacyTF;
	private DatePicker doseDateDP;
//	private DatePicker secondDoseDateDP;
	private TextField secondDoseDateTF;
	
	// createClientWindow Buttons
	private Button closeCreateClientWindow;
	private Button addClientButton;
	
	
	Stage createClientWindow = new Stage();
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Added Thursday 26/08/21
			// Loads in any Client objects from clients.ser
			Client deserializedClient = SerializeClient.Deserialize();
			// only returning one item from clients.ser atm.
			
			// deserializedClient is added to the ArrayList of Client objs upon starting application
			mainClientList2.addClient(deserializedClient);
			// clearing list upon loading in deserialized objs results in an IndexOutOfBoundsException
			
			// connecting to db, returns success.
			DBConnect.connectToDB();
			
			
			// Assigning text to the buttons inside createClientWindow
			CreateClientButton = new Button("Create Client");
			
			// creating a TableView to display clients
			TableView<Client> displayTableView = new TableView<Client>(); // added Client as a parameter
			
			testmCL = new Button("Show Clients");
			removeClient = new Button("Remove Client");
			findClientById = new Button("Find Client by ID");
			findClientByIDTF = new TextField();
			deleteStatement = new Button("Delete Stmt");
			deleteClientByID = new TextField();
			
			
			// createClientWindow TextFields
			firstNameTF = new TextField();
			lastNameTF = new TextField();
			uniqueIDTF = new TextField();
			phoneNumberTF = new TextField();
			vaccineNameTF = new TextField();
			efficacyTF = new TextField();
			doseDateDP = new DatePicker();
			
			
			// Buttons
			closeCreateClientWindow = new Button("Close Create Client Window");
			addClientButton = new Button("Add Client");
			
			
			GridPane root = new GridPane();
			
			// Adding nodes to the GridPane root
			root.add(mainHeader, 0, 0);
			root.add(CreateClientButton, 0, 1);
			root.add(testmCL, 0, 2);
			root.add(removeClient, 0, 3);
			root.add(findClientById, 0, 4);
			root.add(findClientByIDTF, 1, 4);
			root.add(deleteStatement, 0, 5);
			root.add(deleteClientByID, 1, 5);
			

//			root.add(displayTableView, 0, 5);
			
			// I commented out the TableView because I couldn't get it working.
			// I left this here just to show how I was doing it.
			
			// Creating columns for TableView displayTableView.
			
//			// First name column
//			TableColumn<Client, String> nameCol = new TableColumn<>("Name");
//			nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
//			
//			// Last name column
//			TableColumn<Client, String> lastNameCol = new TableColumn<>("Last Name");
//			lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
//			
//			// Id column
//			TableColumn<Client, String> idCol = new TableColumn<>("ID");
//			idCol.setCellValueFactory(new PropertyValueFactory<>("identification"));
//			
//			// Phone number column
//			TableColumn<Client, String> phoneCol = new TableColumn<>("Phone");
//			phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
//			
//			// Efficacy column
//			TableColumn<Client, Integer> efficacyCol = new TableColumn<>("Efficacy");
//			efficacyCol.setCellValueFactory(new PropertyValueFactory<>("efficacy"));
//			
//			// Vaccine column
//			TableColumn<Client, String> vaccineCol = new TableColumn<>("Vaccine");
//			vaccineCol.setCellValueFactory(new PropertyValueFactory<>("vac"));
//			
//			// First Dose Date
//			TableColumn<Client, String> firstDoseDateCol = new TableColumn<>("First Dose Date");
//			firstDoseDateCol.setCellValueFactory(new PropertyValueFactory<>("firstDoseDate"));
//			
//			// Second Dose Date
//			TableColumn<Client, String> secondDoseDateCol = new TableColumn<>("Second Dose Date");
//			secondDoseDateCol.setCellValueFactory(new PropertyValueFactory<>("secondDoseDate"));
//			
//			
//			
//			// Adding columns to TableView
//			displayTableView.getColumns().add(nameCol);
//			displayTableView.getColumns().add(lastNameCol);
//			displayTableView.getColumns().add(idCol);
//			displayTableView.getColumns().add(phoneCol);
//			displayTableView.getColumns().add(efficacyCol);
//			displayTableView.getColumns().add(vaccineCol);
//			displayTableView.getColumns().add(firstDoseDateCol);
//			displayTableView.getColumns().add(secondDoseDateCol);

			
			int sizeOfMainClientList2 = mainClientList2.getSize();
			System.out.println("mainClientList2 size() = "+sizeOfMainClientList2);
			
			// attempting to add each element in mainClientList2 to tableview
			for(int i = 0; i < mainClientList2.getSize(); i++) {
				displayTableView.getItems().add(mainClientList2.getClient(i));
			}
			
			
			
			
			// createClientButton action.
			CreateClientButton.setOnAction(actionEvent ->  {
				
				GridPane createClientGP = new GridPane();
				
				// Adding nodes to createClientGridPane
				createClientGP.add(firstNameLabel,0,0);
				createClientGP.add(lastNameLabel,0,1);
				createClientGP.add(phoneNumberLabel,0,2);
				createClientGP.add(idLabel,0,3);
				createClientGP.add(closeCreateClientWindow,1,8);
				createClientGP.add(addClientButton,0,8);
				createClientGP.add(firstNameTF,1,0);
				createClientGP.add(lastNameTF,1,1);
				createClientGP.add(phoneNumberTF,1,2);
				createClientGP.add(uniqueIDTF,1,3);
				createClientGP.add(vaccineNameLabel, 0, 4);
				createClientGP.add(efficacyLabel, 0, 5);
				createClientGP.add(doseDateLabel, 0, 6);
				createClientGP.add(vaccineNameTF, 1, 4);
				createClientGP.add(efficacyTF, 1, 5);
				createClientGP.add(doseDateDP, 1, 6);
				
				
				
				
				Scene createClientScene = new Scene(createClientGP, 450, 450);
				
				createClientWindow.setTitle("Create A New Client");
				createClientWindow.setScene(createClientScene);
				createClientWindow.show();
			});
			
			
			// closeCreateClientWindow Button, exitButton
			closeCreateClientWindow.setOnAction(actionEvent -> {
				createClientWindow.close();
			});
			
			
			// addClientButton
			addClientButton.setOnAction(actionEvent -> {
				// assigning string variables from first & last name textfields to a newName object.
				clientName newName = new clientName(firstNameTF.getText(), lastNameTF.getText());
				
				// assigning details from GUI to FirstVaccineNeeded, which is a subclass of Vaccination
				FirstVaccineNeeded vaccineDetails = new FirstVaccineNeeded(vaccineNameTF.getText(), getIntFromEfficacyTF(efficacyTF), doseDateDP.getValue());
				
				// SecondVaccineNeeded constructor
//				SecondVaccineNeeded secondVacDetails = new SecondVaccineNeeded(vaccineNameTF.getText(), getIntFromEfficacyTF(efficacyTF), doseDateDP.getValue());
				
				// If Client recieves Pfizer or Moderna, then they will require a second dose.
				String moderna = "moderna";
				String pfizer = "pfizer";
				
				int comparisonModerna = moderna.compareToIgnoreCase(vaccineDetails.getName());
				int comparisonPfizer = pfizer.compareToIgnoreCase(vaccineDetails.getName());
				
				if(comparisonModerna == 0 || comparisonPfizer == 0) {
					// secondVaccineNeeded
					secondDoseDateTF.setText("plus 28 days");
//					SecondVaccineNeeded secondDose = SecondVaccineNeeded(vaccineNameTF.getText(), getIntFromEfficacyTF(efficacyTF), doseDateDP.getValue());
					final Stage dialog = new Stage();
	                dialog.initModality(Modality.APPLICATION_MODAL);
	                dialog.initOwner(primaryStage);
	                VBox dialogVbox = new VBox(20);
	                dialogVbox.getChildren().add(new Text("Your second dose of the vaccine is due : in 28 days time.+.getDate()"));
	                Scene dialogScene = new Scene(dialogVbox, 200, 200);
	                dialog.setScene(dialogScene);
	                dialog.show();
				
				}
				
				
				// assigning newName obj and id and phone variables to newClient object
				Client newClient = new Client(newName, uniqueIDTF.getText(), phoneNumberTF.getText(), vaccineDetails);
				
				// passing new client details to insertStatement to test string for SQL
				DBConnect.insertStatement(uniqueIDTF.getText(), newName, phoneNumberTF.getText(), vaccineNameTF.getText(), getIntFromEfficacyTF(efficacyTF), doseDateDP.getValue());
				
				// will test adding serialization here after object is created.
				SerializeClient.Serialize(newClient);
				
				
				
				// testing output of newName, newClient. prints to console
				System.out.println("new clientname: " + newName.toString());
				System.out.println("new client: " + newClient.toString());
				
				
				mainClientList2.addClient(newClient);
				
				
				// after client is created, clear text fields.
				firstNameTF.clear();
				lastNameTF.clear();
				uniqueIDTF.clear();
				phoneNumberTF.clear();
				vaccineNameTF.clear();
				efficacyTF.clear();
				doseDateDP.setValue(null);
				secondDoseDateTF.clear();
			});
			
			
						
			// testmCL Button set on action
			testmCL.setOnAction(actionEvent -> {
				
				System.out.println("mainClientList2: ");
				mainClientList2.showClients();
			});
			
			
			removeClient.setOnAction(actionEvent -> {
				System.out.println("Removed element from mainClientList[0].");
				mainClientList2.removeClient();
			});
			
			
			// Find client by id button action
			findClientById.setOnAction(actionEvent -> {
				// put the textarea.getText() equal to below string variable.
				String fcById = findClientByIDTF.getText();
				mainClientList2.findClientByID(fcById);
				
			});
			
			
			// Delete Client from Database Button
			deleteStatement.setOnAction(actionEvent -> {
				String idToDelete = deleteClientByID.getText();
				DBConnect.deleteStatement(idToDelete);
				System.out.println("Deleting ID: "+idToDelete+" from database.");
			});
			
			
			// Primary Scene size
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* I created this method to convert Strings taken from efficacyTF into Integers.
	 * So they can be passed to the Vaccination constructor.
	 * */
	public static int getIntFromEfficacyTF(TextField efficacy) {
		String textToBeConverted = efficacy.getText();
		int efficacyCoverted = Integer.parseInt(textToBeConverted);
		return efficacyCoverted;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

