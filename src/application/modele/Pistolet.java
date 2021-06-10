package src.application.modele;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Pistolet extends Arme{
	

	
	public Pistolet() {
		super(10);

	}
	
	@Override
	public void attaquer(int x, int y, int dx, int dy, Environnement env) {
		
		if(env.getHero().getMunitions()>0) {
			Projectile b = new Balle( x,  y,  dx,  dy, env, getPtAttaque());
			env.ajouterProjectile(b);
			env.getHero().setMunitions(env.getHero().getMunitions()-1);
		}
		else 
			System.out.println("Plus de munitions");
	}
	
}
