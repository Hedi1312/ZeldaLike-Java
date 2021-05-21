package src.application.vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.application.modele.Hero;

public class HeroVue {
	private Hero hero;
	private Image img;
	private ImageView iv;
	private ProgressBar barreDeVie;
	
	public HeroVue(Hero hero) {
		super();
		this.img = new Image("src/images/moi16x16.png");
		this.iv= new ImageView(img);
		this.hero=hero;
		this.barreDeVie=new ProgressBar(1);
		barreDeVie.setLayoutY(-40);
		barreDeVie.setStyle("-fx-accent: red;");
		barreDeVie.progressProperty().bind(hero.getPvProperty());
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
	
	public void allerEnHaut() {
		int nposY=hero.getY()-8;
		
		hero.setDx(0);
		hero.setDy(-1);
		
		if(hero.getEnv().dansTerrain(hero.getX(),nposY) && hero.getEnv().traversable(hero.getX(), nposY)){
			hero.setY(nposY);
		}
	}
	
	public void allerEnBas() {
		int nposY=hero.getY()+8;
		
		hero.setDx(0);
		hero.setDy(1);
		
		if(hero.getEnv().dansTerrain(hero.getX(),nposY) && hero.getEnv().traversable(hero.getX(), nposY)){
			hero.setY(nposY);
		}
	}
	public void allerAGauche() {
		int nposX=hero.getX()-8;
		
		hero.setDx(-1);
		hero.setDy(0);
		
		if(hero.getEnv().dansTerrain(nposX,hero.getY()) && hero.getEnv().traversable(nposX, hero.getY())){
			hero.setX(nposX);
		}
	}
	
	public void allerADroite() {
		int nposX=hero.getX()+8;
		
		hero.setDx(1);
		hero.setDy(0);
		
		if(hero.getEnv().dansTerrain(nposX,hero.getY()) && hero.getEnv().traversable(nposX, hero.getY())){
			hero.setX(nposX);
		}
	}
	
	
	public void attaquer() {
		int xAttaque , yAttaque;
		xAttaque = hero.getX() + (hero.getDx()*16);
		yAttaque = hero.getY() + (hero.getDy()*16);
				
		System.out.println("Attaque en " + xAttaque/16 + " : " + yAttaque/16);
		System.out.println("Hero en " + hero.getX()/16 + " : " + hero.getY()/16);
	}
	
}
