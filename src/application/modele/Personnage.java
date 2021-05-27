package src.application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {

	private IntegerProperty x,y;
	protected Environnement env;
	
	public Personnage(int x, int y, Environnement env) {
		this.x= new SimpleIntegerProperty(x);
		this.y= new SimpleIntegerProperty(y);
		this.env=env;
	}
	
	public abstract void agit();

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
}
