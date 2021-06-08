package src.application.modele;

public class PistoletRamassable extends Ramassable{

	public PistoletRamassable(int x, int y, Environnement env) {
		super(x, y, env);
	}

	@Override
	public void ramasser() {
		getEnv().getHero().getArmes().add(new Pistolet());
		
	}

}
