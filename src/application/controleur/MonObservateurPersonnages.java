package src.application.controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import src.application.modele.Personnage;
import src.application.vue.EnnemiVue;

public class MonObservateurPersonnages implements ListChangeListener<Personnage>{

	private Pane pane;
	private EnnemiVue ennemiVue;

	public MonObservateurPersonnages(Pane pane, EnnemiVue ennemiVue) {
		this.pane=pane;
		this.ennemiVue=ennemiVue;
	}

	private void enleverPerso(Personnage mort) {
		//System.out.println("enlever sprite");
		this.pane.getChildren().remove(ennemiVue.getIV());
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
