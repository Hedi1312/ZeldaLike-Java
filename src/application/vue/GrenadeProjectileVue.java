package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.Projectile;

public class GrenadeProjectileVue {
	private Projectile grenadeProjectile;
	private Image img;
	private ImageView iv ;
	private Pane pane;
	
	public GrenadeProjectileVue(Projectile grenadeProjectile, Pane pane) {
		super();
		this.img = new Image("src/images/grenade.png");
		this.iv= new ImageView(img);
		this.grenadeProjectile=grenadeProjectile;
		this.pane = pane;
		
		pane.getChildren().add(this.iv);

		iv.setId(grenadeProjectile.getId());
		this.iv.translateXProperty().bind(grenadeProjectile.getXProperty());
		this.iv.translateYProperty().bind(grenadeProjectile.getYProperty());
	}
	
}
