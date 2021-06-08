package src.application.modele;

public class Bandage extends Ramassable{
	
	public Bandage(int x, int y, Environnement env) {
		super(x, y, env);
	}

	@Override
	public void ramasser() {
		getEnv().getHero().setPv(getEnv().getHero().getPv()+20);
		
	}
	
	
}
