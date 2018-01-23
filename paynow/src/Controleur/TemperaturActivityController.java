/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.SplitPane;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

/**
 * FXML Controller class
 *
 * @author sadjang
 */
public class TemperaturActivityController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private LineChart<String, Number> lineChart;
     XYChart.Series<String, Number> series,series1, series2;
   /* @FXML
    private SplitPane Splitpane1;
*/
  /*  @FXML
    private SplitPane Splitpane2;*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // Splitpane1.setPrefSize(100, 2000);
        series=new XYChart.Series<>();
        series.setName("ORANGE");
        series1=new XYChart.Series<>();
        series1.setName("MTN");
        series2=new XYChart.Series<>();
        series2.setName("NEXTEL");
       // lineChart.getXAxis().setAutoRanging(true);
       // lineChart.getYAxis().setAutoRanging(true);
        lineChart.getData().add(series);
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
        //Thread th=new Thread(new DonnerReader ());
        //th.start();
        startScheduledExecutorService();
    }    
    
    private void startScheduledExecutorService(){
        ObservableList<XYChart.Data<String, Number>> seriesData = FXCollections.observableArrayList();
         ObservableList<XYChart.Data<String, Number>> seriesData1 = FXCollections.observableArrayList();
       ObservableList<XYChart.Data<String, Number>> seriesData2 = FXCollections.observableArrayList();
      
        final ScheduledExecutorService scheduler 
            = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(
                new Runnable(){
                      
                    int va = 1;
                      
                    @Override
                    public void run() {
                       Double line=Math.random() * 100;
                       Double line1=Math.random() * 100;
                       Double line2=Math.random() * 100;
                      
                           //if(va<30){  
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
    
    
   
    
}
