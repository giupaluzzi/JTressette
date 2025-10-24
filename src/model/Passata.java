package model;
import java.util.*;

public class Passata {
	private Giocatore giocatoreIniziale;
	private Map<Giocatore, Carta> carteGiocate;
	
	public Passata(List<Giocatore> giocatori, Giocatore giocatoreIniziale)
	{
		this.carteGiocate = new HashMap<Giocatore, Carta>();
		for (Giocatore g : giocatori)
			carteGiocate.put(g, null);
		
		this.giocatoreIniziale = giocatoreIniziale;
	}
	
	public Giocatore vincitore() 
	{
		/* Utilizza il compareTo definito in Carta per impostare la vincitrice
		 * */
		return carteGiocate.entrySet()
				.stream()
				.filter(c -> c.getValue().getSeme() == carteGiocate.get(giocatoreIniziale).getSeme())
				.max(Map.Entry.comparingByValue(Carta::compareTo))
				.map(Map.Entry::getKey)
				.orElse(null);
	}
	
	public List<Carta> getCarte()
	{
		return new ArrayList<>(carteGiocate.values());
	}
	
	public Carta getCartaIniziale()
	{
		return carteGiocate.get(giocatoreIniziale);	
	}
	
	public boolean turnoTerminato() 
	{
		return carteGiocate.values().stream().allMatch(Objects::nonNull);
	}
}
