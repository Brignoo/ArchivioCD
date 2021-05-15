package it.unibs.fp.cd;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Brano {
	
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
		
		return this.titolo + " [" + this.minuti + ":" + this.secondi + "] ";
	}

}
