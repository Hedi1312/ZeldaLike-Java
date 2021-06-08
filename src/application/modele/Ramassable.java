package src.application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ramassable {

	private IntegerProperty x,y;
	private boolean estLa;
	private String id;
	public static int compteurC=0;
	private Environnement env;
	
	public Ramassable(int x, int y, Environnement env) {
		this.x= new SimpleIntegerProperty(x);
		this.y= new SimpleIntegerProperty(y);
		this.estLa=true;
		this.env=env;
		this.id="C"+compteurC;
		compteurC++;
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
	
	public String getId() {
		return id;
	}
	
	public Environnement getEnv() {
		return env;
	}
	
	public boolean estLa() {
		return estLa;
	}
	
	public void agit() {
		if(env.getHero().getX()/16==this.getX()/16 && env.getHero().getY()/16==this.getY()/16) {
			estLa=false;
		}
	}
	
	public abstract void ramasser();
}
