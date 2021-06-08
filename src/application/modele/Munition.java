package src.application.modele;

public class Munition extends Ramassable{

	public Munition(int x, int y, Environnement env) {
		super(x, y, env);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ramasser() {
		getEnv().getHero().setMunitions(getEnv().getHero().getMunitions()+5); 
		
	}
	
	
}
