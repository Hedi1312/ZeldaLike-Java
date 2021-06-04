package src.application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Batte extends Arme{

	//private IntegerProperty xAttaque,yAttaque;
	private int xAttaque;
	private int yAttaque;
	
	public Batte() {
		super(10);
		//this.xAttaque = new SimpleIntegerProperty();
		//this.yAttaque = new SimpleIntegerProperty();
	}
	
//	public int getXAttaque() {
//		return xAttaque.getValue();
//	}
//	
//	public int getYAttaque() {
//		return yAttaque.getValue();
//	}
//	
//	public void setXAttaque(int n) {
//		xAttaque.setValue(n);
//	}
//	public void setYAttaque(int n) {
//		yAttaque.setValue(n);
//	}
//	
//	public IntegerProperty getXAttaqueProperty() {
//		return this.xAttaque;
//	}
//	
//	public IntegerProperty getYAttaqueProperty() {
//		return this.yAttaque;
//	}
	
	@Override
	public void attaquer(int x, int y, int dx, int dy, Environnement env) {
		//setXAttaque(x + (dx*16));
		//setYAttaque(y + (dy*16));
		xAttaque=x+(dx*16);
		yAttaque=y+(dy*16);
		
		System.out.println("Attaque en " + xAttaque/16 + " : " + yAttaque/16);
		System.out.println("Hero en " + x/16 + " : " + y/16);
		
		Personnage p=env.trouverEnnemi(xAttaque/16, yAttaque/16);
		if(p!=null) {
			p.setPv(p.getPv()-getPtAttaque());
		}
		
	}

}
