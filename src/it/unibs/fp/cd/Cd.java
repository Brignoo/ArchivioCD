package it.unibs.fp.cd;

import java.util.ArrayList;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class Cd {

	private String titolo;
	private String autore;
	private ArrayList <Brano> brani;
	
	public Cd(String titolo, String autore) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.brani = new ArrayList<Brano>();
	}
	
	public void aggiungiBrano( Brano b ){
	
		this.brani.add(b);
	}
	
	public Brano branoCasuale() {
		
		int indice = EstrazioniCasuali.estraiIntero(0, brani.size()-1);
		
		return brani.get(indice);
	}
	
	public Brano getBrano( int indice ) {
		
		if( indice >= 0 && indice < brani.size() ) {
			
			return brani.get(indice);
		}
		
		return null;
	}
	
	public boolean haTitolo(String titolo) {
		
		if( this.titolo.equals(titolo) ) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		
		String s = "Titolo: " + this.titolo + ", Autore: " + this.autore + ", Lista dei brani: ";
		
		if ( !brani.isEmpty() ) {
			
			for( Brano elemento : brani ) {
		
				s = s + elemento.toString();
			}
		}
		return s;
	}
	
}
