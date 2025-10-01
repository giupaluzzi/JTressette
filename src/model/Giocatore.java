package model;
import java.util.*;

abstract public class Giocatore {
	private List<Carta> carteInMano;
	
	public Giocatore()
	{
		this.carteInMano = new ArrayList<>();
	}
		
	public void pescaCarta(Carta c)
	{
		carteInMano.add(c);
	}
	
	public void aggiungiCarte(List<Carta> lista)
	{
		carteInMano.addAll(lista);
	}
	
	public List<Carta> getCarte()
	{
		return carteInMano;
	}
	
	public Carta giocaCarta(Carta c)
	{
		if (carteInMano.remove(c))
			return c;
		else
			throw new IllegalArgumentException("Carta non valida" + c);
	}
	
	public abstract String getNome();
}
