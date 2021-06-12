package src.application.modele;

import java.util.Random;

import javafx.beans.value.ObservableSetValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import src.application.vue.HeroVue;

public class Environnement {
	private Hero hero;

	private ObservableList<Ennemi> ennemis;
	private ObservableList<Projectile> projectiles;
	private ObservableList<Ramassable> ramassables;
	private Terrain terrain;
	
	
	public Environnement() {
		this.ennemis= FXCollections.observableArrayList();
		this.projectiles = FXCollections.observableArrayList();
		this.ramassables = FXCollections.observableArrayList();
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
	
	public void ajouterProjectile(Projectile projectile) {
		this.projectiles.add(projectile);
	}
	
	public void ajouterRamassable(Ramassable ramassable) {
		this.ramassables.add(ramassable);
	}
	
	public ObservableList<Ennemi> getEnnemis() {
		return ennemis;
	}
	
	public ObservableList<Projectile> getProjectile(){
		return projectiles;
	}
	
	public ObservableList<Ramassable> getRamassables(){
		return ramassables;
	}
	

	public boolean dansTerrain(int x, int y) {
		return (0 <= x && x<terrain.getWidth()*16 && 0<=y && y<terrain.getHeight()*16);
	}
	
	public boolean traversable(int x,int y) {
		int[] tab = {352,007};
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
	
	public boolean casePorte(int x, int y) {
		int[] tab = {007};
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
	

	public static boolean reussitProba(double pourcent){
		double x= Math.random();
		double pp=pourcent/100;
		return (x<=pp);
	}

	public void spawnEnnemi() {
		Random random=new Random();
		int x = random.nextInt(getTerrain().getWidth())*16;
		int y = random.nextInt(getTerrain().getHeight())*16;
		while(!(caseVide(x/16, y/16) && dansTerrain(x, y) && traversable(x, y)) ){
			x = random.nextInt(getTerrain().getWidth())*16;
			y = random.nextInt(getTerrain().getHeight())*16;
		}
		if(reussitProba(60)){
			Ennemi ennemi = new EnnemiBasique(x,y,this);
			ajouterPerso(ennemi);
		}
		else {
			Ennemi ennemiExplosif = new EnnemiExplosif(x,y,this);
			ajouterPerso(ennemiExplosif);
		}
	}

	
	public void unTour() {
		if(reussitProba(20)){
			spawnEnnemi();
		}
		for(int i=ennemis.size()-1; i>=0;i--){
			Ennemi p = ennemis.get(i);
			if(!p.estVivant()){
				if(p.getId().equals("A1")) {
					Ramassable pistolet = new PistoletRamassable(p.getX()+16,p.getY(),this);
					ajouterRamassable(pistolet);
				}
				ennemis.get(i).drop();
				ennemis.remove(i);
			}
		}
		
		for(Ennemi p : ennemis) {
			p.agit();
		}
		
		
	}
	
	public void unTourRapideMaisPasTrop() {
		getHero().agit();
		
		for(Projectile p : projectiles) {
			p.attaquer();
		}
		
		for(int i=projectiles.size()-1; i>=0;i--){
			Projectile p = projectiles.get(i);
			if(p.aDisparu()){
				projectiles.remove(i);
			}
		}
		
	}
	
	public void unTourRapide() {
		
		for(Ramassable r : ramassables) {
			r.agit();
		}
		
		for(int i=ramassables.size()-1; i>=0;i--){
			Ramassable r = ramassables.get(i);
			if(!r.estLa()){
				r.ramasser();
				ramassables.remove(i);
				
				
			}
		}
	}
}
