package model;
import java.util.*;

public class Partita {
	private Squadra squadraA;
	private Squadra squadraB;
	private List<Mano> mani;
		
	public Partita(Squadra squadraA, Squadra squadraB) 
	{
		this.squadraA = squadraA;
		this.squadraB = squadraB;
		this.mani = new ArrayList<Mano>();
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
	
	public void distribusciCarte()
	{
		Mazzo mazzo = Mazzo.getInstance();
		for (Giocatore g : squadraA.getGiocatori())
			/* Dai 10 carte */
			g.aggiungiCarte(mazzo.pescaCarte(10));
		
		for (Giocatore g : squadraB.getGiocatori())
			/* Dai 10 carte */
			g.aggiungiCarte(mazzo.pescaCarte(10));
	}
	
	
	public void setSquadre(Squadra s1, Squadra s2) 
	{
		squadraA = s1;
		squadraB = s2;
	}
	
	// TO DO
	public Mano creaMano(Giocatore giocatoreIniziale) 
	{
		return null;
	}
}
