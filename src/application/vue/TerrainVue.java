package src.application.vue;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import src.application.modele.Terrain;

public class TerrainVue {
	private Image img;
	private TilePane mapARemplir;
	private Terrain terrain;
	
	public TerrainVue(TilePane tP, Terrain terrain) {
		super();
		this.img = new Image("src/images/tileset.png");
		this.mapARemplir = tP;
		this.terrain=terrain;
		chargerTerrain(0);
		this.terrain.caseChangeeProperty().addListener((obs,old,nouv)->
		setTuileVue(nouv.intValue()/20, nouv.intValue()%20)
	);
	}
	
	public void chargerTerrain(int numeroMap) {
		terrain.setMap(numeroMap);
		int idTuile;
		for(int i = 0; i < terrain.getMapActuelle().length; i++){
			for(int j=0 ; j <terrain.getMapActuelle()[i].length; j++) {
				idTuile = terrain.getMapActuelle()[i][j];
				switch(idTuile) { 
				case 505 :
					ImageView iv = new ImageView(img);
					Rectangle2D tuile = new Rectangle2D(0*16,0*16,16,16);		 		
					iv.setViewport(tuile);
					mapARemplir.getChildren().add(iv);
					break;
					
				case 352 :
					ImageView iv2 = new ImageView(img);
					Rectangle2D tuile2 = new Rectangle2D(1*16,0*16,16,16);		 		
					iv2.setViewport(tuile2);
					mapARemplir.getChildren().add(iv2);
					break;
					
				case 914: 
					ImageView iv3 = new ImageView(img);
					Rectangle2D tuile3 = new Rectangle2D(2*16,0*16,16,16);		 		
					iv3.setViewport(tuile3);
					mapARemplir.getChildren().add(iv3);
					break;
					
				case 007: 
					ImageView iv4 = new ImageView(img);
					Rectangle2D tuile4 = new Rectangle2D(3*16,0*16,16,16);		 		
					iv4.setViewport(tuile4);
					mapARemplir.getChildren().add(iv4);
					break;
				}
			}
		}
	}
	
	public Image getImage() {
		return img;
	}

	public TilePane getMapARemplir() {
		return mapARemplir;
	}
	
	public void getTuileVue(int x , int y) {
		mapARemplir.getChildren().get((y*20+x));
		
	}
	
	public void setTuileVue(int y , int x) {
		ImageView iv = new ImageView(img);
		Rectangle2D tuile = new Rectangle2D(0*16,0*16,16,16);		 		
		iv.setViewport(tuile);
		mapARemplir.getChildren().set(y*20+x, iv);
	}
}

