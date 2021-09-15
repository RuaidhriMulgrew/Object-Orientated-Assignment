package application;

// Since this is imported here do I even need the Date class I made previously.
import java.time.LocalDate;
import java.io.Serializable;

/**
 * @author Ruaidhri Mulgrew
 * @version 1.0
 * */

// changed this to abstract
// can still be extended into SecondVaccineNeeded class.

// does vaccination have to be abstract
/*
 * I removed the abstract keyword on 24/08/21 to continue working on it.
 * Emailed Denis for clarification.
 * */

public abstract class Vaccination implements Serializable{
	/**
	 * String Name - Represents the client's full name. Name is a seperate class.
	 * int efficacy - Represents the efficacy rating of the vaccine.
	 * LocalDate startDoseDate - Represents the date of the client's first vaccine dose.
	 * */
	private String Name;
	private int efficacy;
	private LocalDate startDoseDate;
	
	
	// Vaccination constructor class
	/**
	 * Vaccination constructor - Creates a Vaccination object with a Name, efficacy and a startDoseDate.
	 * @param String n - The client's full name.
	 * @param Integer e - The vaccine's efficacy rating.
	 * @param LocalDate startDoseDate - The date of the client's first vaccine dose.
	 * */
	public Vaccination(String n, int e, LocalDate localDate) {
		Name = n;
		efficacy = e;
		startDoseDate = localDate;
	}
	
	
	// former abstract method deliveryInfo
	/**
	 * Abstract method deliveryInfo()
	 * @return void.
	 * */
	public abstract void deliveryInfo();
	
	
	
	// Getter Methods
	/**
	 * Returns the name of the vaccine.
	 * @return A String called Name, representing the name of the vaccine.
	 * */
	public String getName() {
		return Name;
	}
	
	/**
	 * Returns the efficacy rating of the vaccine.
	 * @return A Integer representing the efficacy rating.
	 * */
	public int getEfficacy() {
		return efficacy;
	}
	
	/**
	 * Returns the date the client got the first dose of the vaccine.
	 * @return A LocalDate representing the date.
	 * */
	public LocalDate getDate() {
		return startDoseDate;
	}
	
	
	// Setter Methods
	/**
	 * Sets the vaccine's name.
	 * @param A String representing the vaccine's name.
	 * @return void
	 * */
	public void setName(String n) {
		Name = n;
	}
	
	/**
	 * Sets the vaccine's efficacy rating.
	 * @param An Integer representing the vaccine's efficacy.
	 * @return void
	 * */
	public void setEfficacy(int e) {
		efficacy = e;
	}
	
	/**
	 * Sets the first dose date.
	 * @param A LocalDate representing the first dose date.
	 * @return void
	 * */
	public void setStartDoseDate(LocalDate sdd) {
		startDoseDate = sdd;
	}
	
	/**
	 * Vaccination toString method.
	 * @return String - Representing all attributes in the Vaccination class.
	 * */
	// toString
	public String toString() {
		String vaccineFullDetails = Name + " " + efficacy + " " + startDoseDate;
		return vaccineFullDetails ;
	}

}
