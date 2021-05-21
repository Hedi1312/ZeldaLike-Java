package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.application.modele.Ennemi;

public class EnnemiVue {
	private Ennemi ennemi;
	private Image img;
	private ImageView iv ;
	
	public EnnemiVue(Ennemi ennemi) {
		super();
		this.img = new Image("src/images/moi16x16.png");
		this.iv= new ImageView(img);
		this.ennemi=ennemi;
	}
	
	public ImageView getIV() {
		return iv;
	}
	
	public Image getImg() {
		return img;
	}
	
	public void seDeplace(){
		// 20% de chance de changer de direction
		// if(Math.random()*100< pourentageRepro )
		if(reussitProba(20)) {
			ennemi.tirerDirection();
		}
		int nposX=ennemi.getX()+(ennemi.getDx()*8);
		int nposY=ennemi.getY()+(ennemi.getDy()*8);
		while(!(ennemi.getEnv().dansTerrain(nposX, nposY) && ennemi.getEnv().traversable(nposX, nposY))){
			ennemi.tirerDirection();
			nposX=ennemi.getX()+(ennemi.getDx()*8);
			nposY=ennemi.getY()+(ennemi.getDy()*8);
		}
		ennemi.setX(nposX);;
		ennemi.setY(nposY);		
	}
	
	public static boolean reussitProba(double pourcent){
		double x= Math.random();
		double pp=pourcent/100;
		return (x<=pp);
	}
}
