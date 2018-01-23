/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author sadjang
 */
public class AnnimationBarchartController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private BarChart<String,Double > barchartAnima;
    @FXML
    private PieChart pieChart;
     Double line;
     Double line1;
     Double line2;
     XYChart.Series<String,Double > series;
        XYChart.Series<String,Double > series1;
        XYChart.Series<String,Double > series2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadBarchart();
    }  
   
    private void loadBarchart(){
        barchartAnima.setCategoryGap(0);
        barchartAnima.setBarGap(0);
        barchartAnima.setMaxSize(500, 450);
        int var=1;
        line=Math.random() * 100;
        line1=Math.random() * 100;
        line2=Math.random() * 100;
        series=new XYChart.Series<>();
        series1=new XYChart.Series<>();
        series2=new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("ORANGE",line));
        series1.getData().add(new XYChart.Data<>("MTN",line1));
        series2.getData().add(new XYChart.Data<>("NEXTEL",line2));
        barchartAnima.setAnimated(false);
        barchartAnima.getData().addAll(series,series1,series2);
       // Thread th=new Thread(new DonnerReaders ());
       // th.start();
       
       //////////////////////////////////////////////////
       ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("ORANGE", line),
                        new PieChart.Data("MTN", line1),
                        new PieChart.Data("NEXTEL", line2)
                );
       pieChart.setData(pieChartData);
      // pieChart.setStartAngle(0);
       
       
       
       
       
       
       
       
       
       
       
       //////////////////////////////////////////////////////////////////
        Timeline timeline=new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(200),(ActionEvent actionEvent)->{
             line=Math.random() * 100;
             line1=Math.random() * 100;
             line2=Math.random() * 100;
             series.getData().add(new XYChart.Data<>("ORANGE",line));
             pieChartData.set(0, new PieChart.Data("ORANGE", line));
             series1.getData().add(new XYChart.Data<>("MTN",line1));
              pieChartData.set(1, new PieChart.Data("MTN", line1));
             series2.getData().add(new XYChart.Data<>("NEXTEL",line2));
             pieChartData.set(2, new PieChart.Data("NEXTEL", line2));
             
        }));
        timeline.setCycleCount(10000);
        timeline.setAutoReverse(true);  //!?
        timeline.play();
    }
    
    class DonnerReaders implements Runnable{

        @Override
        public void run() {
            System.out.println("je passe ici maintenannt oooo");
            line=Math.random() * 100;
             line1=Math.random() * 100;
             line2=Math.random() * 100;
             series.getData().add(new XYChart.Data<>("ORANGE",line));
             series1.getData().add(new XYChart.Data<>("MTN",line1));
             series2.getData().add(new XYChart.Data<>("NEXTEL",line2));        }
        
    }
    
}
