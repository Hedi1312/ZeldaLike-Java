package src.application.modele;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Pistolet extends Arme{
	
	
	public Pistolet() {
		super(50);

	}
	
	
	@Override
	public void attaquer(int x, int y, int dx, int dy, Environnement env) {
		

		
		if(env.getHero().getMunitions()>0) {
			
			Balle b = new Balle( x,  y,  dx,  dy, env, getPtAttaque());
			env.ajouterBalle(b);
			env.getHero().setMunitions(env.getHero().getMunitions()-1);
		}
		else 
			System.out.println("Plus de munitions");
		
		
	}
	
	

}
