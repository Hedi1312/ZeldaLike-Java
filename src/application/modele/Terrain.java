package src.application.modele;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Terrain {
	private int[] map ={505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,352,352,352,352,352,352,505,505,505,505,505,914,914,914,914,914,914,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,
			505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505}; 
	
	private Image img;
	
	private TilePane mapARemplir;
	
	public Terrain(TilePane tP) {
		super();
		this.img = new Image("tileset.png");
		this.mapARemplir = tP;
	}
	
	public void chargerTerrain() {
		for(int i = 0; i < map.length; i++){
			
		     if(map[i]==505) {
		    
		    	ImageView iv = new ImageView(img);
		 		Rectangle2D tuile = new Rectangle2D(0*16,0,16,16);		 		
		 		iv.setViewport(tuile);
		 		mapARemplir.getChildren().add(iv);
		     }
		     else if(map[i]==352) {
		    	
		    	ImageView iv = new ImageView(img);
		 		Rectangle2D tuile = new Rectangle2D(1*16,0,16,16);		 		
		 		iv.setViewport(tuile);
		 		mapARemplir.getChildren().add(iv);
		     }
		     else{
		    	
		    	ImageView iv = new ImageView(img);
		 		Rectangle2D tuile = new Rectangle2D(2*16,0,16,16);		 		
		 		iv.setViewport(tuile);
		 		mapARemplir.getChildren().add(iv);
		     }
		   }
	}

	public int[] getMap() {
		return map;
	}

	public Image getImage() {
		return img;
	}

	public TilePane getMapARemplir() {
		return mapARemplir;
	}
	
}
