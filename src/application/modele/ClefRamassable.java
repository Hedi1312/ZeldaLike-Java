package src.application.modele;

public class ClefRamassable extends Ramassable{

	public ClefRamassable(int x, int y, Environnement env) {
		super(x, y, env);
		
	}

	@Override
	public void ramasser() {
		getEnv().getHero().getObjets().add(new Clef());
	}

}
