package src.application.modele.arme;

import src.application.modele.Environnement;
import src.application.modele.projectile.GrenadeProjectile;
import src.application.modele.projectile.Projectile;

public class Grenade extends Arme{

	private int quantite= 2;
	
	public Grenade() {
		super(50);
	}

	@Override
	public void attaquer(int x, int y, int dx, int dy, Environnement env) {
		if(quantite>0) {
			
			Projectile g = new GrenadeProjectile(x, y, dx, dy, env, getPtAttaque());
			env.ajouterProjectile(g);
			quantite--;
		}
		else 
			System.out.println("Plus de grenade");
	}

}
