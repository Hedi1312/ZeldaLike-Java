package src.application.modele;

import src.application.vue.HeroVue;

public class Environnement {
	private Hero hero;
	private Ennemi ennemi;
	private Terrain terrain;
	
	
	public Environnement() {
		this.hero=null;
		this.ennemi=null;
		this.terrain= new Terrain();
	}
	
	public Terrain getTerrain() {
		return terrain;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public void ajouterHero(Hero hero) {
		this.hero=hero;
	}
	
	
	public Ennemi getEnnemi() {
		return ennemi;
	}
	
	public void ajouterEnnemi(Ennemi ennemi) {
		this.ennemi=ennemi;
	}
	
	public boolean dansTerrain(int x, int y) {
		return (0 <= x && x<terrain.getWidth()*16-13 && 0<=y && y<terrain.getHeight()*16-13);
	}
	
	public boolean traversable(int x,int y) {
		int[] tab = {352};
		if(dansTerrain(x, y)) {
			int tuile= terrain.getMap()[y/16][x/16];
			for(int element : tab) {
				if(tuile==element)
					return false;
			}
		}
		return true;
	}
	
//	public String typeTuile(int x,int y) {
//		String nomTuile;
//		int tuile= terrain.getMap()[y][x];
//		
//		switch(tuile) {
//		case 352:
//			nomTuile="mur";
//			break;
//		case 914:
//			nomTuile="feu";
//			break; 	
//		case 505 :
//			nomTuile="sol";
//			break;
//		default:
//			nomTuile="inconnu";
//		}
//		return nomTuile;
//	}

	public boolean dansLeFeu(int x, int y ) {
		int[] tab = {914};
		if(dansTerrain(x, y)) {
			int tuile= terrain.getMap()[y/16][x/16];
			for(int element : tab) {
				if(tuile==element)
					return true;
			}
		}
		
		return false;
	}
	
	public void trouverEnnemi(int x , int y) {
		if(x==ennemi.getX()/16 && y== ennemi.getY()/16) {
			ennemi.setPv(ennemi.getPv()-10);
			System.out.println("Touché");
		}
		else
			System.out.println("Pas touché");
		System.out.println("Ennemi en " + ennemi.getX()/16 + " : "+ ennemi.getY()/16);
		
		System.out.println("Ennemi PV : " + ennemi.getPv());
		
	}
	
	public boolean estVivant() {
		if(ennemi.getPv()<=0) {
			return false;
		}
		return true;
	}

	public void unTour() {
		getHero().agit();
		getEnnemi().agit();
	}
}
