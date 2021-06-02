package src.application.controleur;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.layout.Pane;
import src.application.modele.Personnage;
import src.application.vue.EnnemiBasiqueVue;

public class MonObservateurEnnemiBasique implements ListChangeListener<Personnage>{
	private Pane pane;
	private EnnemiBasiqueVue ennemiBasiqueVue;

	public MonObservateurEnnemiBasique(Pane pane, EnnemiBasiqueVue ennemiBasiqueVue) {
		this.pane=pane;
		this.ennemiBasiqueVue=ennemiBasiqueVue;
	}

	private void enleverPerso(Personnage mort) {
		//System.out.println("enlever sprite");
		this.pane.getChildren().remove(ennemiBasiqueVue.getIV());
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
