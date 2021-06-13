package src.application.modele.arme;

import src.application.modele.Environnement;

public abstract class Arme {
	
	private int ptAttaque;
	
	
	public Arme(int a) {
		ptAttaque=a;
	}
	
	public int getPtAttaque() {
		return ptAttaque;
	}
	
	public abstract void attaquer(int x, int y, int dx, int dy, Environnement env);
	
}
