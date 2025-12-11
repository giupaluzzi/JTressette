package view;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Navigator extends Observable {

	public void navigate(Screen screen)
	{
		setChanged();
		notifyObservers(screen);
	}
	
	
}
