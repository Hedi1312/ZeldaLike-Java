package src.application.controleur;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.layout.TilePane;
import src.application.modele.Objet;
import src.application.vue.ObjetVue;
import src.application.vue.RamassableVue;

public class MonObservateurObjet implements ListChangeListener<Objet>{
	private TilePane listeObjet;
	private RamassableVue ramassableVue;
	private ObjetVue objetVue;

	public MonObservateurObjet(TilePane listeObjet) {
		this.listeObjet=listeObjet;
	}

	@Override
	public void onChanged(Change<? extends Objet> c) {

		while(c.next()) {
			for(Objet nouveau: c.getAddedSubList()){
				
				creerVue(nouveau);
				
			}
		}
	}
	
	private void creerVue(Objet a) {
		objetVue = new ObjetVue(a,listeObjet);
	}
}
