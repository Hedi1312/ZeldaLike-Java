package src.application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Extincteur implements Objet {
	
	private IntegerProperty xCase,yCase;
	
	
	public Extincteur() {
		this.xCase= new SimpleIntegerProperty();
		this.yCase= new SimpleIntegerProperty();
		
	}
	
	
	@Override
	public void interagir(int x, int y, int dx, int dy, Environnement env) {
		System.out.println("J'utilise l'extincteur");
		xCase.setValue(x + (dx*16));
		yCase.setValue( y + (dy*16));
		if(env.dansLeFeu(xCase.getValue(), yCase.getValue()))
			env.getTerrain().setMap(xCase.getValue()/16, yCase.getValue()/16, 505);
		//terrainVue.setTuileVue(4, 12);

	}

}
