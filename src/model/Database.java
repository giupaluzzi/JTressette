package model;

import java.io.*;
import java.util.*;

public class Database {

	private static Database instance;
	private static final String SAVE_DIR = "saves/";
	
	
	private Database() 
	{
		File directory = new File(SAVE_DIR);
		if (!directory.exists()) {
			directory.mkdir();
		}
		
	}
	
	public static Database getInstance() 
	{
		if (instance == null)
			instance = new Database();
		
		return instance;
	}
	
	public void save(Profilo p)
	{
		
		String filename = "saves/" + p.getNickname() + ".dat";
		try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename))) {
			o.writeObject(p);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Profilo load(String nickname)
	{
		String file = "saves/" + nickname + ".dat";
        
		/* Verifico che il file esiste */
		if (!new File(file).exists()) 
			return null;
		
		try(ObjectInputStream o = new ObjectInputStream(new FileInputStream(file)))
		{
			return (Profilo) o.readObject();
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void delete(String nickname) 
	{
		File file = new File(SAVE_DIR + nickname + ".dat");
		
		if (file.isFile()) 
		{
			/* Elimino il file*/
			boolean deleted = file.delete();
			if (!deleted) {
				/* Non è stato eliminato */
				System.out.println("Impossibile eliminare il file: " + file);
			}
		}
		/* Eccezione: non è un file*/
	}
	

	public List<Profilo> loadAll()
	{
		List<Profilo> profili = new ArrayList<>();
		
		File folder = new File(SAVE_DIR);
		
		if(!folder.exists() || !folder.isDirectory()) 
		{
			return profili;
		}
		
		for (File file : folder.listFiles()) {
        
            if (file.isFile() && file.getName().endsWith(".dat")) {
                
            	try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(file))) {
                    
            		Profilo p = (Profilo) o.readObject();
                    profili.add(p);
                    
                } catch (Exception e) {
                    
                	System.err.println("File corrotto ignorato: " + file.getName());
                }
            }
        }
        
		return profili;
	}
	
}
