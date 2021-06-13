package src.application.modele.personnage;

import src.application.modele.Environnement;
import src.application.modele.ramassable.Bandage;
import src.application.modele.ramassable.Ramassable;

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
		if(env.dansLeFeu(getX(),getY())) {
			perdrePv(30);
		}
		attaquer();
	}

	@Override
	public void drop() {
		if(!getId().equals("A1")) {
			Ramassable bandage = new Bandage(getX(),getY(),env);
			env.ajouterRamassable(bandage);
		}
		
	}
}