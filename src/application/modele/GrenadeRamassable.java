package src.application.modele;

public class GrenadeRamassable extends Ramassable {

	public GrenadeRamassable(int x, int y, Environnement env) {
		super(x, y, env);
		
	}

	@Override
	public void ramasser() {
		getEnv().getHero().getArmes().add(new Grenade());
	}

}
