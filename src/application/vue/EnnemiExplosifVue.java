package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.personnage.Ennemi;
import src.application.modele.personnage.Personnage;

public class EnnemiExplosifVue {
	private Personnage ennemi;
	private Image img;
	private ImageView iv ;
	private Pane pane;
	
	public EnnemiExplosifVue(Ennemi ennemi, Pane pane) {
		super();
		this.img = new Image("src/images/zombieExplosif.png");
		this.iv= new ImageView(img);
		this.ennemi=ennemi;
		this.pane = pane;
		
		pane.getChildren().add(this.iv);
		
		iv.setId(ennemi.getId());
		this.iv.translateXProperty().bind(ennemi.getXProperty());
		this.iv.translateYProperty().bind(ennemi.getYProperty());
	}
	
	public Personnage getEnnemi() {
		return this.ennemi;
	}
	
	public ImageView getIV() {
		return iv;
	}
	
	public Image getImg() {
		return img;
	}
	
}
