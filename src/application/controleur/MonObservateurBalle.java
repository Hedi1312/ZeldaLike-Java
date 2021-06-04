package src.application.controleur;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.layout.Pane;
import src.application.modele.Balle;


import src.application.vue.BalleVue;


public class MonObservateurBalle implements ListChangeListener<Balle>{
	private Pane pane;
	private BalleVue balleVue;

	public MonObservateurBalle(Pane pane) {
		this.pane=pane;
	}

	private void enleverBalle(Balle disparu) {
		System.out.println(disparu.getId());
		this.pane.getChildren().remove(this.pane.lookup("#"+disparu.getId()));
		
	} 

	@Override
	public void onChanged(Change<? extends Balle> c) {

		while(c.next()) {
			for(Balle nouveau: c.getAddedSubList()){
				
				System.out.println(nouveau);
				creerVue(nouveau);
				
			}
			
			for(Balle disparu: c.getRemoved()){
				enleverBalle(disparu);
			}
		}
	}
	
	private void creerVue(Balle a) {
		//System.out.println("ajouter sprite");
		
		if( a instanceof Balle){
			balleVue = new BalleVue(a,pane);
			
		}
//		else{
//			ennemiBasiqueVue = new EnnemiBasiqueVue(a,pane);
//		}
	}

}
