package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.application.modele.Hero;

public class HeroVue {
	private Hero hero;
	private Image img;
	private ImageView iv ;
	
	public HeroVue(Hero hero) {
		super();
		this.img = new Image("src/images/moi16x16.png");
		this.iv= new ImageView(img);
		this.hero=hero;
	}
	
	public ImageView getIV() {
		return iv;
	}
	
	public Image getImg() {
		return img;
	}
	
	public void allerEnHaut() {
		int nposY=hero.getY()-8;
		if(hero.getEnv().dansTerrain(hero.getX(),nposY)){
			hero.setY(nposY);
		}
	}
	
	public void allerEnBas() {
		int nposY=hero.getY()+8;
		if(hero.getEnv().dansTerrain(hero.getX(),nposY)){
			hero.setY(nposY);
		}
	}
	public void allerAGauche() {
		int nposX=hero.getX()-8;
		if(hero.getEnv().dansTerrain(nposX,hero.getY())){
			hero.setX(nposX);
		}
	}
	
	public void allerADroite() {
		int nposX=hero.getX()+8;
		if(hero.getEnv().dansTerrain(nposX,hero.getY())){
			hero.setX(nposX);
		}
	}
}
