package model;

/**
 * @author giuseppepaluzzi
 * 
 * Rappresenta una carta da gioco del mazzo di carte italiane 
 * Ogni carta è definita da un {@link Seme} e un {@link Valore}.
 * 
 * La classe implementa l'interfaccia {@link Comparable} per consentire
 * il confronto tra carte in base alla loro "forza".
 * 
 */

public class Carta implements Comparable<Carta>
{
	private final Seme seme;
	private final Valore valore;

	/**
	 * Insieme dei possibili semi delle carte
	 * */
	public enum Seme {
		DENARI, SPADE, COPPE, BASTONI
	}
	
	
	/**
	 * Insieme dei possibili valori delle carte.
	 * Un valore è composto da:
	 * - forza di gioco
	 * - punti
	 * */
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
		
		
		/**
		 * Costruttore del valore di una carta.
		 * 
		 * @param forza La forza associata al valore della carta, da utilizzare nei confronti in {@link Carta#compareTo}
		 * @param punti I punti assegnati al valore della carta
		 * */
		Valore (int forza, double punti) 
		{
			this.punti = punti;
			this.forza = forza;
		}
		
		
		/**
		 * Restituisce la forza associata ad una valore
		 * 
		 * @return forza La forza associata al valore della carta
		 * */
		public int getForza()
		{ 
			return forza; 
		}
		
		
		/**
		 * Restituisce i punti associati al valore della carta
		 * 
		 * @return punti I punti associati al valore della carta
		 * */
		public double getPunti() 
		{
			return punti;
		}
	}
	
	
	
	/**
	 * Costruttore di una carta
	 * 
	 * @param seme Il seme della carta
	 * @param valore Il valore della carta
	 * */
	public Carta(Seme seme, Valore valore) 
	{
		this.seme = seme;
		this.valore = valore;
	}
	
	
    /**
     * Confronta questa carta con un'altra dello stesso seme in base alla forza del {@link Valore}.
     *
     * @param c La carta da confrontare
     * @return un numero negativo, zero o positivo se questa carta ha
     *         rispettivamente meno, uguale o maggiore forza della carta c
     * */
	@Override
	public int compareTo(Carta c) {
		return Integer.compare(this.valore.getForza(), c.valore.getForza());
	}
	
	
    /**
     * Restituisce il seme della carta.
     *
     * @return seme Il seme della carta
     * */
	public Seme getSeme() 
	{
	    return seme;
	}

	
    /**
     * Restituisce il valore della carta.
     *
     * @return valore Il valore della carta
     * */
	public Valore getValore() 
	{
	    return valore;
	}
	
	
	/**
     * Restituisce una rappresentazione testuale della carta
     *
     * @return stringa descrittiva della carta
     * */	
	@Override
	public String toString()
	{
		return valore + " di " + seme;
	}
}
