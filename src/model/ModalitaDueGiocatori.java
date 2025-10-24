package model;

import java.util.List;

public class ModalitaDueGiocatori implements ModalitaPartita{

	
	@Override
	public void configuraPartita(Partita partita, List<Giocatore> giocatori) {
		if (giocatori.size() != 2) 
			throw new IllegalArgumentException("Numero di giocatori errato. Giocatori necessari: 2");
		
		Squadra s1 = new Squadra(List.of(giocatori.get(0))); 
		Squadra s2 = new Squadra(List.of(giocatori.get(1)));
		partita.setSquadre(s1, s2);
		
	}
	

}
