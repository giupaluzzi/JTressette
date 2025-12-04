package view;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 * Questa è la finestra principale (Main Frame) dell'applicazione JTressette.
 * Agisce come contenitore "Master" per tutte le schermate del gioco.
 * 
 * PATTERN UTILIZZATI:
 * - Observer: La View osserva il Navigator. Quando il Navigator notifica un cambio
 *   di schermata, la View aggiorna il layout.
 * - CardLayout: Gestisce la navigazione mostrando un solo pannello alla volta,
 *   come un mazzo di carte.
 */

@SuppressWarnings("deprecation") 
public class View extends JFrame implements Observer {

    // Questo pannello funge da "mazzo di carte". Contiene tutte le schermate (Start, Gioco, ecc.)
    private JPanel deck;
    
    /**
     * Costruttore della View.
     * Inizializza il frame, il layout manager e registra l'observer.
     */
    public View()
    {
        // Imposta il titolo della finestra
        super("JTressette");
        
        Navigator navigator = new Navigator();
        navigator.addObserver(this);

        // Inizializza il pannello contenitore con il CardLayout
        deck = new JPanel(new CardLayout());

        /* 
         * AGGIUNTA DELLE SCHERMATE AL "MAZZO" (DECK)
         * Ogni pannello viene aggiunto con una chiave univoca (String) presa dall'Enum Screen.
         * Questo permette di richiamarli successivamente tramite il loro nome.
         */
        
        // Schermata Iniziale (Menu)
        deck.add(new StartPanel(navigator), Screen.START.name());
        
        // Schermata Creazione Nuovo Giocatore
        deck.add(new NewPlayerPanel(navigator), Screen.NEW_PLAYER.name());
        
        // Schermata Selezione Giocatore Esistente
        deck.add(new PlayerSelectionPanel(navigator), Screen.PLAYER_SELECTION.name());

        /*
         * REGISTRAZIONE OBSERVER
         * Fondamentale: Diciamo al Navigator "Tienimi informato".
         * Senza questa riga, il metodo update() non verrebbe mai chiamato e la navigazione non funzionerebbe.
         */
        
        navigator.navigate(Screen.START);

        // Aggiunge il pannello "mazzo" al contenitore principale del JFrame
        this.add(deck);

        // Impostazioni standard della finestra
        this.setSize(600, 400); // Dimensioni iniziali
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiude il processo quando si chiude la finestra
        this.setLocationRelativeTo(null); // Centra la finestra nello schermo
        this.setVisible(true); // Rende la finestra visibile
    }

    /**
     * Metodo chiamato automaticamente quando l'oggetto osservato (Navigator)
     * invoca notifyObservers().
     * 
     * @param o   L'oggetto che ha generato la notifica (dovrebbe essere il Navigator).
     * @param arg L'argomento passato (dovrebbe essere l'Enum Screen di destinazione).
     */
    @Override
    public void update(Observable o, Object arg) {
        // Controllo di sicurezza: verifichiamo che la notifica arrivi dal Navigator e contenga uno Screen
        if (o instanceof Navigator && arg instanceof Screen)
        {
            Screen screen = (Screen) arg;
            
            // Recupera il Layout Manager del pannello deck
            CardLayout cl = (CardLayout) deck.getLayout();
            
            // Ordina al Layout Manager di mostrare la carta associata al nome dello Screen
            cl.show(deck, screen.name());
        }
    }

    /**
     * Punto di ingresso dell'applicazione.
     */
    public static void main(String[] args)
    {
        // Nota: In applicazioni Swing reali, è buona norma avvolgere questo in SwingUtilities.invokeLater()
        // per garantire che la UI sia creata nel Thread grafico (EDT).
        
        // 1. Crea la finestra principale
        View app = new View();
        
        // 2. Naviga immediatamente alla schermata iniziale
        
    }
}