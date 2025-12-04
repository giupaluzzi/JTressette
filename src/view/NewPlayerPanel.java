package view;

import javax.swing.*;
import java.awt.*;

public class NewPlayerPanel extends HeaderPanel{
	
	public NewPlayerPanel(Navigator navigator) 
	{ 
		super(navigator);
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		
		panel.add(new JLabel("Inserisci il tuo nome: \n"), gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(new JTextField(), gbc);
		
		
		/* panel.add(Space) */
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.fill = 0;
		panel.add(new JLabel("Scegli il tuo avatar: \n"), gbc);
		
		/* Aggiungo un componente Lista con gli avatar disponibili (nuova classe) */
		/* panel.add(new AvatarList(path) */
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.insets = new Insets(10, 0, 10, 0);
		gbc.anchor = GridBagConstraints.PAGE_END;
		JButton createButton = new JButton("Crea");
		
		/* Aggiungo l'azione di creazione del giocatore nel db e invoco il navigator per andare al MainMenu 
			createButton.addActionListener(...);
		*/
		
		panel.add(createButton, gbc);
		
		super.addContent(panel);
	}

}
