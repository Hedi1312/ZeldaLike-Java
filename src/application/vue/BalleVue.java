package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.Balle;


public class BalleVue {
	private Balle balle;
	private Image img;
	private ImageView iv ;
	private Pane pane;
	
	public BalleVue(Balle balle, Pane pane) {
		super();
		if(balle.getDx()!=0) {
			this.img = new Image("src/images/horizontal.png");
		}
		else
			this.img = new Image("src/images/vertical.png");
		
		this.iv= new ImageView(img);
		this.balle=balle;
		this.pane = pane;
		
		pane.getChildren().add(this.iv);

		iv.setId(balle.getId());
		this.iv.translateXProperty().bind(balle.getXProperty());
		this.iv.translateYProperty().bind(balle.getYProperty());
	}
	
}
