/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paynow;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author sadjang
 */
public class Login extends Application {
    private Stage primaryStage;
    private BorderPane mainLayout;
    @Override
    public void start(Stage stage) throws Exception {
       // stage.setFullScreen(true);
       initialogo(stage);
        this.primaryStage=stage;
        
         showLogin();
        
    }
    // login
    private void showLogin() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
      private void initialogo(Stage stage) {
         ///////////////////////////
                        // ajout de l'icone
                        stage.getIcons().setAll(new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()));

                        ///////////////////////////////
                   }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
