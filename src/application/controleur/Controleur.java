package src.application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import src.application.modele.Environnement;
import src.application.modele.Terrain;
import src.application.modele.personnage.ArmeActuelleException;
import src.application.modele.personnage.Boss;
import src.application.modele.personnage.Ennemi;
import src.application.modele.personnage.EnnemiBasique;
import src.application.modele.personnage.EnnemiExplosif;
import src.application.modele.personnage.Hero;

import src.application.modele.personnage.Personnage;
import src.application.modele.ramassable.ClefRamassable;
import src.application.modele.ramassable.ExtincteurRamassable;
import src.application.modele.ramassable.Gilet;
import src.application.modele.ramassable.GrenadeRamassable;
import src.application.modele.ramassable.PistoletRamassable;
import src.application.modele.ramassable.Ramassable;
import src.application.vue.EnnemiBasiqueVue;
import src.application.vue.EnnemiExplosifVue;
import src.application.vue.HeroVue;
import src.application.vue.TerrainVue;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
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
	@FXML
	private TilePane listeArme;
	@FXML
	private TilePane listeObjet;
	
	@FXML
    private Label labelErreur;
	private Timeline gameLoop;
	private int temps;
	
	private TerrainVue terrainVue;
	
	private HeroVue heroVue;


	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
		lancement();

		
	}
	
	public void deplacement(KeyEvent event){

		switch (event.getCode()) {
			case UP:    
				//System.out.println("haut");
				env.getHero().allerEnHaut(); 
				break;
			case DOWN:  				
				//System.out.println("bas");
				env.getHero().allerEnBas();
				break;
			case LEFT: 
				//System.out.println("gauche");
				env.getHero().allerAGauche();
				break;
			case RIGHT:
				//System.out.println("droite");
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
				
			case F:
				
				env.getHero().interagir();
				break;
			
			case DIGIT1: //ajouter case A
				
			try {
				env.getHero().setArmeActuelle(0);
			} catch (ArmeActuelleException e) {
				
				labelErreur.setText("Vous n'avez pas d'arme"); 
			}
				break;
			
			case DIGIT2:
				
			try {
				env.getHero().setArmeActuelle(1);
			} catch (ArmeActuelleException e) {
			
				labelErreur.setText("Pas de deuxième arme"); 

			}
				break;
			case DIGIT3:
				
			try {
				env.getHero().setArmeActuelle(2);
			} catch (ArmeActuelleException e) {
				labelErreur.setText("Pas de troisième arme"); 
			}
				break;
			
		}
		
	}
	
	public void released(KeyEvent keyEvent) {
		switch (keyEvent.getCode()) {
			case SPACE:    		
				env.getHero().releasedLock();
				break;
		}
	}
	
	public void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);


		KeyFrame kf = new KeyFrame(

				// on dï¿½finit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017), 
				// on dï¿½finit ce qui se passe ï¿½ chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if(temps%60==0){
						labelErreur.setText(null);
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
		
		this.panneauDeTuiles.getChildren();
		
		
		this.env = new Environnement();
		
		this.panneauDeTuiles.setPrefColumns(env.getTerrain().getWidth()*16);
		this.panneauDeTuiles.setPrefSize(env.getTerrain().getWidth()*16, env.getTerrain().getHeight()*16);
		
		this.env.getEnnemis().addListener(new MonObservateurEnnemi(this.pane));
		this.env.getProjectile().addListener(new MonObservateurProjectile(this.pane));
		this.env.getRamassables().addListener(new MonObservateurRamassable(this.pane));
		//terrain
		terrainVue = new TerrainVue(panneauDeTuiles, env.getTerrain());
		
		Ennemi ennemi = new EnnemiBasique(20*16,10*16,env);
		env.ajouterPerso(ennemi);
		
		
		//hero
		this.env.getHero().getArmes().addListener(new MonObservateurArme(listeArme));
		this.env.getHero().getObjets().addListener(new MonObservateurObjet(listeObjet));
		heroVue = new HeroVue(env.getHero(), pane);
		Ramassable extincteur =new ExtincteurRamassable(15*16, 3*16, env);
		env.ajouterRamassable(extincteur);
		
		
		env.getTourProperty().addListener((obs,old,nouv)->{
			if(env.getTerrain().getMapActuelle()==env.getTerrain().getMap(0)) {
				if(env.getHero().getX()==0*16) {
					panneauDeTuiles.getChildren().clear();
					env.killAll();
					env.getHero().setX(29*16);
					env.getHero().setY(7*16);
					terrainVue.chargerTerrain(1);
					env.initialiserMap();
					
				}
			}
			else if(env.getTerrain().getMapActuelle()==env.getTerrain().getMap(1)) {
				if(env.getHero().getX()==5*16 && env.getHero().getY()==11*16) {
					panneauDeTuiles.getChildren().clear();
					env.killAll();
					env.getHero().setX(14*16);
					env.getHero().setY(18*16);
					terrainVue.chargerTerrain(2);
					env.initialiserMap();
					
				}
			}
				
		}
		);
		
		
		initAnimation();
		gameLoop.play();
		

		this.env.getHero().getPvProperty().addListener((obs,old,nouv)->{
			if(nouv.doubleValue()<=0) {
				Image imgGameOver = new Image("src/images/gameOver.png");
				ImageView gameOver = new ImageView(imgGameOver);
				gameLoop.stop();
				pane.getChildren().add(gameOver);
				this.pane.getChildren().remove(this.pane.lookup("#"+this.env.getHero().getId()));
				Button restart = new Button("Restart");
				restart.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	panneauDeTuiles.getChildren().clear();
				    	env.killAll();
				    	
				    	pane.getChildren().remove(gameOver);
				    	listeArme.getChildren().clear();
				    	listeObjet.getChildren().clear();
				        lancement();
				        restart.setVisible(false);
				        restart.setManaged(false);
				    }
				});
				pane.getChildren().add(restart);
			}
		});
		
	}
	
	
}
