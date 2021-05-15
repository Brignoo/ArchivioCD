package it.unibs.fp.cd;
import it.unibs.fp.mylib.MyMenu;

public class ArchivioMain {
	
	private static final String VOCE1 = "Aggiungi CD";
	private static final String VOCE2 = "Visualizza collezione"; 
	private static final String VOCE3 = "Rimozione CD";
	private static final String VOCE4 = "Selezione casuale";
	
	private static final String MENU[] = {VOCE1, VOCE2, VOCE3, VOCE4}; 

	public static void main(String[] args) {
		//creare cd
		MyMenu menu = new MyMenu("ARCHIVIO CD", MENU);
		menu.stampaMenu();
        //visualizza collezione cd
        //rimozione cd
        //selezione di un brano a caso estratto dall'intera collezione
		

	}

}
