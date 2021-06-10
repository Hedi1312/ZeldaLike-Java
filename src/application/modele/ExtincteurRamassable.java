package src.application.modele;

public class ExtincteurRamassable extends Ramassable{

	public ExtincteurRamassable(int x, int y, Environnement env) {
		super(x, y, env);
		
	}

	@Override
	public void ramasser() {
		getEnv().getHero().getObjets()[1]=new Extincteur();
		
	}
	

}
