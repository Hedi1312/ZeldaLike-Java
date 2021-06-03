package src.application.modele;

public class EnnemiBasique extends Ennemi {

	public EnnemiBasique(int x, int y, Environnement env) {
		super(x,y,env,30);
	}
	
	public void attaquer() {
		int xAttaque , yAttaque;
		xAttaque = getX() + (getDy()*16);
		yAttaque = getY() + (getDx()*16);
		System.out.println("Attaque en x=" + xAttaque/16 + " y=" + yAttaque/16 );
		System.out.println("Ennemi en x=" + getX()/16 + " y=" + getY()/16);
		System.out.println("Hero en x=" + env.getHero().getX()/16 + " y=" + env.getHero().getY()/16 );

		if(xAttaque/16==env.getHero().getX()/16 && yAttaque/16== env.getHero().getY()/16) {
			env.getHero().setPv(env.getHero().getPv()-10);
			System.out.println("Touch�");
			System.out.println("Hero touch� " + env.getHero().getPv() + " hp");
		}
		else
			System.out.println("Hero Pas touch�");

	}

	@Override
	public void agit() {
		seDeplace();
		attaquer();
	}
}
