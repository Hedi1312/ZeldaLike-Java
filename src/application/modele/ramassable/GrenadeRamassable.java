package src.application.modele.ramassable;

import src.application.modele.Environnement;
import src.application.modele.arme.Grenade;

public class GrenadeRamassable extends Ramassable {

	public GrenadeRamassable(int x, int y, Environnement env) {
		super(x, y, env);
		
	}

	@Override
	public void ramasser() {
		getEnv().getHero().getArmes().add(new Grenade());
	}

}
