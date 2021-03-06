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
	}
	
	public void chargerTerrain() {
		
		int idTuile;
		for(int i = 0; i < terrain.getMap().length; i++){
			for(int j=0 ; j <terrain.getMap()[i].length; j++) {
				idTuile = terrain.getMap()[i][j];
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
}

