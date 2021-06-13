package src.application.modele.personnage;

import java.util.Random;

import src.application.modele.Environnement;
import src.application.modele.ramassable.Munition;
import src.application.modele.ramassable.Ramassable;

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
			if(env.dansLeFeu(getX(),getY())) {
				perdrePv(30);
			}
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

		}

	}
	
	public void explosion() {
		if(		(this.getY()-32<= env.getHero().getY() && env.getHero().getY()<=this.getY()+32) &&
				(this.getX()-32<= env.getHero().getX() && env.getHero().getX()<=this.getX()+32)  
			){
			env.getHero().setPv(env.getHero().getPv()-35);
			setPv(0);
		}
		
	}

	@Override
	public void drop() {
		Ramassable munition = new Munition(getX(),getY(),env);
		env.ajouterRamassable(munition);
		
	}
}

