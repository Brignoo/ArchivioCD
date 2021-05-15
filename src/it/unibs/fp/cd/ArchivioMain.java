package it.unibs.fp.cd;
import it.unibs.fp.mylib.MyMenu;

public class ArchivioMain {

	public static void main(String[] args) {
		//creare cd
		String voci[] = {"Aggiungi CD", "Visualizza collezione", "Rimozione CD", "Selezione casuale"};
		MyMenu menu = new MyMenu("ARCHIVIO CD", voci);
		menu.stampaMenu();
        //visualizza collezione cd
        //rimozione cd
        //selezione di un brano a caso estratto dall'intera collezione
		

	}

}
