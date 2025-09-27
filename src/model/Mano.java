package model;
import java.util.*;

public class Mano {
	private List<Carta> carte;
	
	public Mano(List<Carta> carte) 
	{	
		this.carte = carte;
	}
	
	public List<Carta> getCarte() {
		return carte;
	}
}
