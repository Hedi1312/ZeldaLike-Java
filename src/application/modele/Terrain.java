package src.application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Terrain {
	private int[][] map ={
			{505,505,505,352,505,505,007,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,352,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,352,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {505,505,505,505,505,505,352,505,505,505,505,505,505,505,505,505,505,505,505,505},
            {352,352,352,352,352,352,352,505,505,505,505,505,914,914,914,914,914,914,505,505},
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
	
	private int width;
	private int height;
	private IntegerProperty caseChangée;
	
	public Terrain() {
		super();
		this.width = map[0].length;
		this.height = map.length;
		caseChangée = new SimpleIntegerProperty();
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
	
	public void setMap(int x, int y, int tuile) {
		this.map[y][x]=tuile;
		caseChangée.setValue(y*20+x);
	}
	
	public IntegerProperty caseChangéeProperty() {
		return caseChangée;
	}
}