package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.projectile.Balle;
import src.application.modele.projectile.Projectile;


public class BalleVue {
	private Projectile balle;
	private Image img;
	private ImageView iv ;
	private Pane pane;
	
	public BalleVue(Projectile balle, Pane pane) {
		super();
		if(balle.getDx()!=0) {
			this.img = new Image("src/images/balleHorizontal.png");
		}
		else
			this.img = new Image("src/images/balleVertical.png");
		
		this.iv= new ImageView(img);
		this.balle=balle;
		this.pane = pane;
		
		pane.getChildren().add(this.iv);

		iv.setId(balle.getId());
		this.iv.translateXProperty().bind(balle.getXProperty());
		this.iv.translateYProperty().bind(balle.getYProperty());
	}
	
}
