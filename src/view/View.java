package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
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

	
	/* TODO */
	// static Font FONT = new Font("Cascadia Code", Font.PLAIN, 14);
    static String LOGO = "/resources/icons/logo_jframe.png";

    /* TODO
	static {
        UIManager.put("Label.font", FONT);
        UIManager.put("Label.foreground", Color.DARK_GRAY);
        UIManager.put("Label.background", Color.WHITE);
        UIManager.put("Button.font", FONT);
        // UIManager.put("Button.border", Factory.border(new Color(224, 49, 49)));
        UIManager.put("Button.foreground", new Color(224, 49, 49));
        UIManager.put("Button.background", new Color(255, 201, 201));
        UIManager.put("Button.highlight", Color.WHITE);
        UIManager.put("Button.select", Color.WHITE);
        UIManager.put("Button.focus", Color.WHITE);
        UIManager.put("Panel.background", new Color(233, 236, 239));
    }
    */
    
    
	
	
    // Questo pannello funge da "mazzo di carte". Contiene tutte le schermate (Start, Gioco, ecc.)
    private JPanel deck;
    
    
    private NewPlayerPanel newPlayerPanel;
    private PlayerSelectionPanel playerSelectionPanel;
    private StartPanel startPanel;
    /**
     * Costruttore della View.
     * Inizializza il frame, il layout manager e registra l'observer.
     */
    public View()
    {
        // Imposta il titolo della finestra
        super("JTressette");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Imposto il logo TODO*/
        try {
        	File logo = new File(LOGO);
        	setIconImage(ImageIO.read(getClass().getResource(logo.getAbsolutePath())));
            
        } catch (Exception e) {
        	//System.out.println("Non è stato possibile recuperare il logo dal path: " + LOGO);
        }
        
        
        
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
        startPanel = new StartPanel(navigator); 
        deck.add(startPanel, Screen.START.name());
        
        // Schermata Creazione Nuovo Giocatore
        newPlayerPanel =new NewPlayerPanel(navigator); 
        deck.add(newPlayerPanel, Screen.NEW_PLAYER.name());
        
        // Schermata Selezione Giocatore Esistente
        playerSelectionPanel = new PlayerSelectionPanel(navigator);
        deck.add(playerSelectionPanel, Screen.PLAYER_SELECTION.name());
        


        // Aggiunge il pannello "mazzo" al contenitore principale del JFrame
        this.add(deck);

        // Impostazioni standard della finestra
        this.setSize(600, 400); // Dimensioni iniziali
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

    public NewPlayerPanel getNewPlayerPanel() {
        return newPlayerPanel;
    }

    public PlayerSelectionPanel getPlayerSelectionPanel() {
        return playerSelectionPanel;
    }
}