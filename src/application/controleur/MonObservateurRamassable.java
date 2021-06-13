package src.application.controleur;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.application.modele.Antidote;
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
		
		this.pane.getChildren().remove(this.pane.lookup("#"+recupere.getId()));
		
	} 

	@Override
	public void onChanged(Change<? extends Ramassable> c) {

		while(c.next()) {
			for(Ramassable nouveau: c.getAddedSubList()){
				
				creerVue(nouveau);
				
			}
			
			for(Ramassable enleve: c.getRemoved()){
				if(enleve instanceof Antidote) {
					Image imgFin = new Image("src/images/gameOver.png",20*16,15*16,true,true);
					ImageView fin = new ImageView(imgFin);
					pane.getChildren().add(fin);
					
				}
				enleverRamassable(enleve);
			}
		}
	}
	
	private void creerVue(Ramassable a) {
		ramassableVue = new RamassableVue(a,pane);
	}
}
