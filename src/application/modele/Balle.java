package src.application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;

public class Balle {

	private IntegerProperty xAttaque, yAttaque;
	private String id;
	public static int compteurB=0;
	public boolean toucher = false;
	private int dx,dy;
	private Environnement env;
	private int ptAttaque;
	
	public Balle(int x, int y, int dx, int dy, Environnement env, int ptAttaque) {
		xAttaque = new SimpleIntegerProperty(x);
		yAttaque = new SimpleIntegerProperty(y);
		this.dx=dx;
		this.dy=dy;
		this.id="B"+compteurB;
		compteurB++;
		this.env=env;
		this.ptAttaque=ptAttaque;
	}
	
	public String getId() {
		return id;
	}
	
	public int getDx() {
		return dx;
	}
	
	public int getDy() {
		return dy;
	}
	
	public final int getXAttaque() {
		return xAttaque.getValue();
	}
	
	public final int getYAttaque() {
		return yAttaque.getValue();
	}
	
	public final void setXAttaque(int n) {
		xAttaque.setValue(n);
	}
	public final void setYAttaque(int n) {
		yAttaque.setValue(n);
	}
	
	public final IntegerProperty getXProperty() {
		return this.xAttaque;
	}
	
	public final IntegerProperty getYProperty() {
		return this.yAttaque;
	}
	
	public boolean estLa() {
		return toucher;
	}
	
	public void attaquer() {

		Personnage p=env.trouverEnnemi(getXAttaque()/16, getYAttaque()/16);
		System.out.println(p);
		if(p!=null) {
			System.out.println("touché");
			p.setPv(p.getPv()-ptAttaque);
			toucher=true;
		}
		else {
			int nposX=getXAttaque()+(dx*16);
			int nposY=getYAttaque()+(dy*16);
			if(!(this.env.dansTerrain(nposX, nposY) && this.env.traversable(nposX, nposY))){
				toucher=true;
			}
			setXAttaque(nposX);
			setYAttaque(nposY);		
			System.out.println("Hero Pas touché");
		}
	}
}

