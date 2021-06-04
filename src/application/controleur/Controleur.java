package src.application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import src.application.modele.Ennemi;
import src.application.modele.EnnemiBasique;
import src.application.modele.EnnemiExplosif;
import src.application.modele.Environnement;
import src.application.modele.Hero;
import src.application.modele.Personnage;
import src.application.modele.Terrain;
import src.application.vue.EnnemiBasiqueVue;
import src.application.vue.EnnemiExplosifVue;
import src.application.vue.HeroVue;
import src.application.vue.TerrainVue;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
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
	
	private EnnemiExplosifVue ennemiExplosifVue;
	
	private EnnemiBasiqueVue ennemiBasiqueVue;
	
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
			heroVue.getHero().allerEnHaut(); 
			break;
		case DOWN:  
			
			System.out.println("bas");
			heroVue.getHero().allerEnBas();
			break;
		case LEFT: 
			System.out.println("gauche");
			heroVue.getHero().allerAGauche();
			break;
		case RIGHT:
			System.out.println("droite");
			heroVue.getHero().allerADroite();
			break;
		case P:
			if (gameLoop.getStatus()==Status.PAUSED) {
				System.out.println("UNPAUSE");
				gameLoop.play();
			}
			else {
				System.out.println("PAUSE");
				gameLoop.pause();
			}
			break;
		
		case SPACE:
			
			heroVue.getHero().attaquer();
			break;
		}
			
			
	}

	public void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);


		KeyFrame kf = new KeyFrame(

				// on d�finit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017), 
				// on d�finit ce qui se passe � chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if(temps%60==0){
						
						env.unTour();
						
					}
					else if (temps%5==0){
						//System.out.println("un tour");

					}
					temps++;
				})
				);

		gameLoop.getKeyFrames().add(kf);
	}

	
	public void lancement() {
		terrainVue = new TerrainVue(panneauDeTuiles, env.getTerrain());
		terrainVue.chargerTerrain();
		
		//hero
		Hero hero = new Hero(160,112,env);
		env.ajouterHero(hero);
		heroVue = new HeroVue(env.getHero(), pane);
		
		
		//ennemi
		Ennemi ennemi = new EnnemiBasique(0,0,env);
		env.ajouterPerso(ennemi);
		
		ennemiBasiqueVue = new EnnemiBasiqueVue(ennemi,pane);
		
		this.env.getPersonnages().addListener(new MonObservateurEnnemi(this.pane));
		
		//ennemiExplosif
		Ennemi ennemi2 = new EnnemiExplosif(16,16,env);
		env.ajouterPerso(ennemi2);
		
		ennemiExplosifVue = new EnnemiExplosifVue(ennemi2,pane);
	}
	
	
}
