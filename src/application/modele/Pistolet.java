package src.application.modele;

import java.util.ArrayList;

public class Pistolet extends Arme{
	
	private ArrayList<Balle> chargeur;
	private int range=5 ;
	private int xAttaque , yAttaque;
	
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
		
			//chargeur.get(0).tirer();
			for(int i=0 ; i<range ;i++) {
				xAttaque = x+dx*16*i;
				yAttaque = y+dy*16*i;
				if(!env.traversable(xAttaque,yAttaque))
					break;
				
				Personnage p=env.trouverEnnemi(xAttaque/16, yAttaque/16);
				
				System.out.println("Attaque en " + xAttaque/16 + " : " + yAttaque/16 );
				if(p!=null) {
					p.setPv(p.getPv()-getPtAttaque());
					
				}
			}
			chargeur.remove(0);
		}
		else 
			System.out.println("Plus de munitions");
	}
	
	

}
