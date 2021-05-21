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

public class Hero {
	
	private IntegerProperty x,y;
	protected Environnement env;
	private DoubleProperty pv;
	private int dx,dy;
	
	public Hero(Environnement env) {
		this.x= new SimpleIntegerProperty();
		this.y= new SimpleIntegerProperty();
		this.env=env;
		this.pv=new SimpleDoubleProperty(100);
		this.dx = 0;
		this.dy = -1;
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
	
	public DoubleProperty getPvProperty () {
		return pv;
	}
	
	public void setPv(double n) {
		pv.setValue(n/100);
	}
	
	public double getPv() {
		return pv.getValue();
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
	
	
	
}	
	
