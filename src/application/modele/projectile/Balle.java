package src.application.modele.projectile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import src.application.modele.Environnement;
import src.application.modele.personnage.Personnage;

public class Balle extends Projectile{
	
	public Balle(int x, int y, int dx, int dy, Environnement env, int ptAttaque) {
		super(x,y,dx,dy,env,ptAttaque);
	}
	
	public void attaquer() {

		Personnage p=getEnv().trouverEnnemi(getXAttaque()/16, getYAttaque()/16);
		
		if(p!=null) {
			p.setPv(p.getPv()-getPtAttaque());
			toucher=true;
		}
		else {
			int nposX=getXAttaque()+(getDx()*16);
			int nposY=getYAttaque()+(getDy()*16);
			if(!(getEnv().dansTerrain(nposX, nposY) && getEnv().traversable(nposX, nposY))){
				toucher=true;
			}
			setXAttaque(nposX);
			setYAttaque(nposY);		
			
		}
	}
}

