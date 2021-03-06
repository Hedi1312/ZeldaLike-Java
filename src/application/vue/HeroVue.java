package src.application.vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
		this.img = new Image("src/images/moi16x16.png");
		this.iv= new ImageView(img);
		this.hero=hero;
		this.barreDeVie=new ProgressBar(1);
		barreDeVie.setLayoutY(-40);
		barreDeVie.setStyle("-fx-accent: red;");
		barreDeVie.progressProperty().bind(hero.getPvProperty().divide(100));
		
		pane.getChildren().add(this.iv);
		pane.getChildren().add(getBarreDeVie());
	
		this.iv.translateXProperty().bind(hero.getXProperty());
		this.iv.translateYProperty().bind(hero.getYProperty());
		
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
	
	
}
