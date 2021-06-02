package src.application.modele;


import java.util.ArrayList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class Hero extends Personnage {
	
	private int dx,dy;
	private ArrayList<Arme> armes;
	private Arme armeActuelle;
	
	public Hero(int x, int y , Environnement env) {
		super(x,y,env,100);
		this.dx = 0;
		this.dy = -1;
		this.armes = new ArrayList<>();
		armes.add(new Batte());
		armeActuelle = armes.get(0);
	}
	
	public Arme getArmeActuelle() {
		return armeActuelle;
	}
	
	public void setArmeActtuelle(int emplacement) {
		armeActuelle = armes.get(emplacement-1);
	}
	
	public int getDx(){
		return dx;
	}
	
	public int getDy() {
		return dy;
	}
	
	public void setDx(int n) {
		this.dx=n;
	}
	
	public void setDy(int n) {
		this.dy=n;
	}
	

	public void allerEnHaut() {
		int nposY=getY()-16;
		
		setDx(0);
		setDy(-1);
		
		if(getEnv().dansTerrain(getX(),nposY) && getEnv().traversable(getX(), nposY)){
			setY(nposY);
		}
	}
	
	public void allerEnBas() {
		int nposY=getY()+16;
		
		setDx(0);
		setDy(1);

		if(this.env.dansTerrain(getX(),nposY) && getEnv().traversable(getX(), nposY)){
			setY(nposY);
		}
	}
	public void allerAGauche() {
		int nposX=getX()-16;
		
		setDx(-1);
		setDy(0);
		
		if(this.env.dansTerrain(nposX,getY()) && getEnv().traversable(nposX, getY())){
			setX(nposX);
		}
	}
	
	public void allerADroite() {
		int nposX=getX()+16;
		
		setDx(1);
		setDy(0);
		
		if(this.env.dansTerrain(nposX,getY()) && getEnv().traversable(nposX, getY())){
			setX(nposX);
		}
	}
	
	
	public void attaquer() {
		int xAttaque , yAttaque;
		xAttaque = getX() + (dx*16);
		yAttaque = getY() + (dy*16);
		
		
		System.out.println("Attaque en " + xAttaque/16 + " : " + yAttaque/16);
		System.out.println("Hero en " + getX()/16 + " : " + getY()/16);
		
		getEnv().trouverEnnemi(xAttaque/16, yAttaque/16);
		
	}


	@Override
	public void agit() {
		if(env.dansLeFeu(getX(),getY())) {
			perdrePv(10);
		}
	}
	
}	
	
