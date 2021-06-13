package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import src.application.modele.arme.Arme;
import src.application.modele.arme.Batte;
import src.application.modele.arme.Grenade;
import src.application.modele.arme.Pistolet;
import src.application.modele.ramassable.Bandage;
import src.application.modele.ramassable.ClefRamassable;
import src.application.modele.ramassable.ExtincteurRamassable;
import src.application.modele.ramassable.Gilet;
import src.application.modele.ramassable.GrenadeRamassable;
import src.application.modele.ramassable.Munition;
import src.application.modele.ramassable.PistoletRamassable;
import src.application.modele.ramassable.Ramassable;

public class ArmeVue {
	private Arme arme;
	private Image img;
	private ImageView iv ;
	private TilePane listeArme;

	public ArmeVue(Arme arme, TilePane listeArme) {
		super();
		this.arme=arme;
		if(arme instanceof Pistolet) {
			this.img = new Image("src/images/Pisto.png");
		}
		else if(arme instanceof Batte)
			this.img = new Image("src/images/batte.png");
		else if(arme instanceof Grenade)
			this.img = new Image("src/images/grenade.png");
		
		this.listeArme = listeArme;
		
		this.iv= new ImageView(img);
		
		listeArme.getChildren().add(this.iv);

	}
}
