package model;

public class GiocatoreUmano extends Giocatore
{
	private Profilo profilo;
	
	public GiocatoreUmano(Profilo profilo) {
		this.profilo = profilo;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getNome()
	{
		return profilo.getNickname();
	}

}
