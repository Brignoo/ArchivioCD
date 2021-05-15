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
	}
	
	public void aggiungiBrano( Brano b ){
		
		brani.add(b);
	}
	
	public Brano getCasuale() {
		
		int indice = EstrazioniCasuali.estraiIntero(0, brani.size());
		
		return brani.get(indice);
	}
	
	@Override
	public String toString() {
		
		String s = "";
		
		for( Brano elemento : brani ) {
			
			s = s + (brani.indexOf(elemento) + 1) + " " + elemento.getTitolo() + "\n";
		}
		
		return null;
	}
	
}
