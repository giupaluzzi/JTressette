package model;
import java.util.*;

public class Mano {
	private Map<Squadra, List<Carta>> prese;
	private List<Passata> passate;
	
	public Mano(Squadra s1, Squadra s2) 
	{
		prese = new HashMap<>();
		prese.put(s1, new ArrayList<Carta>());
		prese.put(s2, new ArrayList<Carta>());
		this.passate = new ArrayList<Passata>();
	}
	
	public void addPresa(Giocatore giocatore, List<Carta> carte) 
	{
		/* 
		 * Prendi la squadra a cui appartiene il giocatore 
		 * e aggiungi le carte prese
		 * 
		 * */		
		for (Squadra s : prese.keySet())
			if (s.getGiocatori().contains(giocatore))
				prese.get(s).addAll(carte);
	}
	
	public int calcolaPunteggio(Squadra s) 
	{
		double punteggio = 0.0;
		for (Carta c : prese.get(s))
			punteggio += c.getValore().getPunti();
		return (int) Math.round(punteggio);
	}
}
