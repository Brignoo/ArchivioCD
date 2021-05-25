package it.unibs.fp.cd;

import it.unibs.fp.mylib.MyInputDati;
import it.unibs.fp.mylib.MyMenu;

public class ArchivioCdMain {

	private static final String VOCE1 = "Aggiungi CD";
	private static final String VOCE2 = "Visualizza collezione"; 
	private static final String VOCE3 = "Rimozione CD";
	private static final String VOCE4 = "Selezione casuale";
	
	private static final String MENU[] = {VOCE1, VOCE2, VOCE3, VOCE4};
	
	private static final String MESSAGGIO_TITOLO_CD = "\nInserisci il titolo del nuovo CD: ";
	private static final String MESSAGGIO_AUTORE_CD = "Inserisci l'autore del nuovo CD: ";
	private static final String MESSAGGIO_NUMERO_BRANI = "Il nuovo CD quanti brani contiene? ";
	private static final String MESSAGGIO_TITOLO_BRANO = "\nInserisci il titolo del nuovo brano: ";
	private static final String MESSAGGIO_MINUTI_BRANO = "Quanti minuta dura il brano? ";
	private static final String MESSAGGIO_SECONDI_BRANO = "Quanti secondi dura il brano? ";
	private static final String MESSAGGIO_RIMUOVI_BRANO_NOME = "Qual'è il titolo del brano che vuoi rimuovere? ";
	private static final String MESSAGGIO_RIMUOVI_BRANO_NO_CD = "Non è stato trovato nessun brano con quel titolo";

	/**
	 * Metodo per la creazione di un nuovo brano
	 * @return ritorna un ogetto Brano
	 */
	public static Brano creaBrano() {
		
		String titolo;
		int minuti, secondi;
		
		titolo = MyInputDati.leggiStringaNonVuota(MESSAGGIO_TITOLO_BRANO);
		minuti = MyInputDati.leggiInteroNonNegativo(MESSAGGIO_MINUTI_BRANO);
		
		if( minuti > 0 ) {
			secondi = MyInputDati.leggiInteroNonNegativo(MESSAGGIO_SECONDI_BRANO);
		}
		else {
			secondi = MyInputDati.leggiInteroPositivo(MESSAGGIO_SECONDI_BRANO);
		}
		
		
		return new Brano(titolo, minuti, secondi);
	}
	
	/**
	 * Metodo per la creazione di un nuovo CD con l'aggiunta dei brani
	 * @return ritorna un oggetto Cd da aggiungere alla collezione
	 */
	public static Cd creaCd() {
		
		int numTracce;
		
		Cd nuovoCd;
		String titolo, autore;
		
		titolo = MyInputDati.leggiStringaAlfaNumerica(MESSAGGIO_TITOLO_CD);
		autore = MyInputDati.leggiStringaAlfaNumerica(MESSAGGIO_AUTORE_CD);
		numTracce = MyInputDati.leggiInteroPositivo(MESSAGGIO_NUMERO_BRANI);
		
		nuovoCd = new Cd(titolo, autore);
		
		for(; numTracce > 0; numTracce--) {
			
			nuovoCd.aggiungiBrano( creaBrano() );
		}
		
		return nuovoCd;
	}
	/**
	 * Metodo per la rimozione di un CD dall-archivio
	 */
	public static void rimuoviCd(ArchivioCd archivio) {
		
		String titolo;
		
		titolo = MyInputDati.leggiStringaAlfaNumerica(MESSAGGIO_RIMUOVI_BRANO_NOME);
		Cd daRimuovere = archivio.getCd(titolo);
		if(daRimuovere.equals(null)){
			System.out.println(MESSAGGIO_RIMUOVI_BRANO_NO_CD);
		}else{
			archivio.eliminaCd(titolo);
		}
	}
	
	public static void main(String[] args) {
		
		int scelta;
		ArchivioCd archivio = new ArchivioCd();
		
		MyMenu menu = new MyMenu("ARCHIVIO CD", MENU);
		
		do{
			
			scelta = menu.scegli();
			
			switch(scelta) {
				case 1:
					Cd nuovoCd;
					nuovoCd = creaCd();
					archivio.addCd(nuovoCd);
					// aggiungere il cd all'archivio
					break;
					
				case 2:
					//visualizza collezione cd
					System.out.println(archivio.toString());
					break;
					
				case 3:
					//rimozione cd
					break;
					
				case 4:
					//selezione di un brano a caso estratto dall'intera collezione
					break;
			  }

		} while(scelta!=0);
	}
}
