package it.unibs.fp.cd;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Brano {
	
	
	private static final String DESCRIZIONE = "%s [%s:%s] ";
	
	private String titolo;
	private int minuti;
	private int secondi;

	public Brano(String titolo, int minuti, int secondi) {
		super();
		this.titolo = titolo;
		this.minuti = minuti;
		this.secondi = secondi;
	}

	public String getTitolo() {
		
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		
		this.titolo = titolo;
	}
	
	public String toString() {
		
		String m, s;
		
		if( minuti < 10 ) {
			
			m = "0" + minuti;
		}
		else {
			
			m = "" + minuti;
		}
		
		if( secondi < 10 ) {
			
			s = "0" + secondi;
		}
		else {
			
			s = "" + secondi;
		}
		
		return String.format(DESCRIZIONE, this.titolo, m, s);
	}

}
