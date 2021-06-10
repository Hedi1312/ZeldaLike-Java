package src.application.modele;

public class Extincteur implements Objet {

	public Extincteur() {
		
	}
	@Override
	public void interagir(int x, int y, int dx, int dy, Environnement env) {
		System.out.println("J'utilise l'extincteur");
	}

}
