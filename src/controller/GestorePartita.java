package controller;

import model.*;
import java.util.*;

public class GestorePartita {
	
	private List<Giocatore> giocatori;
	
	private List<Squadra> squadre;
	
	private Partita partita;
	
	private Mazzo mazzo;
	
	
	/*
	 * La classe GestorePartita si occupa di creare e gestire ogni partita.
	 * 
	 * Nello specifico:
	 * - crea le squadre
	 * - crea il mazzo (al primo avvio, negli altri ottiene l'istanza) 
	 * - crea la partita selezionando in automatico 2 o 4 giocatori
	 * 		- crea le squadre
	 * 		while (nessuna squadra supera i 31 punti): 
	 * 			- distribuisce le carte
	 * 			- costituisce l'ordine di gioco
	 * 			- crea la mano
	 * 				- gioca ogni passata (che termina con la pescata se due giocatori)
	 * 				- assegna i punti
	 * 			- termina la mano 
	 * - aggiorna il profilo del GiocatoreUmano 
	 * 
	 * */
	
	public GestorePartita(List<Giocatore> giocatori) {
		this.giocatori=giocatori;
		this.squadre = new ArrayList<>();
		
		if (giocatori.size() == 2) 
		{
			this.squadre.add(new Squadra(List.of(giocatori.get(0))));
			this.squadre.add(new Squadra(List.of(giocatori.get(1))));
		}
		else {	
			this.squadre.add(new Squadra(List.of(giocatori.get(0), giocatori.get(2))));
			this.squadre.add(new Squadra(List.of(giocatori.get(1), giocatori.get(3))));
		}
		
		this.mazzo = Mazzo.getInstance();
		this.mazzo.mescolaMazzo();
		
		this.partita = new Partita(squadre.get(0), squadre.get(1), giocatori);
	}
	
	/* Gestisce il ciclo principale:
	 	- reset punteggi;
		- crea e avvia le mani finché una squadra non vince;
		- aggiorna il profilo giocatore umano alla fine.
	 */
	public void avviaPartita() 
	{
		/* Controllo se non esiste già un vincitore*/
		while (this.partita.vincitore() == null) 
		{
			/* Gioco una mano, composta da una lista di passate  */
			List<Integer> puntiMano = giocaMano(this.partita.creaMano());
			
			
		}
		
		
	}
	
	/*Crea una mano e gestisce le passate */
	public List<Integer> giocaMano(Mano mano) 
	{
		
		return null;
	}
	
	/* Controlla la sequenza dei giocatori, raccoglie la carta giocata 
	  (che la view potrà fornire più tardi), e aggiorna il vincitore della passata.*/
	public void giocaPassata() {}
	
	/* Calcola e assegna i punti della mano alle squadre */
	public void aggiornaPunteggi() {}

	/* Sceglie una carta in base alla logica dell’IA;*/
	public void giocaMossaIA(GiocatoreIA ia) {}

	/* Controlla se qualcuno ha raggiunto 31 punti. */
	public void isPartitaTerminata() {} 

	/* Ottieni il giocatore iniziale per la mano corrente*/
	public void getGiocatoreCorrente() {} 
	
	/* Ottiene il giocatore iniziale della prossima mano*/
	public void getProssimoGiocatore() {} 

	/* Avanza lo stato delle mani nel controller */
	public void prossimaMano() {} 
	
	/* Avanza lo stato delle passate nel controller*/
	public void prossimaPassata() {} 

	/* Mostra i punteggi delle squadre attuali*/
	public void mostraStatoPartita() {}

	/* PLACEHOLDER DA IMPLEMENTARE CON LA VIEW */
	public void richiediCartaDaGiocatore(Giocatore g) {}

	/*  */
	public void notificaVincitore(Squadra s) {}

	/*  */
	public void aggiornaStorico(){}
	
	/*  */
	public void aggiornaRecord(){}
	
}
