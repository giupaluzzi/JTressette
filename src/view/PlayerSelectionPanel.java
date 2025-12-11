package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Panel per la selezione di un giocatore esistente.
 * Estende HeaderPanel per includere la barra di navigazione superiore.
 * Contiene la lista scorribile dei giocatori e il pulsante di conferma.
 */
public class PlayerSelectionPanel extends HeaderPanel{
	
	private PlayerSelector existingPlayers;
	private JButton confirmButton;
	
	/**
     * Costruisce il pannello di selezione giocatori.
     * 
     * @param navigator Il controller della navigazione
     */
	public PlayerSelectionPanel(Navigator navigator) {
		super(navigator, Screen.START);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Lista Giocatori 
		gbc.gridx = 0; 
		gbc.gridy = 0;
		gbc.weightx = 1.0; 
		gbc.weighty = 1.0;
		
		existingPlayers = new PlayerSelector();
		panel.add(existingPlayers, gbc);
		
		// Bottone Continua 
		gbc.gridy = 1;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 0, 10, 0);
		
		confirmButton = new JButton("Continua");
		confirmButton.setEnabled(false);
		panel.add(confirmButton, gbc);
		
		super.addContent(panel);
	}

	
    /**
     * Imposta l'azione da eseguire quando viene premuto il pulsante "Continua".
     * 
     * @param a L'ActionListener con la logica per il login
     */
	public void addConfirmAction(ActionListener a) 
	{
		this.confirmButton.addActionListener(a);
	}

	
	
	
    /**
     * Restituisce il componente che gestisce la lista dei giocatori.
     * Usato dal Controller per popolare o pulire la lista.
     * 
     * @return L'oggetto PlayerSelector.
     */
	public PlayerSelector getSelector() {
		return existingPlayers;
	}

	
	
    /**
     * Abilita o disabilita il pulsante "Continua".
     * Usato per forzare la scelta di un utente per fare l'accesso da questa sezione
     * 
     * @param e True per abilitare, False per disabilitare.
     */
	public void setConfirmEnabled(boolean e) {
	    confirmButton.setEnabled(e);
	}
}