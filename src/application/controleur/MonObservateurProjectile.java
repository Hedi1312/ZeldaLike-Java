package src.application.controleur;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.layout.Pane;
import src.application.modele.Balle;
import src.application.modele.Projectile;
import src.application.vue.BalleVue;
import src.application.vue.GrenadeProjectileVue;

public class MonObservateurProjectile implements ListChangeListener<Projectile>{
	private Pane pane;
	private BalleVue balleVue;
	private GrenadeProjectileVue grenadeProjectileVue;

	public MonObservateurProjectile(Pane pane) {
		this.pane=pane;
	}

	private void enleverProjectile(Projectile disparu) {
		System.out.println(disparu.getId());
		this.pane.getChildren().remove(this.pane.lookup("#"+disparu.getId()));
		
	} 

	@Override
	public void onChanged(Change<? extends Projectile> c) {

		while(c.next()) {
			for(Projectile nouveau: c.getAddedSubList()){
				
				System.out.println(nouveau);
				creerVue(nouveau);
				
			}
			
			for(Projectile disparu: c.getRemoved()){
				enleverProjectile(disparu);
			}
		}
	}
	
	private void creerVue(Projectile p) {
		//System.out.println("ajouter sprite");
		
		if( p instanceof Balle){
			balleVue = new BalleVue(p,pane);
			
		}
		else{
			grenadeProjectileVue = new GrenadeProjectileVue(p,pane);
		}
	}

}
