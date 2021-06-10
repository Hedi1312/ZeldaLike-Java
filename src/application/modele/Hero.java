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
	private int munitions=0;
	private Objet[] objets = new Objet[2];
	
	public Hero(int x, int y , Environnement env) {
		super(x,y,env,100, 0);
		this.dx = 0;
		this.dy = -1;
		this.armes = new ArrayList<>();
		armes.add(new Batte());
		armeActuelle = armes.get(0);
		objets[0]= null;
		objets[1]= null;
	}
	
	public Objet[] getObjets() {
		return objets;
	}
	
	public int getMunitions() {
		return munitions;
	}
	
	public void setMunitions(int n) {
		this.munitions=n;
	}
	
	public Arme getArmeActuelle() {
		return armeActuelle;
	}
	
	public void setArmeActuelle(int emplacement) {
		if(emplacement<armes.size()) {
			armeActuelle = armes.get(emplacement);
		}
	}
	
	public ArrayList<Arme> getArmes() {
		return armes;
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
		
		if(getEnv().dansTerrain(getX(),nposY)&& env.caseVide(getX()/16, nposY/16) && getEnv().traversable(getX(), nposY)){
			setY(nposY);
		}
	}
	
	public void allerEnBas() {
		int nposY=getY()+16;
		
		setDx(0);
		setDy(1);

		if(this.env.dansTerrain(getX(),nposY) && env.caseVide(getX()/16, nposY/16) && getEnv().traversable(getX(), nposY)){
			setY(nposY);
		}
	}
	public void allerAGauche() {
		int nposX=getX()-16;
		
		setDx(-1);
		setDy(0);
		
		if(this.env.dansTerrain(nposX,getY())&& env.caseVide(nposX/16, getY()/16) && getEnv().traversable(nposX, getY())){
			setX(nposX);
		}
	}
	
	public void allerADroite() {
		int nposX=getX()+16;
		
		setDx(1);
		setDy(0);
		
		if(this.env.dansTerrain(nposX,getY())&& env.caseVide(nposX/16, getY()/16) && getEnv().traversable(nposX, getY())){
			setX(nposX);
		}
	}
	
	
	public void attaquer() {
		armeActuelle.attaquer(getX(),getY(),dx,dy,env);
	}

	public void interagir() {
		for(int i=0;i<objets.length;i++) {
			if(objets[i]!=null) {
				objets[i].interagir(getX(), getY(), getDx(), getDy(), env);
			}
		}
	}

	@Override
	public void agit() {
		if(env.dansLeFeu(getX(),getY())) {
			perdrePv(30);
		}
	}
	
}	
	
