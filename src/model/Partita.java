package model;
import java.util.*;

public class Partita {
	private Squadra squadraA;
	private Squadra squadraB;
	private List<Mano> mani;
	
	/* Aggiungi ordine di gioco */
	private List<Giocatore> ordineGiocatori;
	
	private int primoGiocatoreCorrente;
	
	

	public Partita(Squadra squadraA, Squadra squadraB, List<Giocatore> ordineGiocatori) 
	{
		this.squadraA = squadraA;
		this.squadraB = squadraB;
		this.mani = new ArrayList<>();
		
		this.ordineGiocatori = new ArrayList<>(ordineGiocatori);

		
		/* Se la partita è a 4: 
		 * 		Imposto il giocatoreIniziale in base a chi ha il 4 di denari
		 * Altrimenti:
		 * 		è uno a caso tra i 2 
		 */
		if (ordineGiocatori.size() > 2) {
			for (Giocatore g : ordineGiocatori) 
			{
				for (Carta c: g.getCarte())
					if ((c.getSeme() == Carta.Seme.DENARI) && (c.getValore()== Carta.Valore.QUATTRO))
					{
						this.primoGiocatoreCorrente = ordineGiocatori.indexOf(g);
						break;
					}
				if (ordineGiocatori.indexOf(g) == primoGiocatoreCorrente)
					break;				
			}
		}
		else {
			this.primoGiocatoreCorrente = (int) (Math.random() * 2);
		}
	}
	
	public int calcolaPunteggioFinale(Squadra s)
	{
		/* Somma i punti di ogni Mano */
		return s.getPunti();
	}
	
	public Squadra vincitore() 
	{
		/* Controlla se il punteggio finale è >= 31 */
		if ((squadraA.getPunti() > squadraB.getPunti()) && (squadraA.getPunti() >= 31))
			return squadraA;
		else if ((squadraB.getPunti() > squadraA.getPunti()) && (squadraB.getPunti() >= 31)) 
			return squadraB;
		else 
			return null;
	}
	
	public void distribuisciCarte()
	{
		Mazzo mazzo = Mazzo.getInstance();
		mazzo.mescolaMazzo();
		for (Giocatore g : squadraA.getGiocatori())
			/* Dai 10 carte */
			g.aggiungiCarte(mazzo.pescaCarte(10));
		
		for (Giocatore g : squadraB.getGiocatori())
			/* Dai 10 carte */
			g.aggiungiCarte(mazzo.pescaCarte(10));
	}
	
	public List<Giocatore> getOrdineGiocatori() 
	{
		return this.ordineGiocatori;
	}
	
	public void setSquadre(Squadra s1, Squadra s2) 
	{
		squadraA = s1;
		squadraB = s2;
	}
	

	public Mano creaMano() 
	{
		/* Mischia e distribuisce le carte */ 
		distribuisciCarte();
		
		/* Ruota di una posizione rispetto al precedente 
		 * giocatore iniziale (inizializzato con il 4 di denari nel costruttore)
		 * */
		
		Mano m = new Mano(squadraA, squadraB, ordineGiocatori, primoGiocatoreCorrente);
		mani.add(m);
		
		primoGiocatoreCorrente = (primoGiocatoreCorrente + 1) % ordineGiocatori.size();		
		return m;
	}
}
