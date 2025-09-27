package model;
import java.util.*;

abstract public class Giocatore {
	private String nickname;
	private int elo;
	private Mano mano;
	
	public Giocatore(String nickname, int elo, Mano mano)
	{
		this.nickname = nickname;
		this.elo = elo;
		this.mano = mano;
	}
}
