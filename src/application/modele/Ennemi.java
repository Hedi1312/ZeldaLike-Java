package src.application.modele;

import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Ennemi extends Personnage {
	private int pv;
	private String id;
	private int dx,dy;
	public static int compteur=0;
	
	
	public Ennemi(int x, int y, Environnement env) {
		super(x,y,env);
		this.pv= 30;
		this.tirerDirection();
		this.id="A"+compteur;
		compteur++;
		
	}
	
	public Environnement getEnv() {
		return env;
	}
	
	
	public int getPv() {
		return pv;
	}
	
	
	public void setPv(int n) {
		pv=n;
	}
	

	public String getId() {
		return id;
	}
	
	public int getDy() {
		return this.dx;
	}
	
	public int getDx() {
		return this.dy;
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
	
	public void seDeplace(){
		// 20% de chance de changer de direction
		// if(Math.random()*100< pourentageRepro )
		if(reussitProba(20)) {
			tirerDirection();
		}
		int nposX=getX()+(dx*16);
		int nposY=getY()+(dy*16);
		while(!(this.env.dansTerrain(nposX, nposY) && this.env.traversable(nposX, nposY))){
			tirerDirection();
			nposX=getX()+(dx*16);
			nposY=getY()+(dy*16);
		}
		setX(nposX);;
		setY(nposY);		
	}
	
	public static boolean reussitProba(double pourcent){
		double x= Math.random();
		double pp=pourcent/100;
		return (x<=pp);
	}
	
	@Override
	public void agit() {
		seDeplace();
	}
}
