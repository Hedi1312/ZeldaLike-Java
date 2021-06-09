package src.application.modele;

public class EnnemiBasique extends Ennemi {

	public EnnemiBasique(int x, int y, Environnement env) {
		super(x,y,env,30);
	}
	
	public void attaquer() {
		int xAttaque , yAttaque;
		xAttaque = getX() + (getDy()*16);
		yAttaque = getY() + (getDx()*16);


		if(xAttaque/16==env.getHero().getX()/16 && yAttaque/16== env.getHero().getY()/16) {
			env.getHero().setPv(env.getHero().getPv()-10);

		}
			

	}

	@Override
	public void agit() {
		seDeplace();
		attaquer();
	}

	@Override
	public void drop() {
		Ramassable bandage = new Bandage(getX(),getY(),env);
		env.ajouterRamassable(bandage);
		
	}
}
