package src.application.modele;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Hero {
	
	private Image img;
	private TilePane mapARemplir;
	private ImageView iv ;
	
	public Hero(TilePane tP) {
		super();
		this.img = new Image("Sans titre.png");
		this.mapARemplir=tP;
		this.iv= new ImageView(img);
	}

	public Image getImg() {
		return img;
	}
	
	public void spawnHero() {
 		mapARemplir.getChildren().add(iv);
	}
	
	public ImageView getIV() {
		return iv;
	}
	
}
