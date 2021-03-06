package src.application.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {

	private IntegerProperty x,y;
	protected Environnement env;
	private DoubleProperty pv;
	private String id;
	public static int compteurA=0;
	private int armure;
	
	public Personnage(int x, int y, Environnement env, int pv, int armure) {
		this.x= new SimpleIntegerProperty(x);
		this.y= new SimpleIntegerProperty(y);
		this.env=env;
		this.pv= new SimpleDoubleProperty(pv);
		this.armure=armure;
		this.id="A"+compteurA;
		compteurA++;
	}
	
	public abstract void agit();
	
	public abstract void attaquer();

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
	
	public DoubleProperty getPvProperty () {
		return pv;
	}
	
	public void setPv(double n) {
		if(getPv()-n>armure) {
			pv.setValue(n+armure);
		}
		if(n>getPv()) {
			if(n>100) {
				n=100;
			}
			pv.setValue(n);
		}
		
		
	}
	
	
	public void setArmure(int n) {
		this.armure = n;
	}
	
	public double getPv() {
		return pv.getValue();
	}
	
	public String getId() {
		return id;
	}
	
	public void perdrePv(double n) {
		pv.setValue(pv.getValue()-n);
	}
	
	public boolean estVivant() {
		return this.pv.getValue()>0;
	}
}
