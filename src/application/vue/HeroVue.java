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
		this.img = new Image("src/images/Sans titre.png");
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
		int nposY=hero.getY()-5;
		if(hero.getEnv().dansTerrain(hero.getX(),nposY)){
			this.iv.setLayoutY(iv.getLayoutY()-5);
		}
		//iv.relocate(iv.getLayoutX(), iv.getLayoutY()-5);
	}
	
	public void allerEnBas() {
		int nposY=hero.getY()+5;
		if(hero.getEnv().dansTerrain(hero.getX(),nposY)){
			this.iv.setLayoutY(iv.getLayoutY()+5);
		}
		//iv.relocate(iv.getLayoutX(), iv.getLayoutY()+5);
	}
	public void allerAGauche() {
		int nposX=hero.getX()-5;
		if(hero.getEnv().dansTerrain(nposX,hero.getY())){
			this.iv.setLayoutX(iv.getLayoutX()-5);
		}
		//iv.relocate(iv.getLayoutX()-5, iv.getLayoutY());
	}
	
	public void allerADroite() {
		int nposX=hero.getX()+5;
		if(hero.getEnv().dansTerrain(nposX,hero.getY())){
			this.iv.setLayoutX(iv.getLayoutX()+5);
		}
		//iv.relocate(iv.getLayoutX()+5, iv.getLayoutY());
	}
}
