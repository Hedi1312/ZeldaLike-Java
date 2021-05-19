package src.application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import src.application.modele.Environnement;
import src.application.modele.Hero;
import src.application.modele.Terrain;
import src.application.vue.HeroVue;
import src.application.vue.TerrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Controleur implements Initializable{
	private Environnement env;
	
	@FXML
	private BorderPane borderPane;

	@FXML
	private Pane pane;
	
	@FXML
	private TilePane panneauDeTuiles;
	
	private Timeline gameLoop;
	private int temps;
	
	private TerrainVue terrainVue;
	
	private HeroVue heroVue;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		this.panneauDeTuiles.setPrefColumns(320);
		
		this.env = new Environnement();

		
		lancement();
		
		initAnimation();
		gameLoop.play();
	}
	
	public void deplacement(KeyEvent event){
	    
	    	switch (event.getCode()) {
	    	case UP:    
	    		System.out.println("haut");
	    		heroVue.allerEnHaut();  		
	    		break;
	    	case DOWN:  
	    		System.out.println("bas");
	    		heroVue.allerEnBas();
	    		break;
	    	case LEFT: 
	    		System.out.println("gauche");
	    		heroVue.allerAGauche();
	    		break;
	    	case RIGHT:
	    		System.out.println("droite");
	    		heroVue.allerADroite();
	    		break;

      }
	}
	
	public void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if(temps==100){
					System.out.println("temps = 100");
					
					}
					else if (temps%5==0){
						System.out.println("un tour");
        		
					}
					temps++;
				})
		);
		gameLoop.getKeyFrames().add(kf);
	}
	
	public void lancement() {
		terrainVue = new TerrainVue(panneauDeTuiles, env.getTerrain());
		terrainVue.chargerTerrain();
		
		Hero hero = new Hero(env);
		env.ajouterHero(hero);
		
		heroVue = new HeroVue(env.getHero());
		pane.getChildren().add(heroVue.getIV());
		env.ajouterHero(hero);
		
		heroVue.getIV().translateXProperty().bind(hero.getXProperty());
		heroVue.getIV().translateYProperty().bind(hero.getYProperty());
	}
	
	
}
