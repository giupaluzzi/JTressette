package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Componente grafico che mostra una griglia di immagini avatar selezionabili.
 * Scansiona una directory specifica e crea un pulsante per ogni file immagine trovato.
 * Garantisce che un solo avatar sia selezionato alla volta.
 */

public class AvatarSelector extends JPanel {

	/**
	 * Costrutto utilizzato per avere un solo bottone cliccato per volta 
	 * In assenza del buttongroup si potrebbero selezionare due avatar contemporaneamente
	 * */ 
	private ButtonGroup group; 

	
    /**
     * Costruisce il pannello scansionando il path in input
     * 
     * @param path Il path relativo della cartella contenente le immagini degli avatar.
     */
    public AvatarSelector(String path) {
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(0, 3, 10, 10)); 
        group = new ButtonGroup();

        File avatarFolder = new File(path);

        if (!avatarFolder.exists() || !avatarFolder.isDirectory()) {
            System.err.println("ERRORE: Cartella avatar non trovata: " + path);
            gridPanel.add(new JLabel("Nessun avatar."));
        } else {
            
            for (File file : avatarFolder.listFiles()) {
                if (file.isFile() && (file.getName().endsWith(".png") || file.getName().endsWith(".jpg"))) {
                    JToggleButton btn = Factory.createAvatarGridButton(file);
                    group.add(btn);
                    gridPanel.add(btn);
                } 
            }

        }

        reset();

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setPreferredSize(new Dimension(300, 160));

        add(scrollPane, BorderLayout.CENTER);
    }

 
    /**
     * Restituisce il nome del file dell'avatar attualmente selezionato.
     * 
     * @return Il nome del file o null se nessuna selezione.
     */
    public String getSelectedAvatarFileName() {
        if (group.getSelection() != null) {
            return group.getSelection().getActionCommand();
        }
        return null; // Nessuna selezione
    }
    
    public void reset() 
    {
    	group.getElements().nextElement().setSelected(true);	
    }
}