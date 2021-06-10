package src.application.modele;

public class Clef implements Objet {

	public Clef() {
		
	}
	
	@Override
	public void interagir(int x, int y, int dx, int dy, Environnement env) {
		System.out.println("J'utilise la clef");
		
	}

}
