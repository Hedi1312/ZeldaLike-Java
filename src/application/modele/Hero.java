package src.application.modele;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class Hero {
	
	private int x,y;
	protected Environnement env;
	
	public Hero(Environnement env) {
		this.x=0;
		this.y=0;
		this.env=env;
	}
	
	public Environnement getEnv() {
		return env;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	
	
//	public void spawnHero() {
// 		mapARemplir.getChildren().add(iv);
//	}
	
}	
	
