package model;

import java.util.List;

public class ModalitaTreGiocatori implements ModalitaPartita{

	
	@Override
	public void configuraPartita(Partita partita, List<Giocatore> giocatori) {
		if (giocatori.size() != 3)
			throw new IllegalArgumentException("Numero di giocatori errato. Giocatori necessari: 3");
		Giocatore morto = new GiocatoreMorto();
		Squadra s1 = new Squadra(List.of(giocatori.get(0), morto)); 
		Squadra s2 = new Squadra(List.of(giocatori.get(1), giocatori.get(2)));
		partita.setSquadre(s1, s2); 
	}

}
