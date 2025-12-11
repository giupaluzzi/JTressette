package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Componente che gestisce una lista verticale scorribile di profili.
 * Supporta la selezione esclusiva 
 */
public class PlayerSelector extends JPanel {

    private ButtonGroup group; 
    private JPanel listContainer;

    
    
    /**
     * Inizializza il selettore vuoto con uno ScrollPane.
     */
    public PlayerSelector() {
        setLayout(new BorderLayout());
        group = new ButtonGroup();
        
        listContainer = new JPanel();
        listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));
        
        JScrollPane scroll = new JScrollPane(listContainer);   
        scroll.setBorder(null);
        add(scroll, BorderLayout.CENTER);
    }

    
    
    
    /**
     * Aggiunge una riga visuale rappresentante un giocatore alla lista.
     * 
     * @param nickname Il nome del giocatore.
     * @param avatarFilename Il nome del file dell'avatar.
     * @param onDelete L'azione da eseguire quando si clicca sul tasto elimina.
     * @param onSelect L'azione da eseguire quando si seleziona la riga.
     */
    public void addPlayerToView(String nickname, String avatarFilename, ActionListener onDelete, ActionListener onSelect) {
        PlayerSave row = new PlayerSave(nickname, avatarFilename);
        
        group.add(row.getSelectButton());
        
        row.addDeleteAction(onDelete);
        row.addSelectAction(onSelect);
        
        listContainer.add(row);
        listContainer.add(Box.createVerticalStrut(5));
        
        listContainer.revalidate();
    }
    
    /**
     * Svuota completamente la lista e resetta la selezione.
     */
    public void clearList() {
        listContainer.removeAll();
        group.clearSelection(); 
        group = new ButtonGroup(); 
        listContainer.revalidate();
        listContainer.repaint();
    }

    /**
     * Recupera il nickname del giocatore selezionato.
     * 
     * @return Il nickname selezionato o null se la selezione è vuota.
     */
    public String getSelectedPlayerName() {
        if (group.getSelection() != null) {
            return group.getSelection().getActionCommand();
        }
        return null;
    }
    
    /**
     * Classe interna che rappresenta una singola riga della lista.
     * Contiene il pulsante di selezione (Avatar + Nome) e il pulsante di eliminazione.
     */
    private static class PlayerSave extends JPanel {
        
        private JToggleButton selectButton;
        private JButton deleteButton;

        public PlayerSave(String nickname, String avatarFilename) {
            setLayout(new BorderLayout(5, 0));
            setMaximumSize(new Dimension(Integer.MAX_VALUE, 50)); 
            
            selectButton = Factory.createPlayerToggleButton(nickname, "resources/avatars/" + avatarFilename);
            deleteButton = Factory.createDeleteButton();

            add(selectButton, BorderLayout.CENTER);
            add(deleteButton, BorderLayout.EAST);
        }

        public JToggleButton getSelectButton() 
        { 
        	return selectButton; 
        }
        
        
        public void addDeleteAction(ActionListener action) 
        { 
        	deleteButton.addActionListener(action); 
        }
        
        
        public void addSelectAction(ActionListener action) 
        { 
        	selectButton.addActionListener(action); 
        }
    }
}