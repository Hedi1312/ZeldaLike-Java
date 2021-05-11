package src.application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import src.application.modele.Environnement;
import src.application.modele.Hero;
import src.application.modele.Terrain;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controleur implements Initializable{
	private Environnement env;
	
	  @FXML
	    private BorderPane borderPane;

	
	@FXML
    private TilePane panneauDeTuiles;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.panneauDeTuiles.setOrientation(Orientation.HORIZONTAL);
		this.panneauDeTuiles.setPrefColumns(320);
		
		Terrain terrain =new Terrain(panneauDeTuiles);
		terrain.chargerTerrain();
		
		Hero hero = new Hero(panneauDeTuiles);
		hero.spawnHero();
		
		this.env= new Environnement(hero);
		

		
	}
	
	public void deplacement(KeyEvent event){
	    
	    	ImageView iv= this.env.getHero().getIV();
	       switch (event.getCode()) {
	       case UP:    
	    	   System.out.println("haut");
	    	   //deplacerHaut methode dans hero
          	 iv.relocate(iv.getLayoutX(), iv.getLayoutY()-5);
          	break;
	       case DOWN:  
	    	   System.out.println("bas");
          	 iv.relocate(iv.getLayoutX(), iv.getLayoutY()+5);
          	break;
          case LEFT: 
        	  System.out.println("gauche");
          	 iv.relocate(iv.getLayoutX()-5, iv.getLayoutY());
          	break;
          case RIGHT:
        	  System.out.println("droite");
          	 iv.relocate(iv.getLayoutX()+5, iv.getLayoutY());
          	break;

      }
	}
	

	
	
	
}
