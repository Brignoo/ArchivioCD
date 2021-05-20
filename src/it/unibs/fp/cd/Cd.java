package it.unibs.fp.cd;

import java.util.ArrayList;

import it.unibs.fp.mylib.EstrazioniCasuali;

/**
 * La classe CD permette di creare una collezione di brani e:
 * modificare, selezionare in modo casuale, e non, un brano dal CD
 */
public class Cd {

	private String titolo;
	private String autore;
	private ArrayList <Brano> brani;
	
	/**
	 * Costruttore della classe CD
	 * @param titolo stringa del titolo del CD
	 * @param autore stringa autore del CD
	 */
	public Cd(String titolo, String autore) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.brani = new ArrayList<Brano>();
	}
	
	/**
	 * Metodo per l'aggiunta di un brano al CD
	 * @param b oggetto Brano da aggiungere alla collezione
	 */
	public void aggiungiBrano( Brano b ){
	
		this.brani.add(b);
	}
	
	/**
	 * Metodo per la scelta casuale di un brano da un CD
	 * @return ritorna un oggetto Brano scelto casualmente nel CD
	 */
	public Brano branoCasuale() {
		
		int indice = EstrazioniCasuali.estraiIntero(0, brani.size()-1);
		
		return brani.get(indice);
	}
	
	/**
	 * Metodo che restituisce un brano dato l'indice a cui è memorizzato
	 * @param indice riferimento da utilizzare per la ricerca del brano
	 * @return ritorna un oggetto Brano se questo viene trovato, altrimenti ritorna null
	 */
	public Brano getBrano( int indice ) {
		
		if( indice >= 0 && indice < brani.size() ) {
			
			return brani.get(indice);
		}
		
		return null;
	}
	
	/**
	 * Il metodo permette di confrontare il titolo del CD con un titolo preso come argomento
	 * @param titolo stringa contenente il titolo da confrontare
	 * @return ritorna un valore booleano che è true se i titoli sono uguali, false viceversa.
	 */
	public boolean haTitolo(String titolo) {
		
		if( this.titolo.equals(titolo) ) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Il metodo restituisce una stringa descrittiva del CD attraverso i suoi attributi, specificando i brani contenuti, 
	 * sfruttandone il metodo toString()
	 */
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
