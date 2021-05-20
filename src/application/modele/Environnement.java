package src.application.modele;

public class Environnement {
	private Hero hero;
	private Ennemi ennemi;
	private Terrain terrain;
	
	
	public Environnement() {
		this.hero=null;
		this.ennemi=null;
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
	
	
	public Ennemi getEnnemi() {
		return ennemi;
	}
	
	public void ajouterEnnemi(Ennemi ennemi) {
		this.ennemi=ennemi;
	}
	
	public boolean dansTerrain(int x, int y) {
		return (0 <= x && x<terrain.getWidth()*16-13 && 0<=y && y<terrain.getHeight()*16-13);
	}
}
