package src.application.modele.projectile;

import src.application.modele.Environnement;

public class GrenadeProjectile extends Projectile {
	
	private int range;
	private int distanceParcouru;
	
	public GrenadeProjectile(int x, int y, int dx, int dy, Environnement env, int ptAttaque) {
		super(x,y,dx,dy,env,ptAttaque);
		this.range=5;
		this.distanceParcouru=0;
	}
	
	public void attaquer() {
		if(distanceParcouru==range) {
			explosion();
			toucher=true;
		}
		int nposX=getXAttaque()+(getDx()*16);
		int nposY=getYAttaque()+(getDy()*16);
		if((getEnv().dansTerrain(nposX, nposY) && getEnv().traversable(nposX, nposY))){
			setXAttaque(nposX);
			setYAttaque(nposY);
			distanceParcouru++;
		}
		else{
			distanceParcouru=range;
		}
		
	}
	
	public void explosion() {
		for(int i=0;i<getEnv().getEnnemis().size();i++) {
			if(		(getYAttaque()-32<= getEnv().getEnnemis().get(i).getY() && getEnv().getEnnemis().get(i).getY()<=getYAttaque()+32) &&
					(getXAttaque()-32<= getEnv().getEnnemis().get(i).getX() && getEnv().getEnnemis().get(i).getX()<=getXAttaque()+32) 
					
					){
				
				System.out.println(i +" position"+ getEnv().getEnnemis().get(i).getPv() +" PV" + getEnv().getEnnemis().get(i).getX()+" x" + getEnv().getEnnemis().get(i).getY() +" y");
				System.out.println(getXAttaque()+" xAttaque" + getYAttaque() +" yAttaque");
				getEnv().getEnnemis().get(i).setPv(getEnv().getEnnemis().get(i).getPv()-getPtAttaque());
				System.out.println(i +" position"+ getEnv().getEnnemis().get(i).getPv() +" PV" + getEnv().getEnnemis().get(i).getX()+" x" + getEnv().getEnnemis().get(i).getY() +" y");
			}
		}
		
		if(		(getYAttaque()-32<= getEnv().getHero().getY() && getEnv().getHero().getY()<=getYAttaque()+32) &&
				(getXAttaque()-32<= getEnv().getHero().getX() && getEnv().getHero().getX()<=getXAttaque()+32)  
			){
			getEnv().getHero().setPv(getEnv().getHero().getPv()-getPtAttaque());
			
		}
	}
}


