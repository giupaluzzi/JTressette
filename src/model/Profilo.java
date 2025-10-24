package model;

import java.io.Serializable;

public class Profilo implements Serializable{
	private String nickname;
	private int elo;
	private int vittorie;
	private int sconfitte;
	private int partiteGiocate;
	static final long serialVersionUID = 1L;
	
	
	public Profilo(String nick, int elo, int vittorie, int sconfitte) 
	{
		this.nickname = nick;
		this.elo = elo;
		this.vittorie = vittorie;
		this.sconfitte = sconfitte;
		this.partiteGiocate = partiteGiocate;
	}
	
	public String getNickname() 
	{
		return nickname;
	}
	
	public int getPartiteGiocate() 
	{
		return this.partiteGiocate;
	}
	
	public int getElo() 
	{
		return elo;
	}
	
	public int getVittorie()
	{
		return vittorie;
	}
	
	public int getSconfitte() 
	{
		return sconfitte;
	}
	
	public void aggiornaElo(int delta)
	{
		elo+=delta;
	}
	
    public void incrementaVittorie() 
    {
    	vittorie++; 
    }
    
    public void incrementaSconfitte() 
    {
    	sconfitte++;
    }
	

}
