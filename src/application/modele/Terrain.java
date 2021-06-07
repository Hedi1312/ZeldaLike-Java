package src.application.modele;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Terrain {
	private int[][] map ={
			{0,7,14,21,28,35,42,49,56},
            {1,8,15,22,29,36,43,50,57},
            {2,9,16,23,30,37,44,51,58},
            {3,10,17,24,64,64,45,52,59},
            {4,11,18,25,32,39,46,53,60},
            {5,12,19,26,33,40,47,54,61},
            {6,13,20,27,34,41,48,55,62},};
	
	private int width;
	private int height;
	
	public Terrain() {
		super();
		this.width = map[0].length;
		this.height = map.length;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
	

	
	public int[][] getMap() {
		return map;
	}
	
}