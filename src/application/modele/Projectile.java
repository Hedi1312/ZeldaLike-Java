package src.application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Projectile {
	private IntegerProperty xAttaque, yAttaque;
	private String id;
	public static int compteurB=0;
	public boolean toucher = false;
	private int dx,dy;
	private Environnement env;
	private int ptAttaque;
	
	public Projectile(int x, int y, int dx, int dy, Environnement env, int ptAttaque) {
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
	
	public Environnement getEnv() {
		return env;
	}
	
	public int getPtAttaque() {
		return ptAttaque;
	}
	
	public boolean aDisparu() {
		return toucher;
	}
	
	public abstract void attaquer();

}
