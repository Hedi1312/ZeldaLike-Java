package src.application.modele;

public class Clef extends Ramassable{

	public Clef(int x, int y, Environnement env) {
		super(x, y, env);
		
	}

	@Override
	public void ramasser() {
		getEnv().getHero().obtenirClef();
		
	}

}
