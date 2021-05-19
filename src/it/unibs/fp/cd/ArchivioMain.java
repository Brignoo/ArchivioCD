package it.unibs.fp.cd;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.InputDati;

public class ArchivioMain {
	
	private static final String VOCE1 = "Aggiungi CD";
	private static final String VOCE2 = "Visualizza collezione"; 
	private static final String VOCE3 = "Rimozione CD";
	private static final String VOCE4 = "Selezione casuale";
	private static final String MESSAGGIO_SWITCH = "-> ";
	private static final String MESSAGGIO_TITOLO_CD = "Inserisci il titolo del nuovo CD: ";
	private static final String MESSAGGIO_AUTORE_CD = "Inserisci l'autore del nuovo CD: ";
	private static final String MESSAGGIO_NUMERO_BRANI = "Il nuovo CD quanti brani contiene? ";
	private static final String MESSAGGIO_TITOLO_BRANO = "Inserisci il titolo del nuovo brano: ";
	private static final String MESSAGGIO_MINUTI_BRANO = "Quanti minuta dura il brano? ";
	private static final String MESSAGGIO_SECONDI_BRANO = "Quanti secondi dura il brano? ";
	
	private static final String MENU[] = {VOCE1, VOCE2, VOCE3, VOCE4}; 

	public static void main(String[] args) {
		
		MyMenu menu = new MyMenu("ARCHIVIO CD", MENU);
		int scelta;
		do{
			menu.stampaMenu();
			scelta = InputDati.leggiIntero(MESSAGGIO_SWITCH, 0, 4);
			
			switch(scelta) {
				case 1:
				  //creare cd
					String titolo = InputDati.leggiStringaNonVuota(MESSAGGIO_TITOLO_CD);
					String autore = InputDati.leggiStringaNonVuota(MESSAGGIO_AUTORE_CD);
					Cd nuovo = new Cd(titolo, autore);
					for(int nTracce = InputDati.leggiInteroPositivo(MESSAGGIO_NUMERO_BRANI); nTracce>=0; nTracce--) {
						titolo = InputDati.leggiStringaNonVuota(MESSAGGIO_TITOLO_BRANO);
						int minuti = InputDati.leggiInteroNonNegativo(MESSAGGIO_MINUTI_BRANO);
						int secondi = InputDati.leggiInteroPositivo(MESSAGGIO_SECONDI_BRANO);
						Brano nuovoBrano = new Brano(titolo, minuti, secondi);
						nuovo.aggiungiBrano(nuovoBrano);
					}
					// !! qui bisogna aggiungere il cd all'archivio
				  break;
				case 2:
				  //visualizza collezione cd
					//pota qua dovete ancora implementare la classe archivio CD
				  break;
				case 3:
				  //rimozione cd
					//anche qua dovete ancora implementare la classe archivio CD
				  break;
				case 4:
				  //selezione di un brano a caso estratto dall'intera collezione
					//ma quanto ci mettete ad implementare la classe archivio CD? Che io qua devo fare i metodi!
				  break;
			  }

		}while(scelta!=0);
	}
}