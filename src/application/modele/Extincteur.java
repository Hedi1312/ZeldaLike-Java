package src.application.modele;

public class Extincteur extends Ramassable{

	public Extincteur(int x, int y, Environnement env) {
		super(x, y, env);
		
	}

	@Override
	public void ramasser() {
		getEnv().getHero().obtenirExtincteur();
		
	}
	

}
