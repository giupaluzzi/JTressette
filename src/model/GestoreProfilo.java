package model;

import java.io.*;

public class GestoreProfilo {

	public static void salvaProfilo(Profilo p, String file)
	{
		try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file))) {
			o.writeObject(p);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Profilo caricaProfilo(String file)
	{
		try(ObjectInputStream o = new ObjectInputStream(new FileInputStream(file)))
		{
			return (Profilo) o.readObject();
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
