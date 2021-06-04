package src.application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;

public class Balle {

	private IntegerProperty xAttaque, yAttaque;
	private String id;
	public static int compteurB=0;
	public boolean toucher = false;
	
	
	public Balle() {
		xAttaque = new SimpleIntegerProperty();
		yAttaque = new SimpleIntegerProperty();
		this.id="B"+compteurB;
		compteurB++;
	}
	
	public String getId() {
		return id;
	}
	
	public final int getXAttaque() {
		return xAttaque.getValue();
	}
	
	public final int getYAttaque() {
		return yAttaque.getValue();
	}
	
	public final void setXAttaque(int n) {
		xAttaque.setValue(n);
	}
	public final void setYAttaque(int n) {
		yAttaque.setValue(n);
	}
	
	public final IntegerProperty getXProperty() {
		return this.xAttaque;
	}
	
	public final IntegerProperty getYProperty() {
		return this.yAttaque;
	}
	
	public boolean estLa() {
		return toucher;
	}
	
	public void tirer(int x, int y, int dx, int dy , Environnement env, int range) {
		//mettre if
		
		for(int i=0 ; i<range ;i++) {
			setXAttaque(x+dx*16*i);
			setYAttaque(y+dy*16*i);
			
			
			if(!env.traversable( getXAttaque(),  getYAttaque()))
				break;
			
			Personnage p=env.trouverEnnemi( getXAttaque()/16,  getYAttaque()/16);
			
			System.out.println("Attaque en " + getXAttaque()/16 + " : " +  getYAttaque()/16 );
			if(p!=null) {
				p.setPv(p.getPv()-30);
				
			}
		}
	}
	
}

