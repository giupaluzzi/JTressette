package controller;

import view.*;
import model.*;
import javax.swing.*;
import java.util.List;

public class ProfileController {
	private final View view;
	private final Navigator navigator;
	
    public ProfileController(View view, Navigator navigator) {
        this.view = view;
        this.navigator = navigator;

        // Appena nasce, "attacca" la logica ai pannelli
        initNewPlayerLogic();
        initSelectionLogic();
    }
    
    
    public void initNewPlayerLogic() 
    {
    	NewPlayerPanel panel = view.getNewPlayerPanel();
    	
    	panel.setCreateAction(e -> {
				String nickname = panel.getNickname();
				String avatar = panel.getSelectedAvatar();
				
				if (nickname.isEmpty()) 
				{
					JOptionPane.showMessageDialog(panel, "Inserisci un nickname!", "Errore", JOptionPane.ERROR_MESSAGE);
	                return;
				}
				
				if (Database.getInstance().load(nickname) != null) {
			        JOptionPane.showMessageDialog(view, 
			            "Nickname già in uso.\nScegline un altro.", 
			            "Nome non disponibile", 
			            JOptionPane.ERROR_MESSAGE);
			        return; 
			    }
				
				
				/* Creo il nuovo profilo */
				Profilo p = new Profilo(nickname, avatar);
				
				Database.getInstance().save(p);
				
				/* Effettuo il login */
				Session.getInstance().login(p);
				refreshPlayerList(view.getPlayerSelectionPanel());
				
				panel.resetForm();
				navigator.navigate(Screen.MAIN_MENU);
			});
    }
    
    public void initSelectionLogic() 
    {
    	PlayerSelectionPanel panel = view.getPlayerSelectionPanel();
    	
        refreshPlayerList(panel);
        
    	panel.addConfirmAction(e ->{
    		
    		String nickname = panel.getSelector().getSelectedPlayerName();
    		
    		if (nickname != null) 
    		{
    			Profilo p = Database.getInstance().load(nickname);
    			
    			Session.getInstance().login(p);
				
				navigator.navigate(Screen.MAIN_MENU);
    		}
    		
    	});
    	
    	
    }
    
    
    public void refreshPlayerList(PlayerSelectionPanel panel) 
    {
    	panel.getSelector().clearList();
    	
    	panel.setConfirmEnabled(false);
    	
    	List<Profilo> profili = Database.getInstance().loadAll();
    	
    	for (Profilo p : profili) 
    	{
    		panel.getSelector().addPlayerToView(
    				p.getNickname(), 
    				p.getAvatarName(), 
    				e -> {
    					if (JOptionPane.showConfirmDialog(
    				            panel, 
    				            "Vuoi eliminare il salvataggio di " + p.getNickname() + "?", 
    				            "Conferma Eliminazione", 
    				            JOptionPane.YES_NO_OPTION, 
    				            JOptionPane.QUESTION_MESSAGE) 
    						== JOptionPane.YES_OPTION) 
    					{
    	                    Database.getInstance().delete(p.getNickname());
    	                    refreshPlayerList(panel);
    	                }
    				},
    				e -> panel.setConfirmEnabled(true)
			);
    	}
    }
    
}