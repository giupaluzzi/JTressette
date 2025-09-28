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
}
