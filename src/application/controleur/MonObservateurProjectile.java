package src.application.controleur;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.layout.Pane;
import src.application.modele.Balle;
import src.application.modele.Fiole;
import src.application.modele.Projectile;
import src.application.vue.BalleVue;
import src.application.vue.FioleVue;
import src.application.vue.GrenadeProjectileVue;

public class MonObservateurProjectile implements ListChangeListener<Projectile>{
	private Pane pane;
	private BalleVue balleVue;
	private GrenadeProjectileVue grenadeProjectileVue;
	private FioleVue fioleVue;

	public MonObservateurProjectile(Pane pane) {
		this.pane=pane;
	}

	private void enleverProjectile(Projectile disparu) {
		
		this.pane.getChildren().remove(this.pane.lookup("#"+disparu.getId()));
		
	} 

	@Override
	public void onChanged(Change<? extends Projectile> c) {

		while(c.next()) {
			for(Projectile nouveau: c.getAddedSubList()){
				
				
				creerVue(nouveau);
				
			}
			
			for(Projectile disparu: c.getRemoved()){
				enleverProjectile(disparu);
			}
		}
	}
	
	private void creerVue(Projectile p) {
		//System.out.println("ajouter sprite");
		if( p instanceof Fiole){
			fioleVue = new FioleVue(p,pane);
			
		}
		else if( p instanceof Balle){
			balleVue = new BalleVue(p,pane);
			
		}
		else{
			grenadeProjectileVue = new GrenadeProjectileVue(p,pane);
		}
	}

}
