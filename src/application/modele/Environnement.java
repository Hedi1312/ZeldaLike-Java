package src.application.modele;

import javafx.beans.value.ObservableSetValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import src.application.vue.HeroVue;

public class Environnement {
	private Hero hero;

	private ObservableList<Ennemi> ennemis;
	private ObservableList<Balle> balles;
	private Terrain terrain;
	
	
	public Environnement() {
//		this.hero=null;

		this.ennemis= FXCollections.observableArrayList();
		this.balles = FXCollections.observableArrayList();
		this.terrain= new Terrain();
	}
	
	public Terrain getTerrain() {
		return terrain;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public void ajouterPerso(Ennemi p) {
		this.ennemis.add(p);
	}
	
	public void ajouterHero(Hero hero) {
		this.hero=hero;
	}
	
	public void ajouterBalle(Balle balle) {
		this.balles.add(balle);
	}
	
	public ObservableList<Ennemi> getPersonnages() {
		return ennemis;
	}
	
	public ObservableList<Balle> getBalles(){
		return balles;
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
	
	public boolean caseVide(int x , int y) {
        for(Ennemi p : ennemis) {
            if((x==p.getX()/16 && y== p.getY()/16) || (x==getHero().getX()/16 && y==getHero().getY()/16)) {
                return false;
            }
        }
        return true;
    }
	
	public Ennemi trouverEnnemi(int x , int y) {
		for(Ennemi p : ennemis) {
			if(x==p.getX()/16 && y== p.getY()/16) {
				return p;
			}
		}
		return null;
	}

	public void unTour() {
		getHero().agit();
				
		for(Ennemi p : ennemis) {
			p.agit();
		}
		
		for(int i=ennemis.size()-1; i>=0;i--){
			Ennemi p = ennemis.get(i);
			if(!p.estVivant()){
				ennemis.remove(i);
			}
		}
		
	}
	
	public void unTourProjectile() {
		for(Balle b : balles) {
			b.attaquer();
		}
		
		for(int i=balles.size()-1; i>=0;i--){
			Balle b = balles.get(i);
			if(b.estLa()){
				balles.remove(i);
			}
		}
	}
}
