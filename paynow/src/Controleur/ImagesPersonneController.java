/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Classe.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author sadjang
 */
public class ImagesPersonneController extends AnchorPane implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Client client;
    @FXML
    private VBox personnecard;

    @FXML
    private ImageView image;

    @FXML
    private Label nom;

    @FXML
    private Label prenom;

    @FXML
    private Label telph;

    @FXML
    private Label numcni;
    private String fxmlFile = "ImagesPersonne.fxml";

    public ImagesPersonneController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/paynow/" + fxmlFile));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void SetClient(String tring) {
        this.client = client;
        this.nom.setText(client.getNom());
        this.prenom.setText(client.getPrenom());
    }

    public void initController() {
        // TODO
    }

}
