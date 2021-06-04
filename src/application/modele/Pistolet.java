package src.application.modele;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Pistolet extends Arme{
	
	private ArrayList<Balle> chargeur;
	private int range=5 ;
	public final static int CAPACITE=4;
	
	
	
	public Pistolet() {
		super(15);
		this.chargeur = new ArrayList<>();
		for(int i =0 ; i<CAPACITE ;i++) {
			this.chargeur.add(new Balle());
		}
	}
	
	
	@Override
	public void attaquer(int x, int y, int dx, int dy, Environnement env) {
		//int xAttaque , yAttaque;

		
		
		//System.out.println(chargeur.size());
		if(chargeur.size()>0 && chargeur.get(0)!=null) {
		
			chargeur.get(0).tirer(x,y,dx,dy, env, this.range);
			env.ajouterBalle(chargeur.get(0));
			chargeur.remove(0);
		}
		else 
			System.out.println("Plus de munitions");
	}
	
	

}
