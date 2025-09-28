package model;

abstract public class Giocatore {
	private String nickname;
	private int elo;
	
	public Giocatore(String nickname, int elo)
	{
		this.nickname = nickname;
		this.elo = elo;
	}
}
