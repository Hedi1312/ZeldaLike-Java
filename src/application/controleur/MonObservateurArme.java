package src.application.controleur;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import src.application.modele.arme.Arme;
import src.application.modele.ramassable.Ramassable;
import src.application.vue.ArmeVue;
import src.application.vue.RamassableVue;

public class MonObservateurArme implements ListChangeListener<Arme>{
	private TilePane listeArme;
	private RamassableVue ramassableVue;
	private ArmeVue armeVue;

	public MonObservateurArme(TilePane listeArme) {
		this.listeArme=listeArme;
	}

	@Override
	public void onChanged(Change<? extends Arme> c) {

		while(c.next()) {
			for(Arme nouveau: c.getAddedSubList()){
				
				creerVue(nouveau);
				
			}
		}
	}
	
	private void creerVue(Arme a) {
		armeVue = new ArmeVue(a,listeArme);
	}
}
