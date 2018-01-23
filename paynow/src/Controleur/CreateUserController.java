/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import ClasseUi.Droit;
import Classe.Poste;
import Classe.Tabdroit;
import Classe.Users;
import DAO.Dposte;
import DAO.Dtabdroit;
import DAO.Dusers;
import DAO.IDposte;
import DAO.IDtabdroit;
import DAO.IDusers;
import Metier.IMetierUsers;
import Metier.IMposte;
import Metier.IMtabdroit;
import Metier.MetierUsers;
import Metier.Mposte;
import Metier.Mtabdroit;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * FXML Controller class
 *
 * @author sadjang
 */
public class CreateUserController implements Initializable {
   ObservableList<String> poste =FXCollections.observableArrayList();
    
   @FXML
    private TextField txtname;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtnumcni;
    @FXML
    private TextField txtnumTelph;
    @FXML
    private TextField txtquartier;
    @FXML
    private TextField txtpassword;
    @FXML
    private TextField txtTelphone;
    @FXML
    private ChoiceBox checkposte;
    @FXML
    private CheckBox checkActif;
    @FXML
    private Button btnpicture;
    @FXML
    private Button  btcni;
    @FXML
    private ListView ListviCni;
    @FXML
    private ListView ListviPictu;
    private String picturepath;
    private String[] cnirepath= new String[2];
    @FXML
    TableView <Droit> listDroit;
    List <Droit>TableDroit=new ArrayList<>(); 
    List<Poste> postes;
    Users user;
    /*
    @FXML
    TableColumn <droit,Integer> id;
    @FXML
    TableColumn <droit,String> designation;
    @FXML
    TableColumn <droit,String> select;*/
    
    /**
     * Initializes the controller class.
     */
   
 
    
    @FXML
    public void createUser(){
        int Actif=0;
        ObservableList<Droit> tabduty =FXCollections.observableArrayList();
        ObservableList<Tabdroit> tabdutyDele =FXCollections.observableArrayList();
        user=new Users();
        if(checkActif.isSelected()){
          Actif=1;
          
        }
       
              for(Droit duty:TableDroit){
                   if(duty.getCheck().isSelected()){
                       tabdutyDele.add(new Tabdroit(Integer.valueOf(duty.getId()),duty.getDesignation()));  
             
                   }
                   
               }
              
       IDusers dao=new Dusers();
       IMetierUsers metier=new MetierUsers(dao);
       for(Poste poste:postes) {
         if(poste.getDesignation().trim().equals(checkposte.getValue().toString())){
             user.setPoste(poste);
               
          }
       }      
       user.setNom("txtname.getText()");
       user.setPrenom("txtprenom.getText()");
       user.setNcni("txtnumcni.getText()");
       user.setPuctureusers("picturepath");
       user.setQuartier("txtquartier.getText()");
       user.setPasword("txtpassword.getText()");
       user.setPicturecni("cnirepath toString");
       user.setNumtelph("txtTelphone.getText()");
       user.setActif(1);
       Users usercreate=metier.save(user); 
       Stage stage = new Stage();
       stage.close();
    }
    
    private void initializer(){
        Poste post=null;
        IDposte dao=new Dposte();
        IMposte metier=new Mposte(dao);
        postes=metier.findAll(); 
        Iterator iter = postes.iterator();
         while ( iter.hasNext() ) {
            post =(Poste)iter.next();
            poste.add( post.getDesignation().trim());
            //System.out.println(post.getDesignation());
          }  
         checkposte.setValue("Admin");
         checkposte.setItems(poste);
    }
    
     private void initializerT(){
        TableColumn id =new TableColumn("N°");
        TableColumn designation =new TableColumn("Designation");
        TableColumn select =new TableColumn();
        listDroit.getColumns().addAll(id,designation,select);
        Tabdroit tabdroit=null;
        IDtabdroit dao=new Dtabdroit();
        IMtabdroit metier=new Mtabdroit(dao);
        List<Tabdroit> tabdroits=metier.findAll(); 
       // System.out.println(tabdroits.size());
        Iterator iter = tabdroits.iterator();
        while ( iter.hasNext()) {
            tabdroit =(Tabdroit)iter.next();
          //  Tabdroit tabdroi=new Tabdroit(tabdroit.getId(),tabdroit.getDesignation().trim());
            Droit dro= new Droit(String.valueOf(tabdroit.getId()),tabdroit.getDesignation().trim());
            TableDroit.add(dro);
            listDroit.getItems().add(dro);
          }  
         id.setCellValueFactory(
                 new PropertyValueFactory<Droit,String>("id"));
         designation.setCellValueFactory(
                 new PropertyValueFactory<Droit,String>("designation"));
         select.setCellValueFactory(
                 new PropertyValueFactory<Droit,String>("check"));
       // checkposte.setValue("Admin");
        // checkposte.setItems(poste);
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializer();
        initializerT();
          
    }
    public void btcni(ActionEvent event){
         FileChooser fc=new FileChooser();
         fc.getExtensionFilters().addAll(new ExtensionFilter("png","*.png"),
                                         new ExtensionFilter("jpg","*.jpg"));
         List <File> seletedFiles=fc.showOpenMultipleDialog(null);
         
         if(seletedFiles!=null){
             ListviCni.getItems().clear();
             for(int i=0;i<2;i++){
                 if(i<2){
                    ListviCni.getItems().add(seletedFiles.get(i).getName());
                    cnirepath[i]=seletedFiles.get(i).getAbsolutePath();
                    //System.out.println(seletedFiles.get(i).getAbsolutePath());
                 }
             }
         }else{
             System.out.println("file is not valid");
         }
        
    }
    public void btnpicture (ActionEvent event){
         FileChooser fc=new FileChooser();
         fc.getExtensionFilters().addAll(new ExtensionFilter("png","*.png"),
                                         new ExtensionFilter("jpg","*.jpg"));
         File seletedFile=fc.showOpenDialog(null);
         if(seletedFile!=null){
             ListviPictu.getItems().add(seletedFile.getName());
             picturepath=seletedFile.getAbsolutePath();
         }else{
             System.out.println("file is not valid");
         }
        
    }
    
    
    
    
    
    
}
