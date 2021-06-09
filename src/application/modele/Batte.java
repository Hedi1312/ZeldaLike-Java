package src.application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Batte extends Arme{
	
	public Batte() {
		super(10);
		
	}
	

	@Override
	public void attaquer(int x, int y, int dx, int dy, Environnement env) {
		
		int xAttaque = x + (dx*16);
		int yAttaque = y + (dy*16);
		
		System.out.println("Attaque en " + xAttaque/16 + " : " + yAttaque/16);
		System.out.println("Hero en " + x/16 + " : " + y/16);
		
		Personnage p=env.trouverEnnemi(xAttaque/16, yAttaque/16);
		
		if(p!=null) {
			System.out.println("touché");
			p.setPv(p.getPv()-getPtAttaque());
		}
		
	}


	
}
