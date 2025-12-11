package view;
import javax.swing.*;
import java.awt.*;

abstract public class HeaderPanel extends JPanel{

	private JPanel contentPane;
	private JPanel backButtonPanel;
	
	public HeaderPanel(Navigator navigator, Screen screen) 
	{
		/* Imposto il layout */
		setLayout(new BorderLayout());
		
		backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
        backButtonPanel.add(Factory.createBackButton(navigator, screen));

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
