package model;
import java.util.*;

public class Passata {

    /** Giocatore che inizia la passata */
    private final Giocatore giocatoreIniziale;

    /** Ordine di gioco dei giocatori in questa passata (già ruotato da Mano) */
    private final List<Giocatore> ordineGiocatori;

    /** Mappa che associa ad ogni giocatore la carta che ha giocato */
    private final Map<Giocatore, Carta> carteGiocate;
    
    /* Indice che tiene traccia del giocatore che deve giocare la carta */
    private int indiceGiocatoreAttuale;
    
    /**
     * Crea una nuova passata con un ordine preciso e un giocatore iniziale.
     *
     * @param ordineGiocatori lista dei giocatori in ordine di gioco (ruotato da Mano)
     * @param giocatoreIniziale il primo che gioca
     */
	public Passata(List<Giocatore> ordine, Giocatore giocatoreIniziale)
	{
		this.ordineGiocatori = new ArrayList<>(ordine);
		this.giocatoreIniziale = giocatoreIniziale;
		
		
		this.carteGiocate = new LinkedHashMap<>();
		for (Giocatore g: ordineGiocatori)
		{
			carteGiocate.put(g, null);
		}
		this.indiceGiocatoreAttuale = 0;
	}
	
	
	/*
	 * Registra la carta giocata da un giocatore (se il giocatore rispetta l'ordine di gioco) 
	 * */
	public void giocaCarta(Giocatore g, Carta c)
	{
		
		if (!g.equals(ordineGiocatori.get(indiceGiocatoreAttuale))) 
			throw new IllegalStateException("Non è il turno di "+ g.getNome());
        
        if (carteGiocate.get(g) != null)
            throw new IllegalArgumentException("Giocatore ha già giocato una carta!");
        
        carteGiocate.put(g, c);
        indiceGiocatoreAttuale ++;
    }
	
	/*
	 * Determina il vincitore della passata se terminata
	 * */
	public Giocatore vincitore() 
	{
		/* Utilizza il compareTo definito in Carta per impostare la vincitrice
		 * */
		if (indiceGiocatoreAttuale < ordineGiocatori.size()) 
			throw new IllegalStateException("Passata non ancora terminata");
		
		return carteGiocate.entrySet()
				.stream()
				.filter(c -> c.getValue().getSeme() == carteGiocate.get(giocatoreIniziale).getSeme())
				.max(Map.Entry.comparingByValue(Carta::compareTo))
				.map(Map.Entry::getKey)
				.orElse(null);
	}
	
	
    /**
     * Restituisce la carta giocata da un determinato giocatore.
     * @param g il giocatore
     * @return la carta giocata o null se non ha ancora giocato
     */
    public Carta getCartaGiocata(Giocatore g) {
        return carteGiocate.get(g);
    }

    /**
     * Restituisce la lista ordinata delle carte giocate nella passata.
     * (Nell’ordine dei turni.)
     */
    public List<Carta> getCarte() {
        return new ArrayList<>(carteGiocate.values());
    }

    /**
     * Verifica se la passata è terminata (cioè tutti hanno giocato).
     * @return true se tutti i giocatori hanno giocato
     */
    public boolean isTerminata() {
        return indiceGiocatoreAttuale >= ordineGiocatori.size();
    }

    /**
     * Restituisce il giocatore che deve giocare ora.
     * @return giocatore corrente o null se la passata è finita
     */
    public Giocatore getGiocatoreAttuale() {
        if (isTerminata()) 
        	return null;
        return ordineGiocatori.get(indiceGiocatoreAttuale);
    }

    /**
     * Restituisce il giocatore che ha iniziato la passata.
     */
    public Giocatore getGiocatoreIniziale() {
        return giocatoreIniziale;
    }

    /**
     * Restituisce la lista dei giocatori in ordine di gioco.
     */
    public List<Giocatore> getOrdineGiocatori() {
        return ordineGiocatori;
    }

}
