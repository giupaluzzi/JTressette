package model;

import java.util.List;

public class Squadra {
	private List<Giocatore> giocatori;
	private int punti;
	
	public Squadra(List<Giocatore> giocatori, int punti)
	{
		this.giocatori = giocatori;
		this.punti = punti;
	}
	
	public List<Giocatore> getGiocatori()
	{
		return giocatori;
	}

	public int getPunti()
	{
		return punti;
	}
}
