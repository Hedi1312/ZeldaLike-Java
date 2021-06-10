package src.application.modele;

public class Fiole extends Projectile {

	private int range;
	private int distanceParcouru;
	
	public Fiole(int x, int y, int dx, int dy, Environnement env) {
		super(x, y, dx, dy, env, 20);
		range=5;
	}

	public void attaquer() {
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
		if(distanceParcouru==range || (nposX==getEnv().getHero().getX() && nposY==getEnv().getHero().getY())) {
			explosion();
			toucher=true;
		}
	}
	
	public void explosion() {
		if(		(getYAttaque()-16<= getEnv().getHero().getY() && getEnv().getHero().getY()<=getYAttaque()+16) &&
				(getXAttaque()-16<= getEnv().getHero().getX() && getEnv().getHero().getX()<=getXAttaque()+16)  
			){
			getEnv().getHero().setPv(getEnv().getHero().getPv()-getPtAttaque());
		}
	}

}
