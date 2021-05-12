package src.application.modele;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class Hero {
	
	private Image img;
	private ImageView iv ;
	
	public Hero() {
		super();
		this.img = new Image("src/images/Sans titre.png");
		this.iv= new ImageView(img);
	}

	public Image getImg() {
		return img;
	}
	
//	public void spawnHero() {
// 		mapARemplir.getChildren().add(iv);
//	}
	
	public ImageView getIV() {
		return iv;
	}
	
	public void allerEnHaut() {
		
		iv.relocate(iv.getLayoutX(), iv.getLayoutY()-5);
	}
	
	public void allerEnBas() {
		iv.relocate(iv.getLayoutX(), iv.getLayoutY()+5);
	}
	public void allerAGauche() {
		iv.relocate(iv.getLayoutX()-5, iv.getLayoutY());
	}
	
	public void allerADroite() {
		iv.relocate(iv.getLayoutX()+5, iv.getLayoutY());
	}
	
	
}	
	
