package model;
import java.util.*;

public class GiocatoreIA extends Giocatore
{
	private String nickname;
	
	public GiocatoreIA(String nickname) {
		this.nickname = nickname;
		// TODO Auto-generated constructor stub
	}
	
	public Carta selezionaCartaRandom(Passata p) 
	{
	
		Random rand = new Random();
		
		Giocatore giocIniziale = p.getGiocatoreIniziale();
		Carta iniz = p.getCartaGiocata(giocIniziale);
		
		List<Carta> carteStessoSeme = 
				super.getCarte()
						.stream()
						.filter(c -> c.getSeme() == iniz.getSeme())
						.toList();
		
		List<Carta> selezionabili = (carteStessoSeme.isEmpty()) ? super.getCarte() : carteStessoSeme;
	
		return selezionabili.get(rand.nextInt(selezionabili.size()));
	}
	
	@Override 
	public String getNome()
	{
		return nickname;
	}
}
