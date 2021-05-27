package src.application.modele;

import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Ennemi {
	private int pv;
	private IntegerProperty x,y;
	protected Environnement env;
	private String id;
	private int dx,dy;
	public static int compteur=0;
	
	
	public Ennemi(int x, int y, Environnement env) {
		this.pv= 30;
		this.x= new SimpleIntegerProperty(x);
		this.y= new SimpleIntegerProperty(y);
		this.env=env;
		this.tirerDirection();
		this.id="A"+compteur;
		compteur++;
		
	}
	
	public Environnement getEnv() {
		return env;
	}
	
	public int getX() {
		return x.getValue();
	}
	
	public int getY() {
		return y.getValue();
	}
	
	public void setX(int n) {
		x.setValue(n);
	}
	public void setY(int n) {
		y.setValue(n);
	}
	
	public IntegerProperty getXProperty() {
		return this.x;
	}
	
	public IntegerProperty getYProperty() {
		return this.y;
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
	
	public void agit() {
		
	}
}
