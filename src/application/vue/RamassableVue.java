package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.Bandage;
import src.application.modele.ClefRamassable;
import src.application.modele.ExtincteurRamassable;
import src.application.modele.Gilet;
import src.application.modele.GrenadeRamassable;
import src.application.modele.Munition;
import src.application.modele.PistoletRamassable;
import src.application.modele.Ramassable;

public class RamassableVue {
	
	private Ramassable ramassable;
	private Image img;
	private ImageView iv ;
	private Pane pane;

	public RamassableVue(Ramassable ramassable, Pane pane) {
		super();
		this.ramassable=ramassable;
		if(ramassable instanceof PistoletRamassable) {
			this.img = new Image("src/images/Pisto.png");
		}
		else if(ramassable instanceof Bandage)
			this.img = new Image("src/images/bandage.png");
		else if(ramassable instanceof Munition)
			this.img = new Image("src/images/munition.png");
		else if(ramassable instanceof Gilet)
			this.img = new Image("src/images/gilet.png");
		else if(ramassable instanceof ClefRamassable)
			this.img = new Image("src/images/clef.png");
		else if(ramassable instanceof ExtincteurRamassable)
			this.img = new Image("src/images/extincteur.png");
		else if(ramassable instanceof GrenadeRamassable)
			this.img = new Image("src/images/grenade.png");
		this.iv= new ImageView(img);
		this.pane = pane;
		
		pane.getChildren().add(this.iv);

		iv.setId(ramassable.getId());
		this.iv.translateXProperty().bind(ramassable.getXProperty());
		this.iv.translateYProperty().bind(ramassable.getYProperty());
	}
	
	public Ramassable getRamassable() {
		return this.ramassable;
	}
	
	public ImageView getIV() {
		return iv;
	}
	
	public Image getImg() {
		return img;
	}
}
