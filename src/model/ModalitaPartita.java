package model;

import java.util.List;

/**
 * Interfaccia che definisce il contratto per una modalità di partita.
 * 
 * Questo approccio segue il pattern Strategy, permettendo di cambiare
 * facilmente il comportamento di configurazione della partita senza modificare la classe Partita.
 * 
 */
public interface ModalitaPartita {

    /**
     * Configura una partita con i giocatori forniti secondo la logica specifica della modalità.
     * 
     * @param partita Istanza della partita da configurare
     * @param giocatori Lista dei giocatori che parteciperanno alla partita
     * @throws IllegalArgumentException se il numero di giocatori non è compatibile con la modalità
     */
    void configuraPartita(Partita partita, List<Giocatore> giocatori);

    /**
     * Stampa il numero di giocatori nella modalità di gioco selezionata.
     * 
     * @param numeroGiocatori Numero di giocatori nella partita
     */
    default void stampaInfo(int numeroGiocatori) {
        System.out.println("Modalità con " + numeroGiocatori + " giocatori");
    }
}
