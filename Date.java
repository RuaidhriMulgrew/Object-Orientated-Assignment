package application;

import java.io.Serializable;
import java.time.LocalDate;

public class Date implements Serializable{
	// removed in place of LocalDate
//	String Day;
//	String Month;
//	String Year;
	
	private LocalDate dateObj;
	
	// LocalDate Constructor
	public Date(LocalDate n) {
		dateObj = n;
	}
	
	
	// LocalDate Getter
	public LocalDate getLocalDate() {
		return dateObj;
	}
	
	
	// LocalDate Setter
	public void setLocalDate(LocalDate n) {
		dateObj = n;
	}
}
