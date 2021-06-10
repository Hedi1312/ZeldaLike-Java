package src.application.modele;

public class BossZombie extends Ennemi{

	public BossZombie(int x, int y, Environnement env) {
		super(x, y, env, 200);
	}

	@Override
	public void agit() {
		seDeplace();
		attaquer();
	}

	@Override
	public void attaquer() {
		int xAttaque , yAttaque;
		xAttaque = getX() + (getDy()*16);
		yAttaque = getY() + (getDx()*16);


		if(xAttaque/16==env.getHero().getX()/16 && yAttaque/16== env.getHero().getY()/16) {
			env.getHero().setPv(env.getHero().getPv()-35);

		}
	}

	@Override
	public void drop() {
		
	}

}
