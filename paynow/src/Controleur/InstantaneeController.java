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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

/**
 * FXML Controller class
 *
 * @author sadjang
 */
public class InstantaneeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TableView <Transactions> tabletransaction;
    ObservableList <Transactions>Transacti=FXCollections.observableArrayList(); 
    List<Transactions> Tabletransations=new ArrayList<>(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //tabInformation.
        // name colums
        TableColumn id=new TableColumn<>("ID") ;
        TableColumn operateur=new TableColumn<>("Operateur") ;
        TableColumn Expediteur=new TableColumn<>("Noms Expediteur") ;
        TableColumn immee=new TableColumn<>("Imee Telephone") ;
        TableColumn CniEXpediteur=new TableColumn<>("Cni Expediteur") ;
        TableColumn MarquePho=new TableColumn<>("Marque Telephone") ;
        TableColumn NomRec=new TableColumn<>("Nom Recepteur") ;
        TableColumn NumRec=new TableColumn<>("Numero Recepteur") ;
        TableColumn Montant=new TableColumn<>("Montant") ;
        TableColumn NumExp=new TableColumn<>("NumExpediteur") ;
        TableColumn date=new TableColumn<>("Date Expedition") ;
         TableColumn CniRecepteur=new TableColumn<>("Cni Recepteur") ;
       // tabletransaction.getColumns().addAll(id,operateur);
        tabletransaction.getColumns().addAll(id,operateur,date,Montant,Expediteur,CniEXpediteur,NumExp,MarquePho,immee,NomRec,CniRecepteur,NumRec);
       Date dates=new Date(2018,01,05,06,53,50);
       // tabletransaction.getColumns().addAll(id,"operateu","Expediteur","immee","CniEXpediteur","MarquePho","NomRec",250,"NumExp",date);
////////////
        IDinformations dao=new Dinformations();
        IMinformation metier=new Minformation(dao);
        List<Informations> informations=metier.findAll();
        //
      /*  Informations information=null;
         Iterator iter = informations.iterator();
        while ( iter.hasNext()) {
           information =(Informations)iter.next();
          //  Tabdroit tabdroi=new Tabdroit(tabdroit.getId(),tabdroit.getDesignation().trim());
          Transactions transaction= new Transactions(information.getId(),information.getOperateur().getDesignation().trim(), information.getNomexpediteur().trim(), information.getImeetelephone().trim(), information.getCniexpediteur().trim(), information.getMarquetelephone().trim(), information.getNomrecepteur().trim(), information.getNumerorecepteur().trim(), information.getMontantexpedition(),information.getNumeroexpediteur().trim(),information.getDateexpedition());
           //Transactions transaction= new Transactions(information.getId(),"information.getOperateur().getDesignation().trim()", "information.getNomexpediteur().trim()", "information.getImeetelephone().trim()", "information.getCniexpediteur().trim()", "information.getMarquetelephone().trim()", "information.getNomrecepteur().trim()", "information.getNumerorecepteur().trim()", 250,"information.getNumeroexpediteur().trim()",dates);
        
          System.out.println(transaction.getNomOperateur());
            
           // Tabletransations.add(transaction);
            tabletransaction.getItems().add(transaction);
          }  */
        id.setCellValueFactory(
                 new PropertyValueFactory<Transactions,Integer>("id"));
        operateur.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("NomOperateur"));
        Expediteur.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("nomexpediteur"));
        immee.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("imeetelephone"));
        CniEXpediteur.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("marquetelephone"));
        MarquePho.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("nomrecepteur"));
        NomRec.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("numerorecepteur"));
        NumRec.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("numerorecepteur"));
        Montant.setCellValueFactory(
                 new PropertyValueFactory<Transactions,Integer>("montantexpetion"));
        NumExp.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("numeroexpediteur"));
         date.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("dateexpedition"));
         CniRecepteur.setCellValueFactory(
                 new PropertyValueFactory<Transactions,String>("cnirecepteur"));
         
        //
        Thread h=new Thread(new DonnerReader ());
        h.start();
      // startScheduledExecutorService();
    }   
    
    
  /*  private void startScheduledExecutorService(){
        final ScheduledExecutorService scheduler 
            = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(
                new Runnable(){
                      
                    int va = 1;
                      
                    @Override
                    public void run() {
                       
                        
                           //if(va<30){  
                            Platform.runLater(new Runnable(){
                                @Override
                                public void run() {
                                    /////////////////////////////////////////////////
                                     IDinformations dao=new Dinformations();
                    IMinformation metier=new Minformation(dao);
                    List<Informations> informations=metier.findAll();
        //
        System.out.println(informations.size());
                    Informations information=null;
                    Iterator iter = informations.iterator();
                    
                    while ( iter.hasNext()) {
                      information =(Informations)iter.next();
                     //  Tabdroit tabdroi=new Tabdroit(tabdroit.getId(),tabdroit.getDesignation().trim());
                       Transactions transaction= new Transactions(information.getId(),information.getOperateur().getDesignation().trim(), information.getNomexpediteur().trim(), information.getImeetelephone().trim(), information.getCniexpediteur().trim(), information.getMarquetelephone().trim(), information.getNomrecepteur().trim(), information.getNumerorecepteur().trim(), information.getMontantexpedition(),information.getNumeroexpediteur().trim(),information.getDateexpedition());
                      //Transactions transaction= new Transactions(information.getId(),"information.getOperateur().getDesignation().trim()", "information.getNomexpediteur().trim()", "information.getImeetelephone().trim()", "information.getCniexpediteur().trim()", "information.getMarquetelephone().trim()", "information.getNomrecepteur().trim()", "information.getNumerorecepteur().trim()", 250,"information.getNumeroexpediteur().trim()",dates);
        
                       System.out.println(transaction.getNomOperateur());
            
                       // Tabletransations.add(transaction);
                     tabletransaction.getItems().add(transaction);
                    }  
                   
                  
                   
                                    
                                    
                                    /////////////////////
                                    
                                }
                            });
                            va++;
                           //}else{
                             // va=0; 
                             //series.setData(null);
                             // series1
                             // series2
                          // }
                                 
                    }
                }, 
                1, 
                1, 
                TimeUnit.SECONDS);      

        
        
        
        
        
    }
    
    
    */
    
    
    
    ////////////////////////////////////////////
    class DonnerReader implements Runnable{

        @Override
        public void run() {
           try{
               int va=1;
               while(true){
                   
                    IDinformations dao=new Dinformations();
                    IMinformation metier=new Minformation(dao);
                    List<Informations> informations=metier.findAll();
        //
        
        if(informations.size()>0){
           
       
                    Informations information=null;
                    Iterator iter = informations.iterator();
                    
                    while ( iter.hasNext()) {
                      information =(Informations)iter.next();
                     //  Tabdroit tabdroi=new Tabdroit(tabdroit.getId(),tabdroit.getDesignation().trim());
                       Transactions transaction= new Transactions(information.getId(),information.getOperateur().getDesignation().trim(), information.getNomexpediteur().trim(), information.getImeetelephone().trim(), information.getCniexpediteur().trim(), information.getMarquetelephone().trim(), information.getNomrecepteur().trim(), information.getNumerorecepteur().trim(), information.getMontantexpedition(),information.getNumeroexpediteur().trim(),information.getDateexpedition(),information.getCnirecepteur());
                      //Transactions transaction= new Transactions(information.getId(),"information.getOperateur().getDesignation().trim()", "information.getNomexpediteur().trim()", "information.getImeetelephone().trim()", "information.getCniexpediteur().trim()", "information.getMarquetelephone().trim()", "information.getNomrecepteur().trim()", "information.getNumerorecepteur().trim()", 250,"information.getNumeroexpediteur().trim()",dates);
        
                     //  System.out.println(transaction.getNomOperateur());
            
                       // Tabletransations.add(transaction);
                       Transacti.add(transaction);
                    // tabletransaction.getItems().add(transaction);
                   
                    System.out.println("je suis dedant la");
                    }  
                   
                    
                    
                    Comparator<Transactions> comparator = Comparator.comparingInt(Transactions::getId); 
                    comparator = comparator.reversed();
                    FXCollections.sort(Transacti, comparator);
                  
                   tabletransaction.setItems(Transacti);
                }
                   
               Thread.sleep(1000);
             va++;
           }
           }catch(Exception ex){
               Logger.getLogger(TemperaturActivityController.class.getName()).log(Level.FATAL, ex);
           }
        }
        
    }
    
    
    ///////////////////////////////////////
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
