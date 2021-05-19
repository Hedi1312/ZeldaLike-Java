package src.application.modele;

public class Environnement {
	private Hero hero;
	private Terrain terrain;
	
	public Environnement(Terrain terrain) {
		this.hero=null;
		this.terrain = terrain;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public Terrain getTerrain() {
		return terrain;
	}
	
	public void ajouterHero(Hero hero) {
		this.hero=hero;
	}
}
