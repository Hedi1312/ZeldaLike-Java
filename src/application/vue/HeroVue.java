package src.application.vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.Batte;
import src.application.modele.Hero;

public class HeroVue {
	private Hero hero;
	private Image img;
	private ImageView iv;
	private ProgressBar barreDeVie;
	private Pane pane;

	public HeroVue(Hero hero, Pane pane) {
		super();
		this.pane = pane;
		this.img = new Image("src/images/hero.png");
		this.iv= new ImageView(img);
		this.hero=hero;
		this.barreDeVie=new ProgressBar(1);
		barreDeVie.setLayoutY(-40);
		barreDeVie.setStyle("-fx-accent: red;");
		barreDeVie.progressProperty().bind(hero.getPvProperty().divide(100));
		

		this.hero.getArmes().add(new Batte());
		this.hero.setArmeActuelle(0);
		
		iv.setId(hero.getId());
		pane.getChildren().add(this.iv);
		pane.getChildren().add(getBarreDeVie());

		this.iv.translateXProperty().bind(hero.getXProperty());
		this.iv.translateYProperty().bind(hero.getYProperty());

		this.hero.getDxProperty().addListener((obs,old,nouv)->{
			if(nouv.intValue()==1) {
				setImgDroite();
			}
			else if(nouv.intValue()==-1)
				setImgGauche();
		}
				);

		this.hero.getDyProperty().addListener((obs,old,nouv)->{
			if(nouv.intValue()==1)
				setImgBas();
			else if(nouv.intValue()==-1)
				setImgHaut();
		}
				);
	}


	public ImageView getIV() {
		return iv;
	}

	public Hero getHero() {
		return this.hero;
	}

	public Image getImg() {
		return img;
	}

	public ProgressBar getBarreDeVie() {
		return barreDeVie;
	}

	public void setImgDroite() {
		this.img= new Image("src/images/heroDroite.png");
		this.iv.setImage(img);
	}

	public void setImgGauche() {
		this.img= new Image("src/images/heroGauche.png");
		this.iv.setImage(img);
	}

	public void setImgHaut() {
		this.img= new Image("src/images/heroHaut.png");
		this.iv.setImage(img);
	}
	public void setImgBas() {
		this.img= new Image("src/images/heroBas.png");
		this.iv.setImage(img);
	}

}
