package it.unibs.fp.cd;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * La classe brano contiene i metodi di utilità per la gestione di un brano musicale
 */
public class Brano {
	
	
	private static final String DESCRIZIONE = "%s [%s:%s] ";
	
	private String titolo;
	private int minuti;
	private int secondi;

	/**
	 * Costruttore della classe
	 * @param titolo contiene il titolo del brano
	 * @param minuti contiene un intero rappresentante i minuti
	 * @param secondi contiene un intero rappresentante i secondi
	 */
	public Brano(String titolo, int minuti, int secondi) {
		super();
		this.titolo = titolo;
		this.minuti = minuti;
		this.secondi = secondi;
	}

	/**
	 * Il metodo permette di ottenere il titolo di un brano
	 * @return ritorna una stringa contenente il titolo
	 */
	public String getTitolo() {
		
		return titolo;
	}
	
	/**
	 * Il metodo permette di cambiare il titolo ad un brano
	 * @param titolo accetta come parametro una stringa contenente il nuovo titolo
	 */
	public void setTitolo(String titolo) {
		
		this.titolo = titolo;
	}
	

	/**
	 * Il metodo restutuisce una stringa contenente una descrizione del brano attraverso i suoi attributi
	 */
	@Override
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
