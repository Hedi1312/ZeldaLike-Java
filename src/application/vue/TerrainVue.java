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
		this.img = new Image("src/images/TilesetFinal.png");
		this.mapARemplir = tP;
		this.terrain=terrain;
		chargerTerrain(0);
		this.terrain.caseChangeeProperty().addListener((obs,old,nouv)-> setTuileVue(nouv.intValue()/30, nouv.intValue()%30));
	}

	public Image getImage() {
		return img;
	}

	public TilePane getMapARemplir() {
		return mapARemplir;
	}
	
	public void getTuileVue(int x , int y) {
		mapARemplir.getChildren().get((y*30+x));
		
	}
	
	public void setTuileVue(int y , int x) {
		ImageView iv = new ImageView(img);
		Rectangle2D tuile = null;
		if(terrain.getMapActuelle()[y][x]==112) {
			tuile = new Rectangle2D(16*16,3*16,16,16);
		}
		else
			tuile = new Rectangle2D(2*16,1*16,16,16);		 		
		iv.setViewport(tuile);
		mapARemplir.getChildren().set(y*30+x, iv);
	}
	
	public void chargerTerrain(int numeroMap) {
		terrain.setMap(numeroMap);
		int idTuile;
		for(int i = 0; i < terrain.getMapActuelle().length; i++){
			for(int j=0 ; j <terrain.getMapActuelle()[i].length; j++) {
				idTuile = terrain.getMapActuelle()[i][j];
				switch(idTuile) { 
				
				case 0 :
					ImageView iv0 = new ImageView(img);
					Rectangle2D tuile0 = new Rectangle2D(0*16,0*16,16,16);		 		
					iv0.setViewport(tuile0);
					mapARemplir.getChildren().add(iv0);
					break;
					
				case 1 :
					ImageView iv1 = new ImageView(img);
					Rectangle2D tuile1 = new Rectangle2D(1*16,0*16,16,16);		 		
					iv1.setViewport(tuile1);
					mapARemplir.getChildren().add(iv1);
					break;
					
				case 2: 
					ImageView iv2 = new ImageView(img);
					Rectangle2D tuile2 = new Rectangle2D(2*16,0*16,16,16);			 		
					iv2.setViewport(tuile2);
					mapARemplir.getChildren().add(iv2);
					break;
				case 3: 
					ImageView iv3 = new ImageView(img);
					Rectangle2D tuile3 =new Rectangle2D(3*16,0*16,16,16);		 		
					iv3.setViewport(tuile3);
					mapARemplir.getChildren().add(iv3);
					break;
				case 4: 
					ImageView iv4 = new ImageView(img);
					Rectangle2D tuile4 = new Rectangle2D(4*16,0*16,16,16);			 		
					iv4.setViewport(tuile4);
					mapARemplir.getChildren().add(iv4);
					break;
				case 5: 
					ImageView iv5 = new ImageView(img);
					Rectangle2D tuile5 = new Rectangle2D(5*16,0*16,16,16);		 		
					iv5.setViewport(tuile5);
					mapARemplir.getChildren().add(iv5);
					break;
				case 6: 
					ImageView iv6 = new ImageView(img);
					Rectangle2D tuile6 =new Rectangle2D(6*16,0*16,16,16);		 		
					iv6.setViewport(tuile6);
					mapARemplir.getChildren().add(iv6);
					break;
				case 7: 
					ImageView iv7 = new ImageView(img);
					Rectangle2D tuile7 =new Rectangle2D(7*16,0*16,16,16);			 		
					iv7.setViewport(tuile7);
					mapARemplir.getChildren().add(iv7);
					break;
				case 8: 
					ImageView iv8 = new ImageView(img);
					Rectangle2D tuile8 =new Rectangle2D(8*16,0*16,16,16);			 		
					iv8.setViewport(tuile8);
					mapARemplir.getChildren().add(iv8);
					break;
				case 9: 
					ImageView iv9 = new ImageView(img);
					Rectangle2D tuile9 = new Rectangle2D(9*16,0*16,16,16);		 		
					iv9.setViewport(tuile9);
					mapARemplir.getChildren().add(iv9);
					break;
				case 10: 
					ImageView iv10 = new ImageView(img);
					Rectangle2D tuile10 = new Rectangle2D(10*16,0*16,16,16);			 		
					iv10.setViewport(tuile10);
					mapARemplir.getChildren().add(iv10);
					break;
				case 11: 
					ImageView iv11 = new ImageView(img);
					Rectangle2D tuile11 = new Rectangle2D(11*16,0*16,16,16);			 		
					iv11.setViewport(tuile11);
					mapARemplir.getChildren().add(iv11);
					break;
				case 12: 
					ImageView iv12 = new ImageView(img);
					Rectangle2D tuile12 =new Rectangle2D(12*16,0*16,16,16);			 		
					iv12.setViewport(tuile12);
					mapARemplir.getChildren().add(iv12);
					break;
				case 13: 
					ImageView iv13 = new ImageView(img);
					Rectangle2D tuile13 = new Rectangle2D(13*16,0*16,16,16);			 		
					iv13.setViewport(tuile13);
					mapARemplir.getChildren().add(iv13);
					break;
				case 14: 
					ImageView iv14 = new ImageView(img);
					Rectangle2D tuile14 = new Rectangle2D(14*16,0*16,16,16);		 		
					iv14.setViewport(tuile14);
					mapARemplir.getChildren().add(iv14);
					break;
				case 15: 
					ImageView iv15 = new ImageView(img);
					Rectangle2D tuile15 =new Rectangle2D(15*16,0*16,16,16);		 		
					iv15.setViewport(tuile15);
					mapARemplir.getChildren().add(iv15);
					break;
				case 16: 
					ImageView iv16 = new ImageView(img);
					Rectangle2D tuile16 = new Rectangle2D(16*16,0*16,16,16);			 		
					iv16.setViewport(tuile16);
					mapARemplir.getChildren().add(iv16);
					break;					
				case 18: 
					ImageView iv18 = new ImageView(img);
					Rectangle2D tuile18 =new Rectangle2D(18*16,0*16,16,16);	 		
					iv18.setViewport(tuile18);
					mapARemplir.getChildren().add(iv18);
					break;
				case 19: 
					ImageView iv19 = new ImageView(img);
					Rectangle2D tuile19 =new Rectangle2D(19*16,0*16,16,16);	 		
					iv19.setViewport(tuile19);
					mapARemplir.getChildren().add(iv19);
					break;
				case 20: 
					ImageView iv20 = new ImageView(img);
					Rectangle2D tuile20 =new Rectangle2D(20*16,0*16,16,16);	 		
					iv20.setViewport(tuile20);
					mapARemplir.getChildren().add(iv20);
					break;
				case 21: 
					ImageView iv21 = new ImageView(img);
					Rectangle2D tuile21 =new Rectangle2D(21*16,0*16,16,16);	 		
					iv21.setViewport(tuile21);
					mapARemplir.getChildren().add(iv21);
					break;
				case 22: 
					ImageView iv22 = new ImageView(img);
					Rectangle2D tuile22 =new Rectangle2D(22*16,0*16,16,16);	 		
					iv22.setViewport(tuile22);
					mapARemplir.getChildren().add(iv22);
					break;
				case 23: 
					ImageView iv23 = new ImageView(img);
					Rectangle2D tuile23 =new Rectangle2D(23*16,0*16,16,16);	 		
					iv23.setViewport(tuile23);
					mapARemplir.getChildren().add(iv23);
					break;
				case 24: 
					ImageView iv24 = new ImageView(img);
					Rectangle2D tuile24 =new Rectangle2D(24*16,0*16,16,16);	 		
					iv24.setViewport(tuile24);
					mapARemplir.getChildren().add(iv24);
					break;
				case 25: 
					ImageView iv25 = new ImageView(img);
					Rectangle2D tuile25 =new Rectangle2D(25*16,0*16,16,16);	 		
					iv25.setViewport(tuile25);
					mapARemplir.getChildren().add(iv25);
					break;
				case 26: 
					ImageView iv26 = new ImageView(img);
					Rectangle2D tuile26 =new Rectangle2D(26*16,0*16,16,16);	 		
					iv26.setViewport(tuile26);
					mapARemplir.getChildren().add(iv26);
					break;
				case 27:
					ImageView iv27 = new ImageView(img);
					Rectangle2D tuile27 =new Rectangle2D(27*16,0*16,16,16);	 		
					iv27.setViewport(tuile27);
					mapARemplir.getChildren().add(iv27);
					break;
				case 28: 
					ImageView iv28 = new ImageView(img);
					Rectangle2D tuile28 =new Rectangle2D(28*16,0*16,16,16);	 		
					iv28.setViewport(tuile28);
					mapARemplir.getChildren().add(iv28);
					break;
				case 29: 
					ImageView iv29 = new ImageView(img);
					Rectangle2D tuile29 =new Rectangle2D(29*16,0*16,16,16);	 		
					iv29.setViewport(tuile29);
					mapARemplir.getChildren().add(iv29);
					break;
				case 30: 
					ImageView iv30 = new ImageView(img);
					Rectangle2D tuile30=new Rectangle2D(30*16,0*16,16,16);	 		
					iv30.setViewport(tuile30);
					mapARemplir.getChildren().add(iv30);
					break;
				case 31: 
					ImageView iv31 = new ImageView(img);
					Rectangle2D tuile31=new Rectangle2D(31*16,0*16,16,16);	 		
					iv31.setViewport(tuile31);
					mapARemplir.getChildren().add(iv31);
					break;
					
				case 32: 
					ImageView iv32 = new ImageView(img);
					Rectangle2D tuile32=new Rectangle2D(0*16,1*16,16,16);	 		
					iv32.setViewport(tuile32);
					mapARemplir.getChildren().add(iv32);
					break;
				case 33: 
					ImageView iv33 = new ImageView(img);
					Rectangle2D tuile33=new Rectangle2D(1*16,1*16,16,16);	 		
					iv33.setViewport(tuile33);
					mapARemplir.getChildren().add(iv33);
					break;
				case 34: 
					ImageView iv34 = new ImageView(img);
					Rectangle2D tuile34=new Rectangle2D(2*16,1*16,16,16);	 		
					iv34.setViewport(tuile34);
					mapARemplir.getChildren().add(iv34);
					break;
				case 35: 
					ImageView iv35 = new ImageView(img);
					Rectangle2D tuile35=new Rectangle2D(3*16,1*16,16,16);	 		
					iv35.setViewport(tuile35);
					mapARemplir.getChildren().add(iv35);
					break;
					
				case 36: 
					ImageView iv36 = new ImageView(img);
					Rectangle2D tuile36=new Rectangle2D(4*16,1*16,16,16);	 		
					iv36.setViewport(tuile36);
					mapARemplir.getChildren().add(iv36);
					break;
				case 37: 
					ImageView iv37 = new ImageView(img);
					Rectangle2D tuile37=new Rectangle2D(5*16,1*16,16,16);	 		
					iv37.setViewport(tuile37);
					mapARemplir.getChildren().add(iv37);
					break;
				case 38: 
					ImageView iv38 = new ImageView(img);
					Rectangle2D tuile38=new Rectangle2D(6*16,1*16,16,16);	 		
					iv38.setViewport(tuile38);
					mapARemplir.getChildren().add(iv38);
					break;
					
				case 39: 
					ImageView iv39 = new ImageView(img);
					Rectangle2D tuile39=new Rectangle2D(7*16,1*16,16,16);	 		
					iv39.setViewport(tuile39);
					mapARemplir.getChildren().add(iv39);
					break;
				case 40: 
					ImageView iv40 = new ImageView(img);
					Rectangle2D tuile40=new Rectangle2D(8*16,1*16,16,16);	 		
					iv40.setViewport(tuile40);
					mapARemplir.getChildren().add(iv40);
					break;
				case 41: 
					ImageView iv41 = new ImageView(img);
					Rectangle2D tuile41=new Rectangle2D(9*16,1*16,16,16);	 		
					iv41.setViewport(tuile41);
					mapARemplir.getChildren().add(iv41);
					break;
				case 42: 
					ImageView iv42 = new ImageView(img);
					Rectangle2D tuile42=new Rectangle2D(10*16,1*16,16,16);	 		
					iv42.setViewport(tuile42);
					mapARemplir.getChildren().add(iv42);
					break;
				case 43: 
					ImageView iv43 = new ImageView(img);
					Rectangle2D tuile43=new Rectangle2D(11*16,1*16,16,16);	 		
					iv43.setViewport(tuile43);
					mapARemplir.getChildren().add(iv43);
					break;
				case 44: 
					ImageView iv44 = new ImageView(img);
					Rectangle2D tuile44=new Rectangle2D(12*16,1*16,16,16);	 		
					iv44.setViewport(tuile44);
					mapARemplir.getChildren().add(iv44);
					break;
				case 45: 
					ImageView iv45 = new ImageView(img);
					Rectangle2D tuile45=new Rectangle2D(13*16,1*16,16,16);	 		
					iv45.setViewport(tuile45);
					mapARemplir.getChildren().add(iv45);
					break;
				case 46: 
					ImageView iv46 = new ImageView(img);
					Rectangle2D tuile46=new Rectangle2D(14*16,1*16,16,16);	 		
					iv46.setViewport(tuile46);
					mapARemplir.getChildren().add(iv46);
					break;
				case 47: 
					ImageView iv47 = new ImageView(img);
					Rectangle2D tuile47=new Rectangle2D(15*16,1*16,16,16);	 		
					iv47.setViewport(tuile47);
					mapARemplir.getChildren().add(iv47);
					break;
				case 48: 
					ImageView iv48 = new ImageView(img);
					Rectangle2D tuile48=new Rectangle2D(16*16,1*16,16,16);	 		
					iv48.setViewport(tuile48);
					mapARemplir.getChildren().add(iv48);
					break;
				case 49: 
					ImageView iv49 = new ImageView(img);
					Rectangle2D tuile49=new Rectangle2D(17*16,1*16,16,16);	 		
					iv49.setViewport(tuile49);
					mapARemplir.getChildren().add(iv49);
					break;
				case 50: 
					ImageView iv50 = new ImageView(img);
					Rectangle2D tuile50=new Rectangle2D(18*16,1*16,16,16);	 		
					iv50.setViewport(tuile50);
					mapARemplir.getChildren().add(iv50);
					break;
					
				case 51: 
					ImageView iv51 = new ImageView(img);
					Rectangle2D tuile51=new Rectangle2D(19*16,1*16,16,16);	 		
					iv51.setViewport(tuile51);
					mapARemplir.getChildren().add(iv51);
					break;
				case 52: 
					ImageView iv52 = new ImageView(img);
					Rectangle2D tuile52=new Rectangle2D(20*16,1*16,16,16);	 		
					iv52.setViewport(tuile52);
					mapARemplir.getChildren().add(iv52);
					break;
				case 53: 
					ImageView iv53 = new ImageView(img);
					Rectangle2D tuile53=new Rectangle2D(21*16,1*16,16,16);	 		
					iv53.setViewport(tuile53);
					mapARemplir.getChildren().add(iv53);
					break;
				case 54: 
					ImageView iv54 = new ImageView(img);
					Rectangle2D tuile54=new Rectangle2D(22*16,1*16,16,16);	 		
					iv54.setViewport(tuile54);
					mapARemplir.getChildren().add(iv54);
					break;
				case 55: 
					ImageView iv55 = new ImageView(img);
					Rectangle2D tuile55=new Rectangle2D(23*16,1*16,16,16);	 		
					iv55.setViewport(tuile55);
					mapARemplir.getChildren().add(iv55);
					break;
				case 56: 
					ImageView iv56 = new ImageView(img);
					Rectangle2D tuile56=new Rectangle2D(24*16,1*16,16,16);	 		
					iv56.setViewport(tuile56);
					mapARemplir.getChildren().add(iv56);
					break;
				case 57: 
					ImageView iv57 = new ImageView(img);
					Rectangle2D tuile57=new Rectangle2D(25*16,1*16,16,16);	 		
					iv57.setViewport(tuile57);
					mapARemplir.getChildren().add(iv57);
					break;
				case 58: 
					ImageView iv58 = new ImageView(img);
					Rectangle2D tuile58=new Rectangle2D(26*16,1*16,16,16);	 		
					iv58.setViewport(tuile58);
					mapARemplir.getChildren().add(iv58);
					break;
				case 59: 
					ImageView iv59= new ImageView(img);
					Rectangle2D tuile59=new Rectangle2D(27*16,1*16,16,16);	 		
					iv59.setViewport(tuile59);
					mapARemplir.getChildren().add(iv59);
					break;
				case 60: 
					ImageView iv60 = new ImageView(img);
					Rectangle2D tuile60=new Rectangle2D(28*16,1*16,16,16);	 		
					iv60.setViewport(tuile60);
					mapARemplir.getChildren().add(iv60);
					break;
				case 61: 
					ImageView iv61= new ImageView(img);
					Rectangle2D tuile61=new Rectangle2D(29*16,1*16,16,16);	 		
					iv61.setViewport(tuile61);
					mapARemplir.getChildren().add(iv61);
					break;
				case 62: 
					ImageView iv62 = new ImageView(img);
					Rectangle2D tuile62=new Rectangle2D(30*16,1*16,16,16);	 		
					iv62.setViewport(tuile62);
					mapARemplir.getChildren().add(iv62);
					break;
				case 63: 
					ImageView iv63 = new ImageView(img);
					Rectangle2D tuile63=new Rectangle2D(31*16,1*16,16,16);	 		
					iv63.setViewport(tuile63);
					mapARemplir.getChildren().add(iv63);
					break;
					
				case 64:
                    ImageView iv64 = new ImageView(img);
                    Rectangle2D tuile64 = new Rectangle2D(0*16,2*16,16,16);                 
                    iv64.setViewport(tuile64);
                    mapARemplir.getChildren().add(iv64);
                    break;
                case 65:
                    ImageView iv65 = new ImageView(img);
                    Rectangle2D tuile65 = new Rectangle2D(1*16,2*16,16,16);                 
                    iv65.setViewport(tuile65);
                    mapARemplir.getChildren().add(iv65);
                    break;
                case 66:
                    ImageView iv66 = new ImageView(img);
                    Rectangle2D tuile66 = new Rectangle2D(2*16,2*16,16,16);                 
                    iv66.setViewport(tuile66);
                    mapARemplir.getChildren().add(iv66);
                    break;
                case 67:
                    ImageView iv67 = new ImageView(img);
                    Rectangle2D tuile67 = new Rectangle2D(3*16,2*16,16,16);                 
                    iv67.setViewport(tuile67);
                    mapARemplir.getChildren().add(iv67);
                    break;
                case 68:
                    ImageView iv68 = new ImageView(img);
                    Rectangle2D tuile68 = new Rectangle2D(4*16,2*16,16,16);                 
                    iv68.setViewport(tuile68);
                    mapARemplir.getChildren().add(iv68);
                    break;
				case 69: 
					ImageView iv69 = new ImageView(img);
					Rectangle2D tuile69 = new Rectangle2D(5*16,2*16,16,16);		 		
					iv69.setViewport(tuile69);
					mapARemplir.getChildren().add(iv69);
					break;
				case 70: 
					ImageView iv70 = new ImageView(img);
					Rectangle2D tuile70 = new Rectangle2D(6*16,2*16,16,16);		 		
					iv70.setViewport(tuile70);
					mapARemplir.getChildren().add(iv70);
					break;
				case 71: 
					ImageView iv71 = new ImageView(img);
					Rectangle2D tuile71 = new Rectangle2D(7*16,2*16,16,16);			 		
					iv71.setViewport(tuile71);
					mapARemplir.getChildren().add(iv71);
					break;
				case 72: 
					ImageView iv72 = new ImageView(img);
					Rectangle2D tuile72 = new Rectangle2D(8*16,2*16,16,16);		 		
					iv72.setViewport(tuile72);
					mapARemplir.getChildren().add(iv72);
					break;
				case 73: 
					ImageView iv73 = new ImageView(img);
					Rectangle2D tuile73 =new Rectangle2D(9*16,2*16,16,16);			 		
					iv73.setViewport(tuile73);
					mapARemplir.getChildren().add(iv73);
					break;
				case 74: 
					ImageView iv74 = new ImageView(img);
					Rectangle2D tuile74 =new Rectangle2D(10*16,2*16,16,16);	 		
					iv74.setViewport(tuile74);
					mapARemplir.getChildren().add(iv74);
					break;
				case 75:
					ImageView iv75 = new ImageView(img);
					Rectangle2D tuile75 = new Rectangle2D(11*16,2*16,16,16);		 		
					iv75.setViewport(tuile75);
					mapARemplir.getChildren().add(iv75);
					break;
				case 76:
					ImageView iv76 = new ImageView(img);
					Rectangle2D tuile76 = new Rectangle2D(12*16,2*16,16,16);		 		
					iv76.setViewport(tuile76);
					mapARemplir.getChildren().add(iv76);
					break;
				case 77:
					ImageView iv77 = new ImageView(img);
					Rectangle2D tuile77 = new Rectangle2D(13*16,2*16,16,16);		 		
					iv77.setViewport(tuile77);
					mapARemplir.getChildren().add(iv77);
					break;
				case 78:
					ImageView iv78 = new ImageView(img);
					Rectangle2D tuile78 = new Rectangle2D(14*16,2*16,16,16);		 		
					iv78.setViewport(tuile78);
					mapARemplir.getChildren().add(iv78);
					break;
				case 79:
					ImageView iv79 = new ImageView(img);
					Rectangle2D tuile79 = new Rectangle2D(15*16,2*16,16,16);		 		
					iv79.setViewport(tuile79);
					mapARemplir.getChildren().add(iv79);
					break;
				case 80:
					ImageView iv80 = new ImageView(img);
					Rectangle2D tuile80 = new Rectangle2D(16*16,2*16,16,16);		 		
					iv80.setViewport(tuile80);
					mapARemplir.getChildren().add(iv80);
					break;
				case 81:
					ImageView iv81 = new ImageView(img);
					Rectangle2D tuile81 = new Rectangle2D(17*16,2*16,16,16);		 		
					iv81.setViewport(tuile81);
					mapARemplir.getChildren().add(iv81);
					break;
				case 82:
					ImageView iv82 = new ImageView(img);
					Rectangle2D tuile82 = new Rectangle2D(18*16,2*16,16,16);		 		
					iv82.setViewport(tuile82);
					mapARemplir.getChildren().add(iv82);
					break;
				case 83:
					ImageView iv83 = new ImageView(img);
					Rectangle2D tuile83 = new Rectangle2D(19*16,2*16,16,16);		 		
					iv83.setViewport(tuile83);
					mapARemplir.getChildren().add(iv83);
					break;
				case 84:
					ImageView iv84 = new ImageView(img);
					Rectangle2D tuile84 = new Rectangle2D(20*16,2*16,16,16);		 		
					iv84.setViewport(tuile84);
					mapARemplir.getChildren().add(iv84);
					break;
				case 85:
					ImageView iv85 = new ImageView(img);
					Rectangle2D tuile85 = new Rectangle2D(21*16,2*16,16,16);		 		
					iv85.setViewport(tuile85);
					mapARemplir.getChildren().add(iv85);
					break;
				case 86:
					ImageView iv86 = new ImageView(img);
					Rectangle2D tuile86 = new Rectangle2D(22*16,2*16,16,16);		 		
					iv86.setViewport(tuile86);
					mapARemplir.getChildren().add(iv86);
					break;
				case 87:
					ImageView iv87= new ImageView(img);
					Rectangle2D tuile87 = new Rectangle2D(23*16,2*16,16,16);		 		
					iv87.setViewport(tuile87);
					mapARemplir.getChildren().add(iv87);
					break;
				case 88:
					ImageView iv88 = new ImageView(img);
					Rectangle2D tuile88 = new Rectangle2D(24*16,2*16,16,16);		 		
					iv88.setViewport(tuile88);
					mapARemplir.getChildren().add(iv88);
					break;
				case 89:
					ImageView iv89 = new ImageView(img);
					Rectangle2D tuile89 = new Rectangle2D(25*16,2*16,16,16);		 		
					iv89.setViewport(tuile89);
					mapARemplir.getChildren().add(iv89);
					break;
				case 90:
					ImageView iv90 = new ImageView(img);
					Rectangle2D tuile90 = new Rectangle2D(26*16,2*16,16,16);		 		
					iv90.setViewport(tuile90);
					mapARemplir.getChildren().add(iv90);
					break;
				case 91:
					ImageView iv91 = new ImageView(img);
					Rectangle2D tuile91 = new Rectangle2D(27*16,2*16,16,16);		 		
					iv91.setViewport(tuile91);
					mapARemplir.getChildren().add(iv91);
					break;
				case 92:
					ImageView iv92 = new ImageView(img);
					Rectangle2D tuile92 = new Rectangle2D(28*16,2*16,16,16);		 		
					iv92.setViewport(tuile92);
					mapARemplir.getChildren().add(iv92);
					break;
				case 93:
					ImageView iv93 = new ImageView(img);
					Rectangle2D tuile93 = new Rectangle2D(29*16,2*16,16,16);		 		
					iv93.setViewport(tuile93);
					mapARemplir.getChildren().add(iv93);
					break;	
				case 94:
					ImageView iv94 = new ImageView(img);
					Rectangle2D tuile94 = new Rectangle2D(30*16,2*16,16,16);		 		
					iv94.setViewport(tuile94);
					mapARemplir.getChildren().add(iv94);
					break;
				case 95:
					ImageView iv95 = new ImageView(img);
					Rectangle2D tuile95 = new Rectangle2D(31*16,2*16,16,16);		 		
					iv95.setViewport(tuile95);
					mapARemplir.getChildren().add(iv95);
					break;
				case 96:
					ImageView iv96 = new ImageView(img);
					Rectangle2D tuile96 = new Rectangle2D(0*16,3*16,16,16);		 		
					iv96.setViewport(tuile96);
					mapARemplir.getChildren().add(iv96);
					break;
				case 97:
					ImageView iv97 = new ImageView(img);
					Rectangle2D tuile97 = new Rectangle2D(1*16,3*16,16,16);		 		
					iv97.setViewport(tuile97);
					mapARemplir.getChildren().add(iv97);
					break;
				case 98:
					ImageView iv98 = new ImageView(img);
					Rectangle2D tuile98 = new Rectangle2D(2*16,3*16,16,16);		 		
					iv98.setViewport(tuile98);
					mapARemplir.getChildren().add(iv98);
					break;
				case 99:
					ImageView iv99 = new ImageView(img);
					Rectangle2D tuile99 = new Rectangle2D(3*16,3*16,16,16);		 		
					iv99.setViewport(tuile99);
					mapARemplir.getChildren().add(iv99);
					break;
				case 100:
					ImageView iv100 = new ImageView(img);
					Rectangle2D tuile100 = new Rectangle2D(4*16,3*16,16,16);		 		
					iv100.setViewport(tuile100);
					mapARemplir.getChildren().add(iv100);
					break;
				case 101:
					ImageView iv101 = new ImageView(img);
					Rectangle2D tuile101 = new Rectangle2D(5*16,3*16,16,16);		 		
					iv101.setViewport(tuile101);
					mapARemplir.getChildren().add(iv101);
					break;
				case 102:
					ImageView iv102 = new ImageView(img);
					Rectangle2D tuile102 = new Rectangle2D(6*16,3*16,16,16);		 		
					iv102.setViewport(tuile102);
					mapARemplir.getChildren().add(iv102);
					break;
				case 103:
					ImageView iv103 = new ImageView(img);
					Rectangle2D tuile103 = new Rectangle2D(7*16,3*16,16,16);		 		
					iv103.setViewport(tuile103);
					mapARemplir.getChildren().add(iv103);
					break;
				case 104:
					ImageView iv104 = new ImageView(img);
					Rectangle2D tuile104 = new Rectangle2D(8*16,3*16,16,16);		 		
					iv104.setViewport(tuile104);
					mapARemplir.getChildren().add(iv104);
					break;
				case 105:
					ImageView iv105 = new ImageView(img);
					Rectangle2D tuile105 = new Rectangle2D(9*16,3*16,16,16);		 		
					iv105.setViewport(tuile105);
					mapARemplir.getChildren().add(iv105);
					break;
				case 106:
					ImageView iv106 = new ImageView(img);
					Rectangle2D tuile106 = new Rectangle2D(10*16,3*16,16,16);		 		
					iv106.setViewport(tuile106);
					mapARemplir.getChildren().add(iv106);
					break;
				case 107:
					ImageView iv107 = new ImageView(img);
					Rectangle2D tuile107 = new Rectangle2D(11*16,3*16,16,16);		 		
					iv107.setViewport(tuile107);
					mapARemplir.getChildren().add(iv107);
					break;
				case 108:
					ImageView iv108 = new ImageView(img);
					Rectangle2D tuile108 = new Rectangle2D(12*16,3*16,16,16);		 		
					iv108.setViewport(tuile108);
					mapARemplir.getChildren().add(iv108);
					break;
				case 109:
					ImageView iv109 = new ImageView(img);
					Rectangle2D tuile109 = new Rectangle2D(13*16,3*16,16,16);		 		
					iv109.setViewport(tuile109);
					mapARemplir.getChildren().add(iv109);
					break;
				case 110:
					ImageView iv110 = new ImageView(img);
					Rectangle2D tuile110 = new Rectangle2D(14*16,3*16,16,16);		 		
					iv110.setViewport(tuile110);
					mapARemplir.getChildren().add(iv110);
					break;
				case 111:
					ImageView iv111 = new ImageView(img);
					Rectangle2D tuile111 = new Rectangle2D(15*16,3*16,16,16);		 		
					iv111.setViewport(tuile111);
					mapARemplir.getChildren().add(iv111);
					break;
				case 112:
					ImageView iv112 = new ImageView(img);
					Rectangle2D tuile112 = new Rectangle2D(16*16,3*16,16,16);		 		
					iv112.setViewport(tuile112);
					mapARemplir.getChildren().add(iv112);
					break;
				}
			}
		}
	}
	
}

