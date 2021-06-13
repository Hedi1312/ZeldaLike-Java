package src.application.modele;

import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableSetValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import src.application.modele.personnage.Boss;
import src.application.modele.personnage.Ennemi;
import src.application.modele.personnage.EnnemiBasique;
import src.application.modele.personnage.EnnemiExplosif;
import src.application.modele.personnage.Hero;
import src.application.modele.projectile.Projectile;
import src.application.modele.ramassable.ClefRamassable;
import src.application.modele.ramassable.Gilet;
import src.application.modele.ramassable.GrenadeRamassable;
import src.application.modele.ramassable.PistoletRamassable;
import src.application.modele.ramassable.Ramassable;
import src.application.vue.HeroVue;

public class Environnement {
	private Hero hero;

	private ObservableList<Ennemi> ennemis;
	private ObservableList<Projectile> projectiles;
	private ObservableList<Ramassable> ramassables;
	private Terrain terrain;
	private IntegerProperty tour;
	
	public Environnement() {
		this.ennemis= FXCollections.observableArrayList();
		this.projectiles = FXCollections.observableArrayList();
		this.ramassables = FXCollections.observableArrayList();
		this.tour= new SimpleIntegerProperty();
		this.terrain= new Terrain();
		
		Hero hero = new Hero(29*16,14*16,this);
		ajouterHero(hero);
		
	}
	
	public int getTour() {
		return tour.getValue();
	}
	
	public IntegerProperty getTourProperty() {
		return tour;
	}
	
	public void setTour(int n) {
		this.tour.setValue(n);
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
		int[] tab = {7,34,35,36,37,42,43,44,45,56,55,57,63,64,65,73,74,81,96,97,102,103,104,105,106,107,108,109,110,111,112};
		if(dansTerrain(x, y)) {
			int tuile= terrain.getMapActuelle()[y/16][x/16];
			for(int element : tab) {
				if(tuile==element)
					return true;
			}
		}
		return false;
	}
	


	public boolean dansLeFeu(int x, int y ) {
		int[] tab = {96,97};
		if(dansTerrain(x, y)) {
			int tuile= terrain.getMapActuelle()[y/16][x/16];
			for(int element : tab) {
				if(tuile==element)
					return true;
			}
		}
		
		return false;
	}
	
	public boolean casePorte(int x, int y) {
		int[] tab = {87};
		if(dansTerrain(x, y)) {
			int tuile= terrain.getMapActuelle()[y/16][x/16];
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
	
	public void initialiserMap() {
		if(terrain.getMapActuelle()==terrain.getMap(1)) {
			Ramassable grenade =new GrenadeRamassable(29*16, 16*16, this);
			ajouterRamassable(grenade);
			Ramassable clef = new ClefRamassable(26*16, 3*16, this);
			ajouterRamassable(clef);
			Ramassable gilet= new Gilet(15*16,1*16,this);
			ajouterRamassable(gilet);
		}
		
		if(terrain.getMapActuelle()==terrain.getMap(2)) {
			Ennemi boss = new Boss(14*16,9*16,this);
			ajouterPerso(boss);
		}
		
	}
	
	public void killAll() {

		ennemis.clear();
		projectiles.clear();
		ramassables.clear();
		
	}
	public void unTour() {
		if(reussitProba(20) && terrain.getMapActuelle()!=terrain.getMap(2)){
			spawnEnnemi();
		}
		for(int i=ennemis.size()-1; i>=0;i--){
			Ennemi p = ennemis.get(i);
			if(!p.estVivant()){
				if(p.getId().equals("A1")) {
					Ramassable pistolet = new PistoletRamassable(p.getX(),p.getY(),this);
					ajouterRamassable(pistolet);
				}
				ennemis.get(i).drop();
				ennemis.remove(i);
			}
		}
		
		for(Ennemi p : ennemis) {
			p.agit();
		}
		
		setTour(getTour()+1);
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
