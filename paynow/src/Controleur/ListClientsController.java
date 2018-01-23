/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Classe.Client;
import DAO.Dclient;
import DAO.IDclients;
import Metier.IMclient;
import Metier.Mclient;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

/**
 * FXML Controller class
 *
 * @author sadjang
 */
public class ListClientsController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TableView<Client> tablClient;
    ObservableList <Client>Tabclients=FXCollections.observableArrayList(); 
     @FXML
    private GridPane graphGrid;
    String[] tabRequette=new String[4];
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tabRequette[0]="";
        tabRequette[1]="";
        tabRequette[2]="";
        tabRequette[3]="";
       
        
        initable(tabRequette);
    }   
    public Node createClient(String fxmlFile,Client client){
        Node node=null;
        
         try {
              
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/paynow/"+fxmlFile));
             
             ImagesPersonneController controlerClient = loader.getController();
//                                      controlerClient.SetClient(client.getNom());
                                      // controlerClient.initController();
            node = (Node) loader.load();
         } catch (IOException ex) {
             java.util.logging.Logger.getLogger(ListClientsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         return node;
    }
     private void initable(String[] tabRequette) {
        TableColumn id=new TableColumn<>("N°") ;
        TableColumn Cni=new TableColumn<>("Numero Cni") ;
        TableColumn Telphone=new TableColumn<>("Telphone") ;
        TableColumn Nom=new TableColumn<>("Nom") ;
        TableColumn Prenom=new TableColumn<>("Prenom") ;
        TableColumn DateNaissance=new TableColumn<>("Date de Naissance") ;
         TableColumn quartier=new TableColumn<>("Quartier") ;
       
       
        tablClient.getColumns().addAll(id,Cni,Nom,Prenom,Telphone,quartier);
       
      
        id.setCellValueFactory(
                 new PropertyValueFactory<Client,Integer>("id"));
        Cni.setCellValueFactory(
                 new PropertyValueFactory<Client,String>("cni"));
        Telphone.setCellValueFactory(
                 new PropertyValueFactory<Client,String>("telp"));
        Nom.setCellValueFactory(
                 new PropertyValueFactory<Client,String>("nom"));
        Prenom.setCellValueFactory(
                 new PropertyValueFactory<Client,String>("prenom"));
        DateNaissance.setCellValueFactory(
                 new PropertyValueFactory<Client,String>("datenaissance"));
        quartier.setCellValueFactory(
                 new PropertyValueFactory<Client,String>("quartier"));
        //Thread h=new Thread(new DonnerReader ());
       // h.start();
        startScheduledExecutorService();
        
        
    }
     
     
     
    //////////////////////////////////////
     private void startScheduledExecutorService(){
                                
        final ScheduledExecutorService scheduler 
            = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(
                new Runnable(){
                      
                    int va = 0;
                      
                    @Override
                    public void run() {
                        
                           
                            Platform.runLater(() -> {
                                 IDclients dao=new Dclient();
                                 IMclient metier=new Mclient(dao);
                                 List<Client> clients=metier.findAllbyTable(tabRequette);
                                 if(clients.size()>0){
                                     Tabclients.clear();
                                    Client client=null;
                                    Iterator iter = clients.iterator();
                    
                                    while ( iter.hasNext()) {
                                       client =(Client)iter.next();
                                       client.setCni(client.getCni().trim());
                                       client.setNom(client.getNom().trim());
                                       client.setPrenom(client.getPrenom().trim());
                                       client.setTelp(client.getTelp().trim());
                                       if(client.getTelp()!=null)
                                         client.setTelp(client.getTelp().trim());
                                       Tabclients.add(client);
                                       graphGrid.add(createClient("ImagesPersonne.fxml",client), 0, 0);
                                      // graphGrid.add(createClient("ImagesPersonne.fxml",client), 1, 0);
                                    }
                                    
                                    
                                    Comparator<Client> comparator = Comparator.comparingInt(Client::getId); 
                                    comparator = comparator.reversed();
                                    FXCollections.sort(Tabclients, comparator);
                                    tablClient.setItems(Tabclients);
                               }
                   
                        
                            });
                            va++;
                                
                    }
                }, 
                1, 
                1, 
                TimeUnit.SECONDS);        
        
    }
   
    
    ////////////////////////////////////
    
      
     

     
     
     
      ////////////////////////////////////////////
 /*   class DonnerReader implements Runnable{

        @Override
        public void run() {
           try{
               int va=1;
               Label labe=null;
               while(true){
                   
                    IDclients dao=new Dclient();
                    IMclient metier=new Mclient(dao);
                    List<Client> clients=metier.findAllbyTable(tabRequette);
        //
        
        if(clients.size()>0){
        ///   Tabclients.clear();
       
                    Client client=null;
                    Iterator iter = clients.iterator();
                    
                     while ( iter.hasNext()) {
                        client =(Client)iter.next();
                        client.setCni(client.getCni().trim());
                        client.setNom(client.getNom().trim());
                        client.setPrenom(client.getPrenom().trim());
                        client.setTelp(client.getTelp().trim());
                        if(client.getTelp()!=null)
                          client.setTelp(client.getTelp().trim());
                       // client.setQuartier(client.getQuartier().trim());
                    //////    Tabclients.add(client);
                         int l=0,c=0;
                         //labe=new Label("salut");
                      /*    Client clien=new Client();
       client.setNom("achille");
       client.setPrenom("avom");
         graphGrid.add(createClient("ImagesPersonne.fxml",clien), 0, 0);*/
                      //  graphGrid.add(createClient("ImagesPersonne.fxml",client), 0, 0);
                        
       // graphGrid.setConstraints(CreateNode("ImagesPersonne.fxml",client.getNom()+" "+client.getPrenom()), c, l);
     /*   if(c==5){
             
            l++;
            c=0;
        }else{
           c++;
        }
        

                     }
                   
                      
                  /////  Comparator<Client> comparator = Comparator.comparingInt(Client::getId); 
                  /////  comparator = comparator.reversed();
                  /////  FXCollections.sort(Tabclients, comparator);
                  graphGrid.setConstraints(labe, 0, 0);*/
                 /// // tablClient.setItems(Tabclients);
           /*     }
                   
               Thread.sleep(1000);
             va++;
           }
           }catch(Exception ex){
               Logger.getLogger(TemperaturActivityController.class.getName()).log(Level.FATAL, ex);
           }
        }
        
    }
    */
    
    ///////////////////////////////////////
   
     
     
     
     
     
     
     
     
     
     
     
     
    
}
