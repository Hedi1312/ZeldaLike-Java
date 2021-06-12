package src.application.modele;

public class ExtincteurRamassable extends Ramassable{

	public ExtincteurRamassable(int x, int y, Environnement env) {
		super(x, y, env);
		
	}

	@Override
	public void ramasser() {
		getEnv().getHero().getObjets().add(new Extincteur());
	}
	

}
