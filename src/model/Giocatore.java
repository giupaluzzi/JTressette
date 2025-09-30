package model;
import java.util.*;

abstract public class Giocatore {
	private String nickname;
	private int elo;
	private List<Carta> carteInMano;
	
	public Giocatore(String nickname, int elo)
	{
		this.nickname = nickname;
		this.elo = elo;
		this.carteInMano = new ArrayList<>();
	}
	
	public void giocaCarta(Carta c) 
	{
		/* Gioca la carta selezionata*/
		
	}
	
	public void pescaCarta(Carta c)
	{
		carteInMano.add(c);
	}
	
	public void aggiungiCarte(List<Carta> lista)
	{
		carteInMano.addAll(lista);
	}
}
