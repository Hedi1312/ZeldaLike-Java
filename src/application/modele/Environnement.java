package src.application.modele;

public class Environnement {
	private Hero hero;
	
	public Environnement() {
		this.hero=null;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public void ajouterHero(Hero hero) {
		this.hero=hero;
	}
}
