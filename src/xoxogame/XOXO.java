package xoxogame;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;

public class XOXO extends Application{
	
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Game Caro");
		showMainView();
	}
	
	private void showMainView() throws IOException {
		Parent root = FXMLLoader.load(XOXO.class.getResource("/xoxogame/GameView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
