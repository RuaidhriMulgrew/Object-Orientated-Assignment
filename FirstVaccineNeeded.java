package application;

import java.time.LocalDate;
import java.io.Serializable;

public class FirstVaccineNeeded extends Vaccination implements Serializable{

	
	public FirstVaccineNeeded(String n, int e, LocalDate localDate) {
		super(n, e, localDate);
		// TODO Auto-generated constructor stub
		String vacName = n;
		int efficacy = e;
		LocalDate firstDoseDate = localDate;
		
	}

	@Override
	public void deliveryInfo() {
		System.out.println("0.5ml of Vaccine is delivered via syringe into non-dominant arm.");
	}
}
