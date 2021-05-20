package src.application.modele;

import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class Ennemi {
	private IntegerProperty x,y;
	private int dx,dy;//direction
	private int pv;
	protected Environnement env;
	private int id;
	public static int compteur=0;
	
	
	public Ennemi(int x, int y, Environnement env) {
		this.pv=5;
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.env=env;
		this.tirerDirection();
		this.id=compteur;
		compteur++;
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
	
	public int getId() {
		return id;
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
}
