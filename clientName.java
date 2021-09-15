package application;

import java.io.Serializable;

/**
 * @author Ruaidhri Mulgrew
 * @version 1.0
 * */


public class clientName implements Serializable {
	/**
	 * String firstname - Represents the client's first name
	 * String lastname - Represents the client's last name
	 * */
	private String firstname;
	private String lastname;
	
	/**
	 * clientName constructor - Creates a client with a first and last name.
	 * @param String fn - The clients first name.
	 * @param String ln - The clients last name.
	 * */
	public clientName(String fn, String ln) {
		firstname = fn;
		lastname = ln;
	}
	
	
	// Getter Methods
	/**
	 * Returns the clients first name
	 * @return A String representing the clients first name.
	 * */
	public String getFirstName() {
		return firstname;
	}
	
	/**
	 * Returns the clients last name
	 * @return A String representing the clients last name.
	 * */
	public String getLastName() {
		return lastname;
	}
	
	
	// Setter Methods
	/**
	 * Sets the clients first name
	 * @param fn - A String representing the clients first name.
	 * */
	public void setFirstName(String fn) {
		firstname = fn;
	}
	
	/**
	 * Sets the clients last name
	 * @param ln - A String representing the clients last name.
	 * */
	public void setLastName(String ln) {
		lastname = ln;
	}
	
	
	// toString
	/**
	 * A toString method that returns a String fullname which is the clients firstname plus their lastname.
	 * @return fullname - A String representing the clients full name.
	 * */
	public String toString() {
		String fullname = firstname + " " + lastname;
		return fullname;
	}
}
