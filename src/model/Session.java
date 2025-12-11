package model;

public class Session {
	private static Session instance;
	private Profilo loggedUser;
	
	private Session() {}
	
	public static Session getInstance() 
	{
		if (instance == null) 
			instance = new Session(); 
		return instance;
	}
	
	public Profilo getLoggedUser() 
	{
		return this.loggedUser;
	}
	
	public void login(Profilo user) 
	{
		this.loggedUser = user;
	}
	
	public void logout() 
	{
		this.loggedUser = null;
	}
	
}	