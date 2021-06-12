package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import src.application.modele.Clef;
import src.application.modele.Extincteur;
import src.application.modele.Objet;

public class ObjetVue {
	private Objet objet;
	private Image img;
	private ImageView iv ;
	private TilePane listeObjet;

	public ObjetVue(Objet objet, TilePane listeObjet) {
		super();
		this.objet=objet;
		if(objet instanceof Extincteur) {
			this.img = new Image("src/images/extincteur.png");
		}
		else if(objet instanceof Clef)
			this.img = new Image("src/images/clef.png");
		
		this.listeObjet = listeObjet;
		
		this.iv= new ImageView(img);
		
		listeObjet.getChildren().add(this.iv);

	}
}
