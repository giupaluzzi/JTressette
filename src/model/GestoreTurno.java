package model;

public class GestoreTurno {
	public Giocatore prossimoGiocatore(Passata p) {
		/* chi deve giocare adesso.*/
		return p.vincitore();
	} 

	public void registraGiocata(Giocatore g, Carta c, Passata p) 
	{
		/* → registra una carta giocata. */
		
	}
}
