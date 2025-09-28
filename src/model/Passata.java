package model;
import java.util.*;

public class Passata {
	private Map<Giocatore, Carta> carteGiocate;
	
	public Passata(Map<Giocatore, Carta> carteGiocate)
	{
		this.carteGiocate = carteGiocate;
	}
	
	public Giocatore vincitore() 
	{
		/* Utilizza il compareTo definito in carta per impostare la vincitrice
		 * */
		return carteGiocate.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue(Carta::compareTo))
				.map(Map.Entry::getKey)
				.orElse(null);
	}
	
	public List<Carta> getCarte()
	{
		return new ArrayList<>(carteGiocate.values());
	}
}
