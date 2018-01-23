/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author sadjang
 */
public class AreaActivityController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AreaChart<?, ?> AreaStat;
     XYChart.Series series,series1, series2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        series=new XYChart.Series<>();
        series.setName("ORANGE");
        series1=new XYChart.Series<>();
        series1.setName("MTN");
        series2=new XYChart.Series<>();
        series2.setName("NEXTEL");
        AreaStat.getData().addAll(series,series1,series2);
         startScheduledExecutorService();
    }    
    
    
    
    //////////////////////////////////////
     private void startScheduledExecutorService(){
         ObservableList<XYChart.Data<String, Number>> seriesData = FXCollections.observableArrayList();
         ObservableList<XYChart.Data<String, Number>> seriesData1 = FXCollections.observableArrayList();
       ObservableList<XYChart.Data<String, Number>> seriesData2 = FXCollections.observableArrayList();
                              
        final ScheduledExecutorService scheduler 
            = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(
                new Runnable(){
                      
                    int va = 0;
                      
                    @Override
                    public void run() {
                        System.out.println("je passe"+va);
                        Double line=Math.random() * 100;
                        Double line1=Math.random() * 100;
                        Double line2=Math.random() * 100;
                       
                           
                            Platform.runLater(new Runnable(){
                                @Override
                                public void run() {
                                   
                                       
                                        if ((va % 25) == 0){
                                           
                                            
                                            seriesData.clear();
                                            seriesData1.clear();
                                            seriesData2.clear();
                                        }
                                     seriesData.add(new XYChart.Data<>(va+"", line));
                                     seriesData1.add(new XYChart.Data<>(va+"", line1));
                                     seriesData2.add(new XYChart.Data<>(va+"", line2));
                                     series.setData(seriesData);
                                     series1.setData(seriesData1);
                                     series2.setData(seriesData2);
                                    
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
    
    
    
    
    
    
    
    
    
    
    
}
