/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Classe.Users;
import DAO.Dusers;
import DAO.IDusers;
import Metier.IMetierUsers;
import Metier.MetierUsers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import paynow.Login;

/**
 *
 * @author sadjang
 */
public class LoginController implements Initializable {
    
     @FXML
     private Label labmessage;
     @FXML
     private TextField txtname;
     @FXML
     private PasswordField txtpassword;
     //private Login main;
     @FXML
     private void btnconnexion(ActionEvent event) throws IOException{
        IDusers dao=new Dusers();
        IMetierUsers metier=new MetierUsers(dao);
        if(!txtname.getText().isEmpty()&&!txtpassword.getText().isEmpty()){
            
       
        Users user=metier.authentification(txtname.getText(), txtpassword.getText(), 1); 
        if(user!=null){
           ((Node) (event.getSource())).getScene().getWindow().hide();
           Parent root = FXMLLoader.load(getClass().getResource("/paynow/MainView1.fxml"));
           Stage stage=new Stage();
           Scene scene=new Scene(root);
           stage.setScene(scene);
           stage.setTitle("PAYNOW");
           Screen screen=Screen.getPrimary();
           Rectangle2D bound=screen.getVisualBounds();
           stage.setX(bound.getMinX());
           stage.setY(bound.getMinY());
           stage.setWidth(bound.getWidth());
           stage.setHeight(bound.getHeight());
           stage.setMaximized(true);
           //stage.setFullScreen(true);
           initialogo(stage);
           
           stage.show();
        }else{
             labmessage.setText("connexion lost");
         }
          }else{
            labmessage.setText("les champs sont vide !");
            
        }
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
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
