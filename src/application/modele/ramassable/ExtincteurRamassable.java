package src.application.modele.ramassable;

import src.application.modele.Environnement;
import src.application.modele.objet.Extincteur;

public class ExtincteurRamassable extends Ramassable{

	public ExtincteurRamassable(int x, int y, Environnement env) {
		super(x, y, env);
		
	}

	@Override
	public void ramasser() {
		getEnv().getHero().getObjets().add(new Extincteur());
	}
	

}
