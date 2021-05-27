package src.application.modele;


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
	
	private DoubleProperty pv;
	private int dx,dy;
	
	public Hero(int x, int y , Environnement env) {
		super(x,y,env);
		this.pv=new SimpleDoubleProperty(100);
		this.dx = 0;
		this.dy = -1;
	}
	
	
	public DoubleProperty getPvProperty () {
		return pv;
	}
	
	public void setPv(double n) {
		pv.setValue(n);
	}
	
	public double getPv() {
		return pv.getValue();
	}
	
	public void perdrePv(double n) {
		pv.setValue(pv.getValue()-n);
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
		
		System.out.println("Hero PV : " + this.pv);
	}


	@Override
	public void agit() {
		if(env.dansLeFeu(getX(),getY())) {
			perdrePv(10);
		}
		
	}
	
}	
	
