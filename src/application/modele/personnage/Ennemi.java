package src.application.modele.personnage;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.Environnement;

public abstract class Ennemi extends Personnage {
	
	private int dx,dy;
	
	
	public Ennemi(int x, int y, Environnement env, int pv) {
		super(x,y,env,pv,0);
		this.tirerDirection();
	}
	
	public Environnement getEnv() {
		return env;
	}
	
	public int getDy() {
		return this.dx;
	}
	
	public int getDx() {
		return this.dy;
	}
	
	public void setDx(int n) {
		this.dx=n;
	}
	
	public void setDy(int n) {
		this.dy=n;
	}
	
	public void tirerDirection(){
		Random random=new Random();
		int randomInt = random.nextInt(3);
		dx=randomInt-1;
		if(dx==0){
			randomInt=random.nextInt(2)-1;
			if(randomInt==0){
				dy=-1;
			}
			else{
				dy=1;
			}
		}
		else{
			dy=random.nextInt(3)-1;
		}
	}
	
	public void seDeplaceAleatoire(){
		// 20% de chance de changer de direction
		// if(Math.random()*100< pourentageRepro )
		if(reussitProba(20)) {
			tirerDirection();
		}
		int nposX=getX()+(dx*16);
		int nposY=getY()+(dy*16);
		while(!(env.caseVide(nposX/16, nposY/16) && this.env.dansTerrain(nposX, nposY) && this.env.traversable(nposX, nposY)) ){
			tirerDirection();
			nposX=getX()+(dx*16);
			nposY=getY()+(dy*16);
		}
		setX(nposX);;
		setY(nposY);		
	}
		
	public void seDeplace() {
		int nposXGauche=getX()+(-1*16);
		int nposXDroite=getX()+(1*16);    
		int nposYHaut=getY()+(-1*16);
		int nposYBas=getY()+(1*16);

		double caseGauche=0,caseDroite=0,caseHaut=0,caseBas=0,caseCentre=0;
		ArrayList<Double> listeCase = new ArrayList<>(); 

		caseCentre=calculeDistance(env.getHero().getX(), env.getHero().getY(), getX(), getY());
		listeCase.add(caseCentre);


		if(env.traversable(getX()-16, getY()) && env.caseVide(getX()/16-1, getY()/16) && env.dansTerrain(getX()-16, getY()) ){
			caseGauche=calculeDistance(env.getHero().getX(), env.getHero().getY(), nposXGauche, getY());
			listeCase.add(caseGauche);

		}
		if(env.traversable(getX()+16, getY()) && env.caseVide(getX()/16+1, getY()/16) && env.dansTerrain(getX()+16, getY())){
			caseDroite=calculeDistance(env.getHero().getX(), env.getHero().getY(), nposXDroite, getY());
			listeCase.add(caseDroite);
		}
		if(env.traversable(getX(), getY()-16) && env.caseVide(getX()/16, getY()/16-1)  && env.dansTerrain(getX(), getY()-16)){
			caseHaut=calculeDistance(env.getHero().getX(), env.getHero().getY(), getX(), nposYHaut);
			listeCase.add(caseHaut);
		}
		if(env.traversable(getX(), getY()+16) && env.caseVide(getX()/16, getY()/16+1)  && env.dansTerrain(getX(), getY()+16) ){
			caseBas=calculeDistance(env.getHero().getX(), env.getHero().getY(), getX(), nposYBas);
			listeCase.add(caseBas);
		}

		Collections.sort(listeCase);
		if(listeCase.get(0)<10*16) {
			if(listeCase.get(0)==caseCentre ) {
	
				setDx((env.getHero().getX()-getX())/16);
				setDy((env.getHero().getY()-getY())/16);
				System.out.println(this.dx + " : " + this.dy);
				
	
			}
	
			else if(listeCase.get(0)==caseGauche) {
	
				setX(nposXGauche);
				setY(getY());
				setDx(-1);
				setDy(0);
			}
			else if(listeCase.get(0)==caseDroite) {
				setX(nposXDroite);
				setY(getY());
				setDx(1);
				setDy(0);
			}
			else if(listeCase.get(0)==caseHaut) {
				setX(getX());
				setY(nposYHaut);
				setDx(0);
				setDy(-1);
			}
			else {
				setX(getX());
				setY(nposYBas);
				setDx(0);
				setDy(1);
			}
		}
		else
			seDeplaceAleatoire();


	}

	public double calculeDistance(int xHero , int yHero , int xEnnemi, int yEnnemi) {

		return Math.sqrt(Math.pow((xHero-xEnnemi),2)+Math.pow((yHero-yEnnemi),2));
	}

	public static boolean reussitProba(double pourcent){
		double x= Math.random();
		double pp=pourcent/100;
		return (x<=pp);
	}
	
	@Override
	public abstract void agit();

	
	public abstract void attaquer();
	
	public abstract void drop();
		
}
