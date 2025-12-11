package model;

import java.io.Serializable;

public class Profilo implements Serializable{
	private String nickname;
	private int elo;
	private int vittorie;
	private int sconfitte;
	private int partiteGiocate;
	static final long serialVersionUID = 1L;
	
	private String avatar;
	
	
	public Profilo(String nickname, String avatar) 
	{
		this.nickname = nickname;
		this.avatar = avatar;
		this.elo = 0;
		this.vittorie = 0;
		this.sconfitte = 0;
		this.partiteGiocate = 0;
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
	
    public String getAvatarName() 
    {
    	return this.avatar;
    }

}
