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
	private static final String MESSAGGIO_RIMUOVI_CD_NOME = "Qual è il titolo del CD che vuoi rimuovere? ";
	private static final String MESSAGGIO_RIMUOVI_NO_CD = "Non è stato trovato nessun CD con quel titolo";
	private static final String MESSAGGIO_ARCHIVIO_VUOTO = "Non ci sono CD nella tua collezione.";
	private static final String MESSAGGIO_RIMUOVI_SET_ID = "\nSeleziona l'id del CD da rimuovere tra i seguenti:";
	private static final String MESSAGGIO_RIMUOVI_SET_ID2 = "-> ";
	
	private static final int MINIMO = 0;
	private static final int MASSIMO = 60;
	private static final int MINIMO_SENZA_ZERO = 1;

	/**
	 * Metodo per la creazione di un nuovo brano
	 * @return ritorna un ogetto Brano
	 */
	public static Brano creaBrano() {
		
		String titolo;
		int minuti, secondi;
		
		titolo = MyInputDati.leggiStringaNonVuota(MESSAGGIO_TITOLO_BRANO);
		minuti = MyInputDati.leggiIntero(MESSAGGIO_MINUTI_BRANO, MINIMO, MASSIMO);
		
		if( minuti > 0 ) {
			secondi = MyInputDati.leggiIntero(MESSAGGIO_SECONDI_BRANO, MINIMO, MASSIMO);
		}
		else {
			secondi = MyInputDati.leggiIntero(MESSAGGIO_SECONDI_BRANO, MINIMO_SENZA_ZERO, MASSIMO);
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
	 * Metodo per la rimozione di un CD dall'archivio
	 */
	public static void rimuoviCd(ArchivioCd archivio) {
		
		String titolo;
		
		titolo = MyInputDati.leggiStringaAlfaNumerica(MESSAGGIO_RIMUOVI_CD_NOME);
		boolean boolRimuovere = archivio.contiene(titolo);
		
		if(!boolRimuovere){
			
			System.out.println(MESSAGGIO_RIMUOVI_NO_CD);
		}
		else{
			
			System.out.println(MESSAGGIO_RIMUOVI_SET_ID);
			int cont=0;
			
			for (Cd questoCD : archivio.getCds()) {
				
				if(questoCD.getTitolo().equals(titolo)){
					
					System.out.println("ID: "+cont+" "+questoCD.toString());
					cont ++;
				}
			}
			
			int scelta = MyInputDati.leggiIntero(MESSAGGIO_RIMUOVI_SET_ID2, 0, cont--);
			
			cont=0;
			
			for (Cd questoCD : archivio.getCds()) {
				
				if(questoCD.getTitolo().equals(titolo)){
					
					if(cont==scelta){
						
						archivio.eliminaCd(questoCD);
						return;
					}
					cont++;
				}
			}
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
					// aggiungere il cd all'archivio
					
					Cd nuovoCd;
					nuovoCd = creaCd();
					
					archivio.addCd(nuovoCd);
					break;
					
				case 2:
					//visualizza collezione cd
					
					if(archivio.getNumeroCd()==0) {
						
						System.out.println(MESSAGGIO_ARCHIVIO_VUOTO);
					}
					else { 
						System.out.println(archivio.toString());
					}
					break;
					
				case 3:
					//rimozione cd
					
					if(archivio.getNumeroCd()==0) {
						
						System.out.println(MESSAGGIO_ARCHIVIO_VUOTO);
					}
					else { 
						rimuoviCd(archivio);
					}
					break;
					
				case 4:
					//selezione di un brano a caso estratto dall'intera collezione
					
					if(archivio.getNumeroCd()==0) {
						
						System.out.println(MESSAGGIO_ARCHIVIO_VUOTO);
					}
					else { 
						archivio.cdCasuale().toString();
					}
					break;
			  }

		} while(scelta!=0);
	}
}
