package src.application.controleur;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.layout.Pane;
import src.application.modele.Ennemi;
import src.application.modele.Ramassable;
import src.application.vue.EnnemiExplosifVue;
import src.application.vue.RamassableVue;

public class MonObservateurRamassable implements ListChangeListener<Ramassable> {
	private Pane pane;
	private RamassableVue ramassableVue;

	public MonObservateurRamassable(Pane pane) {
		this.pane=pane;
	}

	private void enleverRamassable(Ramassable recupere) {
		System.out.println(recupere.getId());
		this.pane.getChildren().remove(this.pane.lookup("#"+recupere.getId()));
		
	} 

	@Override
	public void onChanged(Change<? extends Ramassable> c) {

		while(c.next()) {
			for(Ramassable nouveau: c.getAddedSubList()){
				
				System.out.println(nouveau);
				creerVue(nouveau);
				
			}
			
			for(Ramassable enleve: c.getRemoved()){
				enleverRamassable(enleve);
			}
		}
	}
	
	private void creerVue(Ramassable a) {
		ramassableVue = new RamassableVue(a,pane);
	}
}
