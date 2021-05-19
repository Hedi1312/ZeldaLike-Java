package src.application.modele;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Terrain {
	private int[][] map ={{505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,352,352,352,352,352,352,505,505,505,505,505,914,914,914,914,914,914,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505}};
	
	private Image img;
	
	private TilePane mapARemplir;
	private int width;
	private int height;
	
	public Terrain(TilePane tP) {
		super();
		this.img = new Image("src/images/tileset.png");
		this.mapARemplir = tP;
		this.width = map[0].length;
		this.height = map.length;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	//A deplacer dans TerrainVUe
	public void chargerTerrain() {
		for(int i = 0; i < map.length; i++){
			for(int j=0 ; j <map[i].length; j++) {
		     if(map[i][j]==505) {
		    
		    	ImageView iv = new ImageView(img);
		 		Rectangle2D tuile = new Rectangle2D(0*16,0,16,16);		 		
		 		iv.setViewport(tuile);
		 		mapARemplir.getChildren().add(iv);
		     }
		     else if(map[i][j]==352) {
		    	
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
	}
	
//	public boolean dansTerrain(int x, int y){
//        return (0 <= x && x<this.width*16 && 0<=y && y< this.height*16);
//    }
//	
//	public boolean traversable(int tuile) {
//		int[] tab = {505};
//		for(int element : tab) {
//			if(tuile==element)
//				return true;
//		}
//		
//		return false;
//	}
	
	public int[][] getMap() {
		return map;
	}

	public Image getImage() {
		return img;
	}

	public TilePane getMapARemplir() {
		return mapARemplir;
	}
	
}
