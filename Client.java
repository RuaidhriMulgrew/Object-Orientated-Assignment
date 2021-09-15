package application;

import java.io.Serializable;

public class Client implements Serializable {
	private clientName name;
	private String identification;
	private String phoneNumber;
	private FirstVaccineNeeded vac; // added 24/08/21 will need to fully implement.
	// need to create Vaccination class
	
	
	// constructor class
	public Client(clientName n, String id, String pn, FirstVaccineNeeded v) {
		name = n;
		identification = id;
		phoneNumber = pn;
		vac = v;
		
	}
	
	
	// Get ID
	public String getID() {
		return identification;
	}
	
	
	//toString
	public String toString() {
		String clientDetails = name + ", " + identification + ", " + phoneNumber + ", " + vac;
		return clientDetails;
	}
	
	// Display by id toString
	public String id_toString() {
		String displayById = identification + ", " + name + ", " + phoneNumber + ", " + vac;
		return displayById;
	}
	
	// Display by Vaccine toString
	public String vaccine_toString() {
		String displayByVaccine = vac + ", " + name + ", " + identification + ", " + phoneNumber;
		return displayByVaccine;
	}
}
