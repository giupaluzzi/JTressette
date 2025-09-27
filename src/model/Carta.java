package model;

public class Carta implements Comparable<Carta>
{
	public enum Seme {
		DENARI, SPADE, COPPE, BASTONI
	}
	
	public enum Valore {
		TRE(10, 0.33), 
		DUE(9, 0.33), 
		ASSO(8, 1.0), 
		DIECI(7, 0.33), 
		NOVE(6, 0.33), 
		OTTO(5, 0.33),
		SETTE(4, 0.0),
		SEI(3, 0.0),
		CINQUE(2, 0.0),
		QUATTRO(1, 0.0);
		
		private final double punti;
		private final int forza;
		
		Valore (int forza, double punti) 
		{
			this.punti = punti;
			this.forza = forza;
		}
		
		public int getForza()
		{ 
			return forza; 
		}
		
		public double getPunti() 
		{
			return punti;
		}
		
	}
	
	private final Seme seme;
	private final Valore valore;
	
	public Carta(Seme seme, Valore valore) 
	{
		this.seme = seme;
		this.valore = valore;
	}
	
	@Override
	public int compareTo(Carta c) {
		return Integer.compare(this.valore.getForza(), c.valore.getForza());
	}
	
	public Seme getSeme() 
	{
	    return seme;
	}

	public Valore getValore() 
	{
	    return valore;
	}
	
	@Override
	public String toString()
	{
		return valore + " di " + seme;
	}
	
}
