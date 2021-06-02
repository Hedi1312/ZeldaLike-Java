package src.application.modele;

import java.util.Random;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Ennemi extends Personnage {
	
	private String id;
	private int dx,dy;
	
	
	public Ennemi(int x, int y, Environnement env, int pv) {
		super(x,y,env,30);
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
	public abstract void agit();

	
	public abstract void attaquer();
		
}
