package it.unibs.fp.cd;

import java.util.ArrayList;

import it.unibs.fp.mylib.EstrazioniCasuali;

/**
 * 
 * La classe ArchivioCd permette di inserire, cercare, visualizzare, eliminare o far avvenire
 * la selezione casuale di un CD
 */

public class ArchivioCd {

    private ArrayList<Cd> cds;
    
    /**
     * Costruttore della classe ArchivioCD
     */
    public ArchivioCd() {
    	cds = new ArrayList<>();
    }

    
    /**
     * Metodo get dell'intero archivio
     * @return ritorna l'archivio
     */
    public ArrayList<Cd> getCds() {
		return cds;
	}
    
	/**
	 * Return di un CD
	 * @param nomeCd stringa nome del Cd, scorre l'archivio per trovare il cd chiesto dall'utente
	 * @return il cd scelto dall'utente
	 */
    public Cd getCd(String nomeCd){ 
    	 for (int i = 0; i < cds.size(); i++) {
    		 
    		 Cd cd = cds.get(i);
    		 String titolo = cd.getTitolo();
    		 
    		 if (titolo.equals(nomeCd))
    			 return cd;
    		 
    	 }
    	 
    	 return null;
    }
    
    /**
     * Il metodo ritorna il CD
     * @param n indica l'indice del CD da cercare
     * @return ritorna il cd scelto
     */
    public Cd getCdByIndex(int n) {
    	
    	if( n < cds.size() ) {
    		return cds.get(n);
    	}
    	
    	return null;
    }
    
  /**
   * Metodo per inserire un CD
   * @param cd per inserire un CD nell'archivio
   * @return il CD aggiunto nell'archivio
   */

    public boolean addCd(Cd cd){
        return cds.add(cd); 
        
    }
    
  
    /**
     * metodo per fare la visualizzazione di un CD nell'archivio
     * @param nomeCd nome del CD
     */
    
    public void stampaCd(String nomeCd){
    	Cd cd = getCd(nomeCd); 
    	System.out.println(cd);    	    	
    }
    
    
    /**
     * metodo per eliminare un CD dell'archivio dato un nome
     * @param nomeCd nome del CD
     */
    public void eliminaCd(String nomeCd) {
    	Cd cd = getCd(nomeCd);
    	cds.remove(cd);
    }
    
    /**
     * metodo per eliminare un CD dell'archivio dato il CD
     * @param cd oggetto Cd da eliminare
     */
    public boolean eliminaCd(Cd cd) {
    	return cds.remove(cd);
    }
    
    /**
     * metodo per la selezione casuale del CD
     * @return il CD casuale all'interno dell'archivio
     */
    
    public Cd cdCasuale() {
    	int indice = EstrazioniCasuali.estraiIntero(0, cds.size()-1);
    	return cds.get(indice);
    	
    }

    /**
     * metodo che restituisce il numero di CD presenti nell'archivio
     * @return di size CD
     */
    
    public int getNumeroCd() {
    
    	return cds.size();
    	
    }

    /**
     * Controlla se un determinato cd è contenuto dell'archivio
     * @param nomeCd stringa nome del Cd, scorre l'archivio per trovare il cd chiesto dall'utente
     * @return un boolean vero se c'è, falso se non c'è
     */
    public boolean contiene(String nomeCd){ 
        for (Cd cd : cds) {
            if(cd.getTitolo().equals(nomeCd))
            return true;
        }
        
        return false;
    }

    /**
	 * Il metodo restituisce una stringa descrittiva del contenuto dell-archivio, 
	 * sfruttandone il metodo toString()
	 */
    @Override
    public String toString(){
        String out = "";
        for (Cd cd : cds) {
            out+=cd.toString()+"\n";
        }
        return out;
    }
}