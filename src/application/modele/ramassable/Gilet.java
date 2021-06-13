package src.application.modele.ramassable;

import src.application.modele.Environnement;

public class Gilet extends Ramassable{

	public Gilet(int x, int y, Environnement env) {
		super(x, y, env);
	}

	@Override
	public void ramasser() {
		getEnv().getHero().setArmure(10);
	}

}
