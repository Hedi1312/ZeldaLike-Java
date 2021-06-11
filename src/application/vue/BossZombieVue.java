package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.Personnage;

public class BossZombieVue {
	private Personnage bossZombie;
	private Image img;
	private ImageView iv ;
	private Pane pane;
	
	public BossZombieVue(Personnage bossZombie, Pane pane) {
		super();
		this.img = new Image("src/images/boss.png");
		this.iv= new ImageView(img);
		this.bossZombie=bossZombie;
		this.pane = pane;
		
		pane.getChildren().add(this.iv);

		iv.setId(bossZombie.getId());
		this.iv.translateXProperty().bind(bossZombie.getXProperty().add(-16));
		this.iv.translateYProperty().bind(bossZombie.getYProperty().add(-16));
	}
	
	public Personnage getEnnemi() {
		return this.bossZombie;
	}
	
	public ImageView getIV() {
		return iv;
	}
	
	public Image getImg() {
		return img;
	}
	
}
