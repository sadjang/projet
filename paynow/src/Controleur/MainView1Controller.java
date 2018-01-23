/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author sadjang
 */
public class MainView1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ListView<String> listgestUser;
    @FXML
    ListView<String>  listActivit;
    @FXML
    TabPane tabcenter;
    @FXML
    TabPane tabotom;
    @FXML
    TitledPane  gestionUser;
    @FXML
    TitledPane  gestStat;
    @FXML
    TitledPane gestActivi;
    @FXML
    private VBox tabRigth;
    @FXML
    Tab Instantanee;
    
    @FXML
    MenuBar menubar;
    
    private Map<String,Tab>openTabs=new HashMap<>();
    private Map<String,Node>openVBoxs=new HashMap<>();
    MenuItem showActivi;
    CheckMenuItem showLines;
    CheckMenuItem showHorizont;
    CheckMenuItem showTemperature;
    CheckMenuItem showAnimbarchart;
    CheckMenuItem  showAnimScatterchar;
    CheckMenuItem  showAnimArea;
    @FXML
    private SplitPane Splitpane2;
     @FXML
    private SplitPane Splitpane1;
    @FXML
    private SplitPane splipane3;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      /*  Splitpane1.setDividerPositions(1f, 0.1f);
        Splitpane2.setDividerPositions(0);
         splipane3.setDividerPositions(1);*/
         /* Splitpane2.setPrefSize(20, 200);
        */
     

       // Splitpane2.setPrefSize(200, 20);
       // splipane3.setPrefSize(200, 20);
        
        // TODO 
        initMenuBar();
        if(getdroit()==true){
          openTab("RequetActivite.fxml",tabcenter,"Espace Requete");
        }
       if(getdroit()==true){
          openTab("Instantanee.fxml",tabotom,"Activité");
        }
       if(getdroit()==true){
          openTab("HorizontalStat.fxml",tabotom,"Horizont Activité");
        }
       if(getdroit()==true){
          openTab("TemperaturActivity.fxml",tabotom,"Temperature Activité");
        }
       if(getdroit()==true){
          openTab("AnnimationBarchart.fxml",tabotom,"Statist Instantanée");
        }
       if(getdroit()==true){
          openTabV("Scatterchar.fxml",tabRigth,"Statist Scatter");
        }
       
       if(getdroit()==true){
          openTabV("AreaActivity.fxml",tabRigth,"Statist Area");
        }
        loadlistview();
        selectedListe(listgestUser);
        selectedListe(listActivit);
        choseLanguage("fr");
        
    }    
    
    public void initMenuBar(){
        
         if(getdroit()==true){
             Menu filemenu=new Menu("File");
             menubar.getMenus().addAll(filemenu);
        }
         if(getdroit()==true){
             Menu filemenu=new Menu("Edit");
             menubar.getMenus().addAll(filemenu);
         }
         /////////////////////////////////////////
         if(getdroit()==true){
             Menu filemenu=new Menu("_View");
             filemenu.getItems().add(new SeparatorMenuItem());
             if(getdroit()==true){
                showActivi= new MenuItem("Show Activiti of reseau");
                filemenu.getItems().add(showActivi);
              }
             if(getdroit()==true){
                showLines= new CheckMenuItem("Show All Activity of reseau");
                showLines.setSelected(true);
                filemenu.getItems().add(showLines);
              }
             if(getdroit()==true){
                showHorizont= new CheckMenuItem("Show Horizont Activity of reseau");
                showHorizont.setSelected(true);
                filemenu.getItems().add(showHorizont);
              }
             if(getdroit()==true){
                showTemperature= new CheckMenuItem("Temperature Activité");
                showTemperature.setSelected(true);
                filemenu.getItems().add(showTemperature);
              }
             if(getdroit()==true){
                showAnimbarchart= new CheckMenuItem("Statist Instantanée");
                showAnimbarchart.setSelected(true);
                filemenu.getItems().add(showAnimbarchart);
              }
            if(getdroit()==true){
                showAnimScatterchar= new CheckMenuItem("Statist Scatter");
                showAnimScatterchar.setSelected(true);
                filemenu.getItems().add(showAnimScatterchar);
              }
             if(getdroit()==true){
                showAnimArea= new CheckMenuItem("Statist Area");
                showAnimArea.setSelected(true);
                filemenu.getItems().add(showAnimArea);
              }
            
             
             menubar.getMenus().addAll(filemenu);
        }
         /////////////////////////////////////////////////
        if(getdroit()==true){
             Menu filemenu=new Menu("Help");
             menubar.getMenus().addAll(filemenu);
        }
       
        //showActivi.setOnAction(e->System.out.println("je sors"));
        showLines.setOnAction(e->{
            if(showLines.isSelected()){
               //System.out.println("je suis activé");
               openTab("Instantanee.fxml",tabotom,"Activité");
            }else{
               tabotom.getTabs().remove(openTabs.get("Instantanee.fxml"));
               openTabs.remove("Instantanee.fxml");
              // System.out.println("je ne suis pas activé ");
            }
         });
        
        showHorizont.setOnAction(e->{
            if(showHorizont.isSelected()){
               //System.out.println("je suis activé");
               openTab("HorizontalStat.fxml",tabotom,"Horizont Activité");
            }else{
               tabotom.getTabs().remove(openTabs.get("HorizontalStat.fxml"));
               openTabs.remove("HorizontalStat.fxml");
              // System.out.println("je ne suis pas activé ");
            }
         });
        showTemperature.setOnAction(e->{
            if(showTemperature.isSelected()){
               //System.out.println("je suis activé");
               openTab("TemperaturActivity.fxml",tabotom,"Temperature Activité");
            }else{
               tabotom.getTabs().remove(openTabs.get("TemperaturActivity.fxml"));
               openTabs.remove("TemperaturActivity.fxml");
              // System.out.println("je ne suis pas activé ");
            }
         });
         showAnimbarchart.setOnAction(e->{
            if(showAnimbarchart.isSelected()){
               //System.out.println("je suis activé");
               openTab("AnnimationBarchart.fxml",tabotom,"Statist Instantanée");
            }else{
               tabotom.getTabs().remove(openTabs.get("AnnimationBarchart.fxml"));
               openTabs.remove("AnnimationBarchart.fxml");
              // System.out.println("je ne suis pas activé ");
            }
         });
        /////////////////////////
        //scater
         showAnimScatterchar.setOnAction(e->{
            if(showAnimScatterchar.isSelected()){
               //System.out.println("je suis activé");
               openTabV("Scatterchar.fxml",tabRigth,"Statist Scatter");
            }else{ 
                tabRigth.getChildren().remove(openVBoxs.get("Scatterchar.fxml"));
              //tabotom.getTabs().remove(openVBoxs.get("Scatterchar.fxml"));
              
               openVBoxs.remove("Scatterchar.fxml");
              // System.out.println("je ne suis pas activé ");
            }
         });
         showAnimArea.setOnAction(e->{
            if(showAnimArea.isSelected()){
               //System.out.println("je suis activé");
               openTabV("AreaActivity.fxml",tabRigth,"Statist Area");
            }else{ 
                tabRigth.getChildren().remove(openVBoxs.get("AreaActivity.fxml"));
              
               openVBoxs.remove("AreaActivity.fxml");
              // System.out.println("je ne suis pas activé ");
            }
         });

    }
    public void choseLanguage(String language){
        if(language=="fr"){
            gestionUser.setText("Gestion Des Utilisateurs");
            gestStat.setText("Gestion Des Statistiques");
            gestActivi.setText("Gestion Des Activités");
           
        }
        
    }
    private void loadlistview(){
        ObservableList<String> ols=FXCollections.observableArrayList();
         ObservableList<String> olsact=FXCollections.observableArrayList();
        if(getdroit()==true){
           ols.add("Créer un Utilisateur");
        }
        if(getdroit()==true){
           ols.add("liste Utilisateur");
        }
        if(getdroit()==true){
           ols.add("Liste des Clients");
        }
        if(getdroit()==true){
           ols.add("Créer un Utilisateur");
        }
        if(getdroit()==true){
           ols.add("Créer un Utilisateur");
           
        }
        listgestUser.setItems(ols);
        /////////////////////////////////////////////////////////////
        if(getdroit()==true){
           olsact.add("Requete Sur Activité");
        }
         if(getdroit()==true){
           olsact.add("Suprimer  Activité");
        }
        listActivit.setItems(olsact);
    }

    private boolean getdroit() {
        return true;    
    }
    private void openTabV(String fxmlFile,VBox tabpaneV,String titre){
        if(openVBoxs.containsKey(fxmlFile)){
          // tabpaneV.getSelectionModel().select(openVBoxs.get(fxmlFile));  
            System.out.println("Je suis deja la");
       }else{
            
            try {
                System.out.println("Je ne suis pas encore");
                Node node=(AnchorPane)FXMLLoader.load(getClass().getResource("/paynow/"+fxmlFile));
                tabpaneV.getChildren().add(node);
                openVBoxs.put(fxmlFile, node);
            } catch (IOException ex) {
                Logger.getLogger(MainView1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
    
   private void openTab(String fxmlFile,TabPane tabpane,String titre){
       

       if(openTabs.containsKey(fxmlFile)){
           tabpane.getSelectionModel().select(openTabs.get(fxmlFile));  
            System.out.println("Je suis deja la");
       }else{
            try {
                 System.out.println("Je ne suis pas encore");
                        Node node=(AnchorPane)FXMLLoader.load(getClass().getResource("/paynow/"+fxmlFile));
                        Tab tab=new Tab(titre,node);
                        tab.setId(fxmlFile);
                        tab.setOnCloseRequest(new EventHandler<Event>() {
                            @Override
                            public void handle(Event event) {
                               System.out.println("JE ferme");
                               tabpane.getTabs().remove(tab);
                               System.out.println(tab.getText());
                               openTabs.remove(tab.getId());
                               if(tab.getText().equals("Activité")){
                                showLines.setSelected(false);
                               }
                               if(tab.getText().equals("Horizont Activité")){
                                showHorizont.setSelected(false);
                               }
                               if(tab.getText().equals("Temperature Activité")){
                                showTemperature.setSelected(false);
                               }
                                if(tab.getText().equals("Statist Instantanée")){
                                showAnimbarchart.setSelected(false);
                               }
                               
                            }
                        });
                        tabpane.getTabs().add(tab);
                        openTabs.put(fxmlFile, tab);
                    } catch (IOException ex) {
                        Logger.getLogger(MainView1Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
           
       }
   }
    
   
   private void OpenModal(String fxmlFile,String titre){
        Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/paynow/"+fxmlFile));
                        Stage stage=new Stage();
                        Scene scene=new Scene(root);
                        stage.setTitle(titre);
                        stage.initModality(Modality.APPLICATION_MODAL);
                         initialogo(stage);
                        stage.setScene(scene);
                        stage.showAndWait();
                    } catch (IOException ex) {
                        Logger.getLogger(MainView1Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }       
   }
   private void OpenNoModal(String fxmlFile,String titre){
        Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/paynow/"+fxmlFile));
                        Stage stage=new Stage();
                        Scene scene=new Scene(root);
                        stage.setTitle(titre);
                        stage.initModality(Modality.WINDOW_MODAL);
                        initialogo(stage);
                        stage.setScene(scene);
                       // stage.initOwner(primaryStage);
                        stage.showAndWait();
                    } catch (IOException ex) {
                        Logger.getLogger(MainView1Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }       
   }
     private void selectedListe(ListView<String> list){
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String i=list.getSelectionModel().getSelectedItem();
               
                if(i.equals("liste Utilisateur")){
             
                   openTab("AllOperation.fxml",tabcenter,"Tout");
                   
                }
                if(i.equals("Requete Sur Activité")){
                    System.out.println("je passe ici");
                  // openInitTab("requetActi",tabcenter,"requet",requetActi);
                   openTab("RequetActivite.fxml",tabcenter,"Espace Requete");                   
                }
               
                if(i.equals("Créer un Utilisateur")){
                     OpenModal("CreateUser.fxml", "CreateUser");
                   
                }
                if(i.equals("Liste des Clients")){
                     OpenNoModal("ListClients.fxml", "ListClient");
                   
                }
                
            }
        });
                
                
    }

    private void initialogo(Stage stage) {
         ///////////////////////////
                        stage.getIcons().setAll(new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()), 
                        new Image(getClass().getResource("Images/logo.png").toExternalForm()));

                        ///////////////////////////////
                   }
     
     
     
     
     
     
     
     
     
     
     
     
     
    
    
    
    
}
