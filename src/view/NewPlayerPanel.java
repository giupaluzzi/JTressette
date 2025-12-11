package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Schermata per la creazione di un nuovo giocatore.
 * Permette l'inserimento del nickname e la selezione di un avatar.
 */
public class NewPlayerPanel extends HeaderPanel {
	
	private JTextField nicknameField;
	private AvatarSelector avatarSelector;
	private JButton createButton;
	
    /**
     * Costruisce il pannello di creazione.
     * 
     * @param navigator Il controller della navigazione.
     */
	public NewPlayerPanel(Navigator navigator) { 
		super(navigator, Screen.START);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(5, 0, 5, 0); 
		
		// Label Nome
		gbc.gridx = 0; 
		gbc.gridy = 0;
		panel.add(new JLabel("Inserisci il tuo nome:"), gbc);
		
		// Selezione Nome
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		nicknameField = new JTextField(15); 
		panel.add(nicknameField, gbc);
		
		// Label Avatar
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		panel.add(new JLabel("Scegli il tuo avatar:"), gbc);
		
		// Selezione Avatar
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.BOTH; 
		gbc.weighty = 1.0; 
		avatarSelector = new AvatarSelector("resources/avatars/"); 
		panel.add(avatarSelector, gbc);
		
		// Bottone Crea
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weighty = 0.0;
		gbc.insets = new Insets(15, 0, 10, 0);
		
		createButton = new JButton("Crea");
		panel.add(createButton, gbc);
		
		super.addContent(panel);
	}

	
	
	
    /**
     * Recupera il testo inserito nel campo nickname.
     * 
     * @return Il nickname inserito, senza spazi iniziali o finali.
     */
	public String getNickname() {
		return nicknameField.getText().trim();
	}
	
	
	
	
    /**
     * Recupera il nome del file dell'avatar selezionato.
     * 
     * @return Il nome del file avatar.
     */
	public String getSelectedAvatar() {
		return avatarSelector.getSelectedAvatarFileName();
	}
	
	
	
	
    /**
     * Imposta l'azione da eseguire alla pressione del tasto "Crea".
     * 
     * @param action L'ActionListener contenente la logica di creazione.
     */
	public void setCreateAction(ActionListener action) {
		createButton.addActionListener(action);
	}
	
	
	
	/**
	 * Svuota il JTextField per il nickname e resetta la selezione dell'avatar
	 * Usato dal controller quando un giocatore viene effettivamente creato
	 */
	public void resetForm() {
	    nicknameField.setText("");
	    
	    avatarSelector.reset();
	}
}