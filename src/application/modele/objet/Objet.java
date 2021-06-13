package src.application.modele.objet;

import src.application.modele.Environnement;

public interface Objet {

	public void interagir(int x, int y, int dx, int dy, Environnement env);
		
}
