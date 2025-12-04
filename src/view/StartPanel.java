package view;

import java.awt.*;

import javax.swing.*;

public class StartPanel extends JPanel{
	public StartPanel(Navigator navigator) {
		/* Imposto il layout */
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		/* Da sostituire con un logo */
		JLabel title = new JLabel("JTressette");
		
		/* Nuovo Giocatore */
		JButton newPlayer = new JButton("Nuovo Giocatore");
		newPlayer.addActionListener(e -> navigator.navigate(Screen.NEW_PLAYER));
		
		/* Carica */
		JButton carica = new JButton("Carica");
		carica.addActionListener(e -> navigator.navigate(Screen.PLAYER_SELECTION));
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridwidth = 3;
	    gbc.insets = new Insets(20, 0, 40, 0);  // margine sotto il titolo
		add(title, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.ipadx = 30;
		gbc.ipady = 10;
		gbc.insets = new Insets(0,0,0,0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		//gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridwidth = 1;
		add(newPlayer, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.ipadx = newPlayer.getWidth() + 30;
		gbc.ipady = 10;
		gbc.insets = new Insets(0,0,0,0);
		//gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;
		add(carica, gbc);
	}
}
