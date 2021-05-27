package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.Ennemi;
import src.application.modele.Hero;

public class EnnemiVue {
	private Ennemi ennemi;
	private Image img;
	private ImageView iv ;
	private Pane pane;
	
	public EnnemiVue(Ennemi ennemi, Pane pane) {
		super();
		this.img = new Image("src/images/pixil-frame-0.png");
		this.iv= new ImageView(img);
		this.ennemi=ennemi;
		this.pane = pane;
		
		pane.getChildren().add(this.iv);
		
		this.iv.translateXProperty().bind(ennemi.getXProperty());
		this.iv.translateYProperty().bind(ennemi.getYProperty());
	}
	
	public Ennemi getEnnemi() {
		return this.ennemi;
	}
	
	public ImageView getIV() {
		return iv;
	}
	
	public Image getImg() {
		return img;
	}
	
}
