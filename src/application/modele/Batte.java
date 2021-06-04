package src.application.modele;

public class Batte extends Arme{
	private int xAttaque , yAttaque;
	public Batte() {
		super(10);
		
	}

	@Override
	public void attaquer(int x, int y, int dx, int dy, Environnement env) {
		
		xAttaque = x + (dx*16);
		yAttaque = y + (dy*16);
		
		System.out.println("Attaque en " + xAttaque/16 + " : " + yAttaque/16);
		System.out.println("Hero en " + x/16 + " : " + y/16);
		
		Personnage p=env.trouverEnnemi(xAttaque/16, yAttaque/16);
		System.out.println(p);
		if(p!=null) {
			System.out.println("touché");
			p.setPv(p.getPv()-getPtAttaque());
		}
		
	}


	
}
