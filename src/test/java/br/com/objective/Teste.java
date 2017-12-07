package br.com.objective;

import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.Test;

public class Teste {

	@Test
	public void dizerOi(){
		
		LocalDate initial = LocalDate.of(2017, 1, 13);
		LocalDate start = initial.withDayOfMonth(1);
		LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());
		
		System.out.println("Hi");
		
//		LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
			
		    System.out.println(date);
		}
	}
}
