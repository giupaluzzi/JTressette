package model;
import java.util.*;

/**
 * Classe che rappresenta una singola Mano di una Partita.
 * 
 * Una Mano è composta da 10 (3,4 giocatori) o 20 (2 giocatori) "Passate", durante le quali
 * ciascun giocatore gioca una carta. Alla fine di ogni passata viene
 * determinato un vincitore, che sarà il giocatore iniziale della passata
 * successiva.
 * 
 * La Mano tiene traccia:
 * - delle carte vinte da ciascuna Squadra ("prese")
 * - della sequenza delle passate giocate
 * - dell'ordine dei giocatori e del giocatore iniziale
 */
public class Mano {
    /** Mappa che associa ad ogni squadra la lista delle carte vinte in questa mano */
	private Map<Squadra, List<Carta>> prese;
	
    /** Tutte le passate che compongono questa mano */
    private final List<Passata> passate;

    /** Lista fissa dei giocatori, in ordine base (es. alternato tra le squadre) */
    private final List<Giocatore> ordineGioco;

    /** Indice del giocatore che deve iniziare la prossima passata */
    private int indiceIniziale;
    
    
    /**
     * Crea una nuova Mano in una partita
     * 
     * @param s1 squadra A
     * @param s2 squadra B
     * @param ordineGioco lista dei giocatori nell'ordine base (es. [A1, B1, A2, B2])
     * @param primoGiocatore giocatore che inizia la prima passata
     */
	public Mano(Squadra s1, Squadra s2, List<Giocatore> ordineGioco, int primoGiocatore) 
	{
		prese = new HashMap<>();
		prese.put(s1, new ArrayList<>());
		prese.put(s2, new ArrayList<>());
		
		
		this.passate = new ArrayList<>();
		
		this.ordineGioco = new ArrayList<>(ordineGioco);
		
		this.indiceIniziale = primoGiocatore;
		if(indiceIniziale < 0 || indiceIniziale > 4) 
			throw new IllegalArgumentException("Errore nell'inizializzazione del giocatore iniziale");
	}
	
	
	/**
     * Crea e aggiunge una nuova Passata alla Mano.
     * L’ordine dei giocatori è calcolato partendo dal giocatore iniziale corrente.
     */
	public void creaPassata() 
	{
		
		List<Giocatore> ordinePassata = new ArrayList<>();
		int numGiocatori = ordineGioco.size();
		
		for (int i = 0; i < numGiocatori; i++) 
		{
			/* Ogni passata prende il giocatore iniziale ricrea l'ordine di gioco partendo dal primo giocatore 
			 * Esempio: gIniziale = 3, ordine = [1,2,3,4] -> ordinePassata = [3,4,1,2]
			 * */
			ordinePassata.add(ordineGioco.get((indiceIniziale+i) % numGiocatori));
		}
		
		Giocatore giocatoreInizialePassata = ordinePassata.get(0);	
		
		Passata p = new Passata(ordinePassata, giocatoreInizialePassata);
		passate.add(p);
	}
	
	
    /**
     * Termina l’ultima passata, registra la presa e aggiorna il prossimo giocatore iniziale.
     */
	public void finisciPassata() 
	{
		if (passate.isEmpty())
			throw new IllegalStateException("Nessuna passata giocata in questa mano");
		
		/* Prelevo l'ultima passata e il suo vincitore */
		Passata ultimaPassata = passate.get(passate.size()-1);
		Giocatore vincitore = ultimaPassata.vincitore();
		
		if (vincitore == null)
			throw new IllegalStateException("Impossibile determinare il vincitore della passata");
		
		addPresa(vincitore, ultimaPassata.getCarte());
		
		/* Imposto il giocatore iniziale per la prossima passata*/
		this.indiceIniziale = ordineGioco.indexOf(vincitore);
	}

	
	
    /**
     * Aggiunge le carte vinte dal giocatore vincitore alla squadra corrispondente.
     */
	public void addPresa(Giocatore giocatore, List<Carta> carte) 
	{
		/* 
		 * Prendi la squadra a cui appartiene il giocatore 
		 * e aggiungi le carte prese
		 * 
		 * */		
		for (Squadra s : prese.keySet())
			if (s.getGiocatori().contains(giocatore)) {
				prese.get(s).addAll(carte);
				break;
			}
		}
	
	
	
	/*
	 * Calcola i punti di una squadra
	 * */
	public int calcolaPunteggio(Squadra s) 
	{
		double punteggio = 0.0;
		for (Carta c : prese.get(s))
			punteggio += c.getValore().getPunti();
		return (int) Math.round(punteggio);
	}
	
	
	
	/* 	UTILITY	*/
	
    /** Restituisce tutte le passate della mano */
    public List<Passata> getPassate() {
        return passate;
    }

    /** Restituisce le prese della squadra */
    public List<Carta> getPrese(Squadra s) {
        return prese.getOrDefault(s, List.of());
    }

    /** Restituisce il giocatore che inizierà la prossima passata */
    public Giocatore getGiocatoreIniziale() {
        return ordineGioco.get(indiceIniziale);
    }

    /** Restituisce l’ordine base dei giocatori */
    public List<Giocatore> getOrdineGioco() {
        return ordineGioco;
    }

}
