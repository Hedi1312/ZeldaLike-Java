package src.application.modele;

import java.util.Random;

public class EnnemiExplosif extends Ennemi {

	private boolean explosion;
	
	public EnnemiExplosif(int x, int y, Environnement env) {
		super(x,y,env,50);
		explosion=false;
	}
	
	@Override
	public void agit() {
		if(!explosion) {
			seDeplace();
			attaquer();
		}
		else {
			explosion();
		}
	}
	
	public void attaquer() {
		int xAttaque , yAttaque;
		xAttaque = getX() + (getDy()*16);
		yAttaque = getY() + (getDx()*16);
		
		if(xAttaque/16==env.getHero().getX()/16 && yAttaque/16== env.getHero().getY()/16) {
			explosion=true;
			System.out.println("Touch�");
			System.out.println("Hero touch� " + env.getHero().getPv() + " hp");
		}
		else
			System.out.println("Hero Pas touch�");
	}
	
	public void explosion() {
		if(		(this.getY()-32<= env.getHero().getY() && env.getHero().getY()<=this.getY()+32) &&
				(this.getX()-32<= env.getHero().getX() && env.getHero().getX()<=this.getX()+32)  
			){
			env.getHero().setPv(env.getHero().getPv()-35);
			setPv(0);
			System.out.println("Hero explos� " + env.getHero().getPv() + " hp");
		}
		else
			System.out.println("Explosion esquiv�");
	}
}

