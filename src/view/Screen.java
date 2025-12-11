package view;

public enum Screen {
    /* Schermata iniziale 
     * (Titolo + Nuova Partita + Carica) */
    START, 
    
    /** Form per creare un nuovo profilo 
     * (Nome + Avatar) */
    NEW_PLAYER, 
    
    /** Lista per scegliere un profilo esistente */
    PLAYER_SELECTION,
    
    /** Il menu principale DOPO il login 
     * (Gioca + Storico + Impostazioni) */
    MAIN_MENU,       
    
    /** Schermata dove scegli 2, 3 o 4 giocatori */
    GAME_MODE_SELECTION, 
    
    /** Il tavolo da gioco vero e proprio */
    GAME_TABLE,      
    
    /** Schermata dello storico partite */
    STATISTICS,      
    
    /** Schermata impostazioni utente */
    SETTINGS         
}
