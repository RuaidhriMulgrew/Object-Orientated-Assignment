package application;

import java.time.LocalDate;
//import java.io.Serializable;


public abstract class SecondVaccineNeeded extends Vaccination {
	private LocalDate secondDoseDate;
	
	
	public SecondVaccineNeeded(String n, int e, LocalDate localDate) {
		super(n, e, localDate);
		// TODO Auto-generated constructor stub
		String vacName = n;
		int efficacy = e;
		LocalDate firstDoseDate = localDate;
		secondDoseDate = firstDoseDate.plusDays(28);
	}
	
	
	// Getter Method
	public LocalDate getSecondDoseDate() {
		return secondDoseDate;
	}
	
	
	// Setter Method
	public void setSecondDoseDate(LocalDate next) {
		secondDoseDate = next;
	}
}
