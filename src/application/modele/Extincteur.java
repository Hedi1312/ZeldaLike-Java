package src.application.modele;

public class Extincteur implements Objet {

	public Extincteur() {
		
	}
	@Override
	public void interagir(int x, int y, int dx, int dy, Environnement env) {
		System.out.println("J'utilise l'extincteur");
		int xCase = x + (dx*16);
		int yCase = y + (dy*16);
		env.getTerrain().setMap(xCase/16, yCase/16, 505);
	}

}
