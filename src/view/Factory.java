package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.image.*;

/**
 * Classe usata per la creazione centralizzata di componenti grafici.
 */
public final class Factory {
	
	private Factory() {}
	    
    /**
     * Carica un'immagine da un path, la ridimensiona e restituisce un'ImageIcon
     * Se l'immagine non viene trovata, restituisce un'icona vuota trasparente.
     * 
     * @param path Il percorso del file immagine.
     * @param w La larghezza desiderata in pixel.
     * @param h L'altezza desiderata in pixel.
     * @return L'oggetto ImageIcon con l'immagine contenuta nel percorso
     */
    public static ImageIcon createIcon(String path, int w, int h) {
        File imgFile = new File(path);
        if (imgFile.isFile()) {
            ImageIcon icon = new ImageIcon(imgFile.getAbsolutePath());
            Image scaled = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        } else {
            System.err.println("Errore Factory: Immagine non trovata -> " + path);
            return new ImageIcon(new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB));
        }
    }

    
    
    
    /**
     * Crea un pulsante standard per la navigazione all'indietro.
     * 
     * @param navigator Il controller della navigazione.
     * @param screen La schermata di destinazione.
     * @return Un JButton configurato con icona e azione di navigazione.
     */
    public static JButton createBackButton(Navigator navigator, Screen screen) {
        JButton btn = new JButton();
        btn.setIcon(createIcon("resources/icons/back.png", 24, 24));
        btn.setFocusPainted(false);
        btn.addActionListener(e -> navigator.navigate(screen));
        return btn;
    }

    
    
    
    /**
     * Crea un pulsante standard per l'eliminazione.
     * 
     * @return Un JButton configurato esteticamente per le azioni di cancellazione.
     */
    public static JButton createDeleteButton() {
        JButton btn = new JButton();
        btn.setIcon(createIcon("resources/icons/bin.png", 20, 20));
        btn.setFocusPainted(false);
        return btn;
    }

    
    
    
    /**
     * Crea un pulsante contenente il nome e l'avatar del giocatore da utilizzare
     * nella selezione del profilo.
     * 
     * @param name Il nickname del giocatore da visualizzare.
     * @param avatarPath Il percorso dell'immagine avatar.
     * @return Un JToggleButton con layout orizzontale (Icona + Testo).
     */
    public static JToggleButton createPlayerToggleButton(String name, String avatarPath) {
        JToggleButton btn = new JToggleButton(name);
        btn.setIcon(createIcon(avatarPath, 40, 40));
        btn.setIconTextGap(15);
        btn.setFocusPainted(false);
        btn.setActionCommand(name);
        return btn;
    }

    
    
    
    /**
     * Crea un pulsante contenente l'immagine dell'avatar da utilizzare nella 
     * selezione dell'avatar
     * 
     * @param file Il file immagine dell'avatar.
     * @return Un JToggleButton con solo l'icona
     */
    public static JToggleButton createAvatarGridButton(File file) {
        JToggleButton btn = new JToggleButton();
        btn.setActionCommand(file.getName());
        btn.setIcon(createIcon(file.getAbsolutePath(), 60, 60));
        //btn.setFocusPainted(false);
        //btn.setContentAreaFilled(false);
        //btn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return btn;
    }
}



