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
		
		this.hero.getDxProperty().addListener((obs,old,nouv)->{
			if(nouv.intValue()==1)
				setImgDroite();
			else
				setImgGauche();
		}
			);
		
		this.hero.getDyProperty().addListener((obs,old,nouv)->{
			if(nouv.intValue()==1)
				setImgBas();
			else
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
	
	public void setImgDroite() {
		this.img= new Image("src/images/boss.png");
		this.iv= new ImageView(img);
	}
	
	public void setImgGauche() {
		this.img= new Image("src/images/Sans titre.png");
		this.iv= new ImageView(img);
	}
	
	public void setImgHaut() {
		this.img= new Image("src/images/clef.png");
		this.iv= new ImageView(img);
	}
	public void setImgBas() {
		this.img= new Image("src/images/vertical.png");
		this.iv= new ImageView(img);
	}
	
	public ProgressBar getBarreDeVie() {
		return barreDeVie;
	}
	
	
}
