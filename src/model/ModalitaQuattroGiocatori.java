package model;

import java.util.List;

public class ModalitaQuattroGiocatori implements ModalitaPartita{

	@Override
	public void configuraPartita(Partita partita, List<Giocatore> giocatori) {
		if (giocatori.size() != 4)
			throw new IllegalArgumentException("Numero di giocatori errato. Giocatori necessari: 4");
		Squadra s1 = new Squadra(List.of(giocatori.get(0), giocatori.get(1))); 
		Squadra s2 = new Squadra(List.of(giocatori.get(2), giocatori.get(3)));
		partita.setSquadre(s1, s2); 
	}

}
