package src.application.modele.arme;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import src.application.modele.Environnement;
import src.application.modele.personnage.Personnage;

public class Batte extends Arme{
	
	public Batte() {
		super(10);
		
	}
	

	@Override
	public void attaquer(int x, int y, int dx, int dy, Environnement env) {
		
		int xAttaque = x + (dx*16);
		int yAttaque = y + (dy*16);
		
		
		Personnage p=env.trouverEnnemi(xAttaque/16, yAttaque/16);
		
		if(p!=null) {
			p.setPv(p.getPv()-getPtAttaque());
		}
		
	}


	
}
