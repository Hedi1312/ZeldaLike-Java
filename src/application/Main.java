package src.application;
	



import src.application.controleur.Controleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader  = new FXMLLoader(getClass().getResource("vue/vue.fxml"));
			Scene scene = new Scene(loader.load());
			
			 Controleur controller = loader.getController();
			 
			
			 scene.setOnKeyPressed(keyAction -> controller.deplacement(keyAction));
			 
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}