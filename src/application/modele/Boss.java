package src.application.modele;

public class Boss extends Ennemi {
	
	private int test;
	
	public Boss(int x, int y, Environnement env) {
		super(x, y, env, 200);
	}

	@Override
	public void agit() {
		attaquer();
	}

	@Override
	public void attaquer() {
		Projectile f = new Fiole(getX(), getY(), -1+test%3, 1, env);
		env.ajouterProjectile(f);
		test++;
	}

	@Override
	public void drop() {
		
	}

}
