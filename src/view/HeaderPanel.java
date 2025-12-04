package view;
import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel{

	private JPanel contentPane;
	private JPanel backButtonPanel;
	
	public HeaderPanel(Navigator navigator) 
	{
		/* Imposto il layout */
		setLayout(new BorderLayout());
		
		
		/* Nella sezione superiore inserisco un bottone per andare indietro  
		 * Nella sezione centrale/inferiore andrò ad inserire il panel dell'implementazione concreta */
		JButton backButton = new JButton("<-️");
		
		/* Imposto l'icona per andare indietro
				backButton.setIcon(null); */
		
		backButton.addActionListener(e -> navigator.navigate(Screen.START));
		
        backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        backButtonPanel.add(backButton);

        // Aggiungi il pannello con il bottone nella posizione NORTH
        this.add(backButtonPanel, BorderLayout.NORTH);
        
        
		contentPane = new JPanel();
		add(contentPane, BorderLayout.CENTER);
	}
	
	public void addContent(JComponent comp) 
	{
		contentPane.add(comp);	
	}
}
