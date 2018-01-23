/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Classe.Informations;
import ClasseUi.Transactions;
import DAO.Dinformations;
import DAO.IDinformations;
import Metier.IMinformation;
import Metier.Minformation;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author sadjang
 */
public class RequetActiviteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Transactions> tablRequette;
    ObservableList <Transactions>Transactions=FXCollections.observableArrayList(); 
    @FXML
    private Label labnom;

    @FXML
    private Label labprenom;

    @FXML
    private Label labTel;

    @FXML
    private TextField txtnomExp;

    @FXML
    private TextField  txtnomrecpteur;

    @FXML
    private TextField txtnumtelpExp;

    @FXML
    private TextField txtNumRecp;

    @FXML
    private Button btRechercher;
     @FXML
    private DatePicker dateExpedition;
    
    
    String[] tabRequette=new String[5];
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tabRequette[0]="";
        tabRequette[1]="";
        tabRequette[2]="";
        tabRequette[3]="";
        
        dateExpedition.setValue(LocalDate.now());
        tabRequette[4]=dateExpedition.getEditor().getText();
       initable(tabRequette);
       
    }    
    public void cleartable( ){
        
        for ( int i = 0; i<tablRequette.getItems().size(); i++) {
           //tablRequette.getItems().clear();
           //Transactions.remove(i);
           Transactions.removeAll(Transactions);
           System.out.println("je clear");
        }
    }
    @FXML
    public void search(){
        tabRequette[0]=txtnomExp.getText();
        tabRequette[1]=txtnumtelpExp.getText();
        tabRequette[2]=txtnomrecpteur.getText();
        tabRequette[3]=txtNumRecp.getText();
        tabRequette[4]=dateExpedition.getEditor().getText();
        
       // LocalDate localDate = dateExpedition.getValue();
      /* ins Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(tant);
        System.out.println(localDate + "\n" + instant + "\n" + date);*/
        cleartable( );
        searcheTable(tabRequette);
    }

    private void initable(String[] tabRequette) {
        //tabInformation.
        // name colums
       //TableColumn id=new TableColumn<>("ID") ;
        TableColumn operateur=new TableColumn<>("Operateur") ;
        //operateur.setMaxWidth(100);
        TableColumn Expediteur=new TableColumn<>("Noms Expediteur") ;
       // Expediteur.setMaxWidth(100);
        //TableColumn immee=new TableColumn<>("Imee Telephone") ;
        // immee.setMaxWidth(100);
        TableColumn CniEXpediteur=new TableColumn<>("Cni Expediteur") ;
         //CniEXpediteur.setMaxWidth(100);
     //   TableColumn MarquePho=new TableColumn<>("Marque Telephone") ;
        // MarquePho.setMaxWidth(100);
        TableColumn NomRec=new TableColumn<>("Nom Recepteur") ;
        // NomRec.setMaxWidth(100);
        TableColumn NumRec=new TableColumn<>("Numero Recepteur") ;
        // NumRec.setMaxWidth(100);
        TableColumn Montant=new TableColumn<>("Montant") ;
       //  Montant.setMaxWidth(100);
        TableColumn NumExp=new TableColumn<>("NumExpediteur") ;
        // NumExp.setMaxWidth(100);
        TableColumn date=new TableColumn<>("Date Expedition") ;
        // date.setMaxWidth(100);
        tablRequette.getColumns().addAll(operateur,Montant,date,NumExp,NumRec,Expediteur,NomRec);
        IDinformations dao=new Dinformations();
        IMinformation metier=new Minformation(dao);
       
        List<Informations> informations=metier.findAllbyTable(tabRequette);
        
        Informations information=null;
         Iterator iter = informations.iterator();
        while ( iter.hasNext()) {
           information =(Informations)iter.next();
          //  Tabdroit tabdroi=new Tabdroit(tabdroit.getId(),tabdroit.getDesignation().trim());
          Transactions transaction= new Transactions(information.getId(),information.getOperateur().getDesignation().trim(), information.getNomexpediteur().trim(), information.getImeetelephone().trim(), information.getCniexpediteur().trim(), information.getMarquetelephone().trim(), information.getNomrecepteur().trim(), information.getNumerorecepteur().trim(), information.getMontantexpedition(),information.getNumeroexpediteur().trim(),information.getDateexpedition(),information.getCnirecepteur());
           //Transactions transaction= new Transactions(information.getId(),"information.getOperateur().getDesignation().trim()", "information.getNomexpediteur().trim()", "information.getImeetelephone().trim()", "information.getCniexpediteur().trim()", "information.getMarquetelephone().trim()", "information.getNomrecepteur().trim()", "information.getNumerorecepteur().trim()", 250,"information.getNumeroexpediteur().trim()",dates);
        
          System.out.println(transaction.getNomOperateur());
            
           // Tabletransations.add(transaction);
          Transactions.add(transaction);
         
          }
        tablRequette.setItems(Transactions);
        
        /*id.setCellValueFactory(
                 new PropertyValueFactory<Transactions,Integer>("id"));*/
        operateur.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("NomOperateur"));
        Expediteur.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("nomexpediteur"));
       /* immee.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("imeetelephone"));*/
        CniEXpediteur.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("marquetelephone"));
      /*  MarquePho.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("nomrecepteur"));*/
        NomRec.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("nomrecepteur"));
        NumRec.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("numerorecepteur"));
        Montant.setCellValueFactory(
                 new PropertyValueFactory<Transactions,Integer>("montantexpetion"));
        NumExp.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("numeroexpediteur"));
         date.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("dateexpedition"));
         
         
    
    }

    private void searcheTable(String[] tabRequette) {
        IDinformations dao=new Dinformations();
        IMinformation metier=new Minformation(dao);
        List<Informations> informations=metier.findAllbyTable(tabRequette);
        
        Informations information=null;
         Iterator iter = informations.iterator();
        while ( iter.hasNext()) {
           information =(Informations)iter.next();
          //  Tabdroit tabdroi=new Tabdroit(tabdroit.getId(),tabdroit.getDesignation().trim());
          Transactions transaction= new Transactions(information.getId(),information.getOperateur().getDesignation().trim(), information.getNomexpediteur().trim(), information.getImeetelephone().trim(), information.getCniexpediteur().trim(), information.getMarquetelephone().trim(), information.getNomrecepteur().trim(), information.getNumerorecepteur().trim(), information.getMontantexpedition(),information.getNumeroexpediteur().trim(),information.getDateexpedition(),information.getCnirecepteur());
           //Transactions transaction= new Transactions(information.getId(),"information.getOperateur().getDesignation().trim()", "information.getNomexpediteur().trim()", "information.getImeetelephone().trim()", "information.getCniexpediteur().trim()", "information.getMarquetelephone().trim()", "information.getNomrecepteur().trim()", "information.getNumerorecepteur().trim()", 250,"information.getNumeroexpediteur().trim()",dates);
        
          System.out.println(transaction.getNomOperateur());
            
           // Tabletransations.add(transaction);
          Transactions.add(transaction);
         
          }
    }
    
}
