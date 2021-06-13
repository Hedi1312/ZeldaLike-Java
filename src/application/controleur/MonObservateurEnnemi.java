package src.application.controleur;

import javafx.collections.ListChangeListener;

import javafx.scene.layout.Pane;
import src.application.modele.personnage.Boss;
import src.application.modele.personnage.BossZombie;
import src.application.modele.personnage.Ennemi;
import src.application.modele.personnage.EnnemiBasique;
import src.application.modele.personnage.EnnemiExplosif;
import src.application.modele.personnage.Personnage;
import src.application.vue.BossVue;
import src.application.vue.BossZombieVue;
import src.application.vue.EnnemiBasiqueVue;
import src.application.vue.EnnemiExplosifVue;

public class MonObservateurEnnemi implements ListChangeListener<Ennemi>{
	private Pane pane;
	private EnnemiBasiqueVue ennemiBasiqueVue;
	private EnnemiExplosifVue ennemiExplosifVue;
	private BossVue bossVue;
	private BossZombieVue bossZombieVue;

	public MonObservateurEnnemi(Pane pane) {
		this.pane=pane;
	}

	private void enleverPerso(Personnage mort) {
		
		this.pane.getChildren().remove(this.pane.lookup("#"+mort.getId()));
		
	} 

	@Override
	public void onChanged(Change<? extends Ennemi> c) {

		while(c.next()) {
			for(Ennemi nouveau: c.getAddedSubList()){
				
				
				creerVue(nouveau);
				
			}
			
			for(Personnage mort: c.getRemoved()){
				enleverPerso(mort);
			}
		}
	}
	
	private void creerVue(Ennemi a) {
		//System.out.println("ajouter sprite");
		if( a instanceof Boss){
			bossVue = new BossVue(a,pane);
			
		}
		else if( a instanceof BossZombie){
			bossZombieVue = new BossZombieVue(a,pane);
			
		}
		else if( a instanceof EnnemiExplosif){
			ennemiExplosifVue = new EnnemiExplosifVue(a,pane);
			
		}
		else{
			ennemiBasiqueVue = new EnnemiBasiqueVue(a,pane);
		}
	}

}
