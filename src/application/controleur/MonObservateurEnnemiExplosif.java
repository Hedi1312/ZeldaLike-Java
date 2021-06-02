package src.application.controleur;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.layout.Pane;
import src.application.modele.Personnage;
import src.application.vue.EnnemiExplosifVue;

public class MonObservateurEnnemiExplosif implements ListChangeListener<Personnage>{
	private Pane pane;
	private EnnemiExplosifVue ennemiExplosifVue;

	public MonObservateurEnnemiExplosif(Pane pane, EnnemiExplosifVue ennemiExplosifVue) {
		this.pane=pane;
		this.ennemiExplosifVue=ennemiExplosifVue;
	}

	private void enleverPerso(Personnage mort) {
		//System.out.println("enlever sprite");
		this.pane.getChildren().remove(ennemiExplosifVue.getIV());
		System.out.println(mort.getId());
		this.pane.getChildren().remove(this.pane.lookup("#"+mort.getId()));

	} 

	@Override
	public void onChanged(Change<? extends Personnage> c) {

		while(c.next()) {
			for(Personnage mort: c.getRemoved()){
				enleverPerso(mort);
			}
		}
	}


}
