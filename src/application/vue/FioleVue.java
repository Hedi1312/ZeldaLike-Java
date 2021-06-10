package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.Projectile;

public class FioleVue {
	private Projectile fiole;
	private Image img;
	private ImageView iv ;
	private Pane pane;
	
	public FioleVue(Projectile fiole, Pane pane) {
		super();
		this.img = new Image("src/images/fiole.png");
		
		this.iv= new ImageView(img);
		this.fiole=fiole;
		this.pane = pane;
		
		pane.getChildren().add(this.iv);

		iv.setId(fiole.getId());
		this.iv.translateXProperty().bind(fiole.getXProperty());
		this.iv.translateYProperty().bind(fiole.getYProperty());
	}
	
}
