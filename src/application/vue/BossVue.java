package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.personnage.Ennemi;
import src.application.modele.personnage.Personnage;

public class BossVue {
	private Personnage boss;
	private Image img;
	private ImageView iv ;
	private Pane pane;
	
	public BossVue(Personnage boss, Pane pane) {
		super();
		this.img = new Image("src/images/scientifique.png");
		this.iv= new ImageView(img);
		this.boss=boss;
		this.pane = pane;
		
		pane.getChildren().add(this.iv);

		iv.setId(boss.getId());
		this.iv.translateXProperty().bind(boss.getXProperty());
		this.iv.translateYProperty().bind(boss.getYProperty());
	}
	
	public Personnage getEnnemi() {
		return this.boss;
	}
	
	public ImageView getIV() {
		return iv;
	}
	
	public Image getImg() {
		return img;
	}
	
}
