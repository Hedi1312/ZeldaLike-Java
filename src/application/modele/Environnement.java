package src.application.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import src.application.vue.HeroVue;

public class Environnement {
	private Hero hero;

	private ObservableList<Personnage> personnages;
	private Terrain terrain;
	
	
	public Environnement() {
//		this.hero=null;

		this.personnages= FXCollections.observableArrayList();
		this.terrain= new Terrain();
	}
	
	public Terrain getTerrain() {
		return terrain;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public void ajouterPerso(Personnage p) {
		this.personnages.add(p);
	}
	
	public void ajouterHero(Hero hero) {
		this.hero=hero;
	}
	
	public ObservableList<Personnage> getPersonnages() {
		return personnages;
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
		for(Personnage p : personnages) {
			if(x==p.getX()/16 && y== p.getY()/16) {
				p.setPv(p.getPv()-hero.getArmeActuelle().getPtAttaque());
				System.out.println("Touché");
				System.out.println("Personnage touché " + p.getPv() + " hp");
			}
			else
				System.out.println("Pas touché");
//			System.out.println("Ennemi en " + ennemi.getX()/16 + " : "+ ennemi.getY()/16);
//		
//			System.out.println("Ennemi PV : " + ennemi.getPv());
		}
	}
	
	public void trouverHero(int x , int y) {
		if(x==hero.getX()/16 && y== hero.getY()/16) {
			hero.setPv(hero.getPv()-10);
			System.out.println("Touché");
			System.out.println("Hero touché " + hero.getPv() + " hp");
		}
		else
			System.out.println("Hero Pas touché");
		//			System.out.println("Ennemi en " + ennemi.getX()/16 + " : "+ ennemi.getY()/16);
		//		
		//			System.out.println("Ennemi PV : " + ennemi.getPv());
	}


	public void unTour() {
		getHero().agit();
		
		for(Personnage p : personnages) {
			p.agit();
		}
		
		for(int i=personnages.size()-1; i>=0;i--){
			Personnage p = personnages.get(i);
			if(!p.estVivant()){
				personnages.remove(i);
			}
		}
	}
}
