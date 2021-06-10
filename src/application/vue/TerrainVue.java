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
		this.img = new Image("src/images/TilesetZombie.png");
		this.mapARemplir = tP;
		this.terrain=terrain;
		tP.setPrefSize(576, 448);
	}
	
	public void chargerTerrain() {
		
		int idTuile;
		for(int i = 0; i < terrain.getMap().length; i++){
			for(int j=0 ; j <terrain.getMap()[i].length; j++) {
				idTuile = terrain.getMap()[i][j];
				switch(idTuile) { 
				case 0 :
					ImageView iv0 = new ImageView(img);
					Rectangle2D tuile0 = new Rectangle2D(0*64,0*64,64,64);		 		
					iv0.setViewport(tuile0);
					mapARemplir.getChildren().add(iv0);
					break;
					
				case 1 :
					ImageView iv1 = new ImageView(img);
					Rectangle2D tuile1 = new Rectangle2D(1*64,0*64,64,64);		 		
					iv1.setViewport(tuile1);
					mapARemplir.getChildren().add(iv1);
					break;
					
				case 2: 
					ImageView iv2 = new ImageView(img);
					Rectangle2D tuile2 = new Rectangle2D(2*64,0*64,64,64);		 		
					iv2.setViewport(tuile2);
					mapARemplir.getChildren().add(iv2);
					break;
				case 3: 
					ImageView iv3 = new ImageView(img);
					Rectangle2D tuile3 = new Rectangle2D(3*64,0*64,64,64);		 		
					iv3.setViewport(tuile3);
					mapARemplir.getChildren().add(iv3);
					break;
				case 4: 
					ImageView iv4 = new ImageView(img);
					Rectangle2D tuile4 = new Rectangle2D(0*64,0*64,64,64);		 		
					iv4.setViewport(tuile4);
					mapARemplir.getChildren().add(iv4);
					break;
				case 5: 
					ImageView iv5 = new ImageView(img);
					Rectangle2D tuile5 = new Rectangle2D(5*64,0*64,64,64);		 		
					iv5.setViewport(tuile5);
					mapARemplir.getChildren().add(iv5);
					break;
				case 6: 
					ImageView iv6 = new ImageView(img);
					Rectangle2D tuile6 = new Rectangle2D(6*64,0*64,64,64);		 		
					iv6.setViewport(tuile6);
					mapARemplir.getChildren().add(iv6);
					break;
				case 7: 
					ImageView iv7 = new ImageView(img);
					Rectangle2D tuile7 = new Rectangle2D(7*64,0*64,64,64);		 		
					iv7.setViewport(tuile7);
					mapARemplir.getChildren().add(iv7);
					break;
				case 8: 
					ImageView iv8 = new ImageView(img);
					Rectangle2D tuile8 = new Rectangle2D(8*64,0*64,64,64);		 		
					iv8.setViewport(tuile8);
					mapARemplir.getChildren().add(iv8);
					break;
				case 9: 
					ImageView iv9 = new ImageView(img);
					Rectangle2D tuile9 = new Rectangle2D(9*64,0*64,64,64);		 		
					iv9.setViewport(tuile9);
					mapARemplir.getChildren().add(iv9);
					break;
				case 10: 
					ImageView iv10 = new ImageView(img);
					Rectangle2D tuile10 = new Rectangle2D(10*64,0*64,64,64);		 		
					iv10.setViewport(tuile10);
					mapARemplir.getChildren().add(iv10);
					break;
				case 11: 
					ImageView iv11 = new ImageView(img);
					Rectangle2D tuile11 = new Rectangle2D(11*64,0*64,64,64);		 		
					iv11.setViewport(tuile11);
					mapARemplir.getChildren().add(iv11);
					break;
				case 12: 
					ImageView iv12 = new ImageView(img);
					Rectangle2D tuile12 = new Rectangle2D(12*64,0*64,64,64);		 		
					iv12.setViewport(tuile12);
					mapARemplir.getChildren().add(iv12);
					break;
				case 13: 
					ImageView iv13 = new ImageView(img);
					Rectangle2D tuile13 = new Rectangle2D(13*64,0*64,64,64);		 		
					iv13.setViewport(tuile13);
					mapARemplir.getChildren().add(iv13);
					break;
				case 14: 
					ImageView iv14 = new ImageView(img);
					Rectangle2D tuile14 = new Rectangle2D(14*64,0*64,64,64);		 		
					iv14.setViewport(tuile14);
					mapARemplir.getChildren().add(iv14);
					break;
				case 15: 
					ImageView iv15 = new ImageView(img);
					Rectangle2D tuile15 = new Rectangle2D(15*64,0*64,64,64);		 		
					iv15.setViewport(tuile15);
					mapARemplir.getChildren().add(iv15);
					break;
				case 16: 
					ImageView iv16 = new ImageView(img);
					Rectangle2D tuile16 = new Rectangle2D(0*64,1*64,64,64);		 		
					iv16.setViewport(tuile16);
					mapARemplir.getChildren().add(iv16);
					break;
				case 17: 
					ImageView iv17 = new ImageView(img);
					Rectangle2D tuile17 = new Rectangle2D(1*64,1*64,64,64);		 		
					iv17.setViewport(tuile17);
					mapARemplir.getChildren().add(iv17);
					break;
				case 18: 
					ImageView iv18 = new ImageView(img);
					Rectangle2D tuile18 = new Rectangle2D(4*64,0*64,64,64);		 		
					iv18.setViewport(tuile18);
					mapARemplir.getChildren().add(iv18);
					break;
				case 19: 
					ImageView iv19 = new ImageView(img);
					Rectangle2D tuile19 = new Rectangle2D(5*64,0*64,64,64);		 		
					iv19.setViewport(tuile19);
					mapARemplir.getChildren().add(iv19);
					break;
				case 20: 
					ImageView iv20 = new ImageView(img);
					Rectangle2D tuile20 = new Rectangle2D(6*64,0*64,64,64);		 		
					iv20.setViewport(tuile20);
					mapARemplir.getChildren().add(iv20);
					break;
				case 21: 
					ImageView iv21 = new ImageView(img);
					Rectangle2D tuile21 = new Rectangle2D(5*64,1*64,64,64);		 		
					iv21.setViewport(tuile21);
					mapARemplir.getChildren().add(iv21);
					break;
				case 22: 
					ImageView iv22 = new ImageView(img);
					Rectangle2D tuile22 = new Rectangle2D(6*64,1*64,64,64);		 		
					iv22.setViewport(tuile22);
					mapARemplir.getChildren().add(iv22);
					break;
				case 23: 
					ImageView iv23 = new ImageView(img);
					Rectangle2D tuile23 = new Rectangle2D(7*64,1*64,64,64);		 		
					iv23.setViewport(tuile23);
					mapARemplir.getChildren().add(iv23);
					break;
				case 24: 
					ImageView iv24 = new ImageView(img);
					Rectangle2D tuile24 = new Rectangle2D(8*64,1*64,64,64);		 		
					iv24.setViewport(tuile24);
					mapARemplir.getChildren().add(iv24);
					break;
				case 25: 
					ImageView iv25 = new ImageView(img);
					Rectangle2D tuile25 = new Rectangle2D(11*64,0*64,64,64);		 		
					iv25.setViewport(tuile25);
					mapARemplir.getChildren().add(iv25);
					break;
				case 26: 
					ImageView iv26 = new ImageView(img);
					Rectangle2D tuile26 = new Rectangle2D(12*64,0*64,64,64);		 		
					iv26.setViewport(tuile26);
					mapARemplir.getChildren().add(iv26);
					break;
				case 27: 
					ImageView iv27 = new ImageView(img);
					Rectangle2D tuile27 = new Rectangle2D(13*64,0*64,64,64);		 		
					iv27.setViewport(tuile27);
					mapARemplir.getChildren().add(iv27);
					break;
				case 28: 
					ImageView iv28 = new ImageView(img);
					Rectangle2D tuile28 = new Rectangle2D(14*64,0*64,64,64);		 		
					iv28.setViewport(tuile28);
					mapARemplir.getChildren().add(iv28);
					break;
				case 29: 
					ImageView iv29 = new ImageView(img);
					Rectangle2D tuile29 = new Rectangle2D(15*64,0*64,64,64);		 		
					iv29.setViewport(tuile29);
					mapARemplir.getChildren().add(iv29);
					break;
				case 30: 
					ImageView iv30 = new ImageView(img);
					Rectangle2D tuile30 = new Rectangle2D(14*64,1*64,64,64);		 		
					iv30.setViewport(tuile30);
					mapARemplir.getChildren().add(iv30);
					break;
				case 31: 
					ImageView iv31 = new ImageView(img);
					Rectangle2D tuile31 = new Rectangle2D(0*64,0*64,64,64);		 		
					iv31.setViewport(tuile31);
					mapARemplir.getChildren().add(iv31);
					break;
				case 32: 
					ImageView iv32 = new ImageView(img);
					Rectangle2D tuile32 = new Rectangle2D(2*64,1*64,64,64);		 		
					iv32.setViewport(tuile32);
					mapARemplir.getChildren().add(iv32);
					break;
				case 33 :
					ImageView iv33 = new ImageView(img);
					Rectangle2D tuile33 = new Rectangle2D(3*64,1*64,64,64);		 		
					iv33.setViewport(tuile33);
					mapARemplir.getChildren().add(iv33);
					break;
					
				case 34: 
					ImageView iv34 = new ImageView(img);
					Rectangle2D tuile34 = new Rectangle2D(4*64,1*64,64,64);		 		
					iv34.setViewport(tuile34);
					mapARemplir.getChildren().add(iv34);
					break;
				case 35: 
					ImageView iv35 = new ImageView(img);
					Rectangle2D tuile35 = new Rectangle2D(5*64,1*64,64,64);		 		
					iv35.setViewport(tuile35);
					mapARemplir.getChildren().add(iv35);
					break;
				case 36: 
					ImageView iv36 = new ImageView(img);
					Rectangle2D tuile36 = new Rectangle2D(6*64,1*64,64,64);		 		
					iv36.setViewport(tuile36);
					mapARemplir.getChildren().add(iv36);
					break;
				case 37: 
					ImageView iv37 = new ImageView(img);
					Rectangle2D tuile37 = new Rectangle2D(7*64,1*64,64,64);		 		
					iv37.setViewport(tuile37);
					mapARemplir.getChildren().add(iv37);
					break;
				case 38: 
					ImageView iv38 = new ImageView(img);
					Rectangle2D tuile38 = new Rectangle2D(8*64,1*64,64,64);		 		
					iv38.setViewport(tuile38);
					mapARemplir.getChildren().add(iv38);
					break;
				case 39: 
					ImageView iv39 = new ImageView(img);
					Rectangle2D tuile39 = new Rectangle2D(9*64,1*64,64,64);		 		
					iv39.setViewport(tuile39);
					mapARemplir.getChildren().add(iv39);
					break;
				case 40: 
					ImageView iv40 = new ImageView(img);
					Rectangle2D tuile40 = new Rectangle2D(10*64,1*64,64,64);		 		
					iv40.setViewport(tuile40);
					mapARemplir.getChildren().add(iv40);
					break;
				case 41: 
					ImageView iv41 = new ImageView(img);
					Rectangle2D tuile41 = new Rectangle2D(11*64,1*64,64,64);		 		
					iv41.setViewport(tuile41);
					mapARemplir.getChildren().add(iv41);
					break;
				case 42: 
					ImageView iv42 = new ImageView(img);
					Rectangle2D tuile42 = new Rectangle2D(12*64,1*64,64,64);		 		
					iv42.setViewport(tuile42);
					mapARemplir.getChildren().add(iv42);
					break;
				case 43 :
					ImageView iv43 = new ImageView(img);
					Rectangle2D tuile43 = new Rectangle2D(13*64,1*64,64,64);		 		
					iv43.setViewport(tuile43);
					mapARemplir.getChildren().add(iv43);
					break;
					
				case 44: 
					ImageView iv44 = new ImageView(img);
					Rectangle2D tuile44 = new Rectangle2D(14*64,1*64,64,64);		 		
					iv44.setViewport(tuile44);
					mapARemplir.getChildren().add(iv44);
					break;
				case 45: 
					ImageView iv45 = new ImageView(img);
					Rectangle2D tuile45 = new Rectangle2D(15*64,1*64,64,64);		 		
					iv45.setViewport(tuile45);
					mapARemplir.getChildren().add(iv45);
					break;
				case 46: 
					ImageView iv46 = new ImageView(img);
					Rectangle2D tuile46 = new Rectangle2D(0*64,2*64,64,64);		 		
					iv46.setViewport(tuile46);
					mapARemplir.getChildren().add(iv46);
					break;
				case 47: 
					ImageView iv47 = new ImageView(img);
					Rectangle2D tuile47 = new Rectangle2D(1*64,2*64,64,64);		 		
					iv47.setViewport(tuile47);
					mapARemplir.getChildren().add(iv47);
					break;
				case 48: 
					ImageView iv48 = new ImageView(img);
					Rectangle2D tuile48 = new Rectangle2D(2*64,2*64,64,64);		 		
					iv48.setViewport(tuile48);
					mapARemplir.getChildren().add(iv48);
					break;
				case 49: 
					ImageView iv49 = new ImageView(img);
					Rectangle2D tuile49 = new Rectangle2D(3*64,2*64,64,64);		 		
					iv49.setViewport(tuile49);
					mapARemplir.getChildren().add(iv49);
					break;
				case 50: 
					ImageView iv50 = new ImageView(img);
					Rectangle2D tuile50 = new Rectangle2D(4*64,2*64,64,64);		 		
					iv50.setViewport(tuile50);
					mapARemplir.getChildren().add(iv50);
					break;
				case 51: 
					ImageView iv51 = new ImageView(img);
					Rectangle2D tuile51 = new Rectangle2D(5*64,2*64,64,64);		 		
					iv51.setViewport(tuile51);
					mapARemplir.getChildren().add(iv51);
					break;
				case 52: 
					ImageView iv52 = new ImageView(img);
					Rectangle2D tuile52 = new Rectangle2D(6*64,2*64,64,64);		 		
					iv52.setViewport(tuile52);
					mapARemplir.getChildren().add(iv52);
					break;
				case 53 :
					ImageView iv53 = new ImageView(img);
					Rectangle2D tuile53 = new Rectangle2D(7*64,2*64,64,64);		 		
					iv53.setViewport(tuile53);
					mapARemplir.getChildren().add(iv53);
					break;
					
				case 54: 
					ImageView iv54 = new ImageView(img);
					Rectangle2D tuile54 = new Rectangle2D(8*64,2*64,64,64);		 		
					iv54.setViewport(tuile54);
					mapARemplir.getChildren().add(iv54);
					break;
				case 55: 
					ImageView iv55 = new ImageView(img);
					Rectangle2D tuile55 = new Rectangle2D(9*64,2*64,64,64);		 		
					iv55.setViewport(tuile55);
					mapARemplir.getChildren().add(iv55);
					break;
				case 56: 
					ImageView iv56 = new ImageView(img);
					Rectangle2D tuile56 = new Rectangle2D(10*64,2*64,64,64);		 		
					iv56.setViewport(tuile56);
					mapARemplir.getChildren().add(iv56);
					break;
				case 57: 
					ImageView iv57 = new ImageView(img);
					Rectangle2D tuile57 = new Rectangle2D(11*64,2*64,64,64);		 		
					iv57.setViewport(tuile57);
					mapARemplir.getChildren().add(iv57);
					break;
				case 58: 
					ImageView iv58 = new ImageView(img);
					Rectangle2D tuile58 = new Rectangle2D(12*64,2*64,64,64);		 		
					iv58.setViewport(tuile58);
					mapARemplir.getChildren().add(iv58);
					break;
				case 59: 
					ImageView iv59= new ImageView(img);
					Rectangle2D tuile59 = new Rectangle2D(13*64,2*64,64,64);		 		
					iv59.setViewport(tuile59);
					mapARemplir.getChildren().add(iv59);
					break;
				case 60: 
					ImageView iv60 = new ImageView(img);
					Rectangle2D tuile60 = new Rectangle2D(14*64,2*64,64,64);		 		
					iv60.setViewport(tuile60);
					mapARemplir.getChildren().add(iv60);
					break;
				case 61: 
					ImageView iv61 = new ImageView(img);
					Rectangle2D tuile61 = new Rectangle2D(15*64,2*64,64,64);		 		
					iv61.setViewport(tuile61);
					mapARemplir.getChildren().add(iv61);
					break;
				case 62: 
					ImageView iv62 = new ImageView(img);
					Rectangle2D tuile62= new Rectangle2D(0*64,3*64,64,64);		 		
					iv62.setViewport(tuile62);
					mapARemplir.getChildren().add(iv62);
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

