package src.application.modele.ramassable;

import src.application.modele.Environnement;

public class Bandage extends Ramassable{
	
	public Bandage(int x, int y, Environnement env) {
		super(x, y, env);
	}

	@Override
	public void ramasser() {
		getEnv().getHero().setPv(getEnv().getHero().getPv()+20);
		
	}
	
	
}
