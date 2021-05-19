package src.application.modele;

public class Environnement {
	private Hero hero;
	private Terrain terrain;
	
	
	public Environnement() {
		this.hero=null;
		this.terrain= new Terrain();
	}
	
	public Terrain getTerrain() {
		return terrain;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public void ajouterHero(Hero hero) {
		this.hero=hero;
	}
	
	public boolean dansTerrain(int x, int y) {
		return (0 <= x && x<terrain.getWidth()*16 && 0<=y && y<terrain.getHeight()*16);
	}
}
