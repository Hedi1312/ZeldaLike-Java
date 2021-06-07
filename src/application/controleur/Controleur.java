package src.application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import src.application.modele.Ennemi;
import src.application.modele.EnnemiBasique;
import src.application.modele.EnnemiExplosif;
import src.application.modele.Environnement;
import src.application.modele.Hero;
import src.application.modele.Personnage;
import src.application.modele.PistoletRamassable;
import src.application.modele.Ramassable;
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
		
		this.env.getBalles().addListener(new MonObservateurBalle(pane));
		this.env.getRamassables().addListener(new MonObservateurRamassable(this.pane));
		lancement();
		
		initAnimation();
		gameLoop.play();
	}
	
	public void deplacement(KeyEvent event){

		switch (event.getCode()) {
			case UP:    
				System.out.println("haut");
				env.getHero().allerEnHaut(); 
				break;
			case DOWN:  
				
				System.out.println("bas");
				env.getHero().allerEnBas();
				break;
			case LEFT: 
				System.out.println("gauche");
				env.getHero().allerAGauche();
				break;
			case RIGHT:
				System.out.println("droite");
				env.getHero().allerADroite();
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
				
				env.getHero().attaquer();
				break;
				
			
			case DIGIT1:
				System.out.println("Je prends la batte");
				env.getHero().setArmeActuelle(0);
				break;
			
			case DIGIT2:
				System.out.println("Je prends le pistolet");
				env.getHero().setArmeActuelle(1);
				break;
			case DIGIT3:
				System.out.println("3");
				env.getHero().setArmeActuelle(2);
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
						env.unTourRapideMaisPasTrop();
					}
					else if (temps%1==0){
						//System.out.println("un tour");
						env.unTourRapide();
					}
					temps++;
				})
				);

		gameLoop.getKeyFrames().add(kf);
	}

	
	public void lancement() {
		terrainVue = new TerrainVue(panneauDeTuiles, env.getTerrain());
		terrainVue.chargerTerrain();
		
		this.env.getPersonnages().addListener(new MonObservateurEnnemi(this.pane));
		
		
		//hero
		Hero hero = new Hero(160,112,env);
		env.ajouterHero(hero);
		heroVue = new HeroVue(env.getHero(), pane);
		
		
		//ennemi
		Ennemi ennemi = new EnnemiBasique(0,0,env);
		env.ajouterPerso(ennemi);
		
		
		//ennemiExplosif
		Ennemi ennemi2 = new EnnemiExplosif(16,16,env);
		env.ajouterPerso(ennemi2);
		
		
	}
	
	
}
