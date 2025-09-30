package model;

import java.util.*;

public class Mazzo {
	static private Mazzo istanza;
	private List<Carta> carte = new ArrayList<Carta>();
	
	public static Mazzo getInstance() {
		if (istanza == null)
			istanza = new Mazzo();
		return istanza;
	}
	
	private Mazzo() 
	{
		for (Carta.Seme s : Carta.Seme.values()) 
			for (Carta.Valore v : Carta.Valore.values())
				carte.add(new Carta(s, v));
	}
	
	public void mescolaMazzo()
	{
		Collections.shuffle(carte);
	}
	
	public List<Carta> pescaCarte(int n)
	{
		if (carte.isEmpty() || carte.size() - n < 0)
			/* Errore -> aggiungere exception */
			return null;
		
		List<Carta> pescata = new ArrayList<Carta>();
		for (int i = 0; i < n; i++)
			pescata.add(carte.remove(new Random().nextInt(carte.size())));
		return pescata;
	}
	
}
