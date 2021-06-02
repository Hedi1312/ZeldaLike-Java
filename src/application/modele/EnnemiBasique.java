package src.application.modele;

public class EnnemiBasique extends Ennemi {

	public EnnemiBasique(int x, int y, Environnement env) {
		super(x,y,env,30);
	}
	
	public void attaquer() {
		int xAttaque , yAttaque;
		xAttaque = getX() + (getDx()*16);
		yAttaque = getY() + (getDy()*16);

		if(xAttaque/16==env.getHero().getX()/16 && yAttaque/16== env.getHero().getY()/16) {
			env.getHero().setPv(env.getHero().getPv()-10);
			System.out.println("Touché");
			System.out.println("Hero touché " + env.getHero().getPv() + " hp");
		}
		else
			System.out.println("Hero Pas touché");

	}

	@Override
	public void agit() {
		seDeplace();
		attaquer();
	}
}
