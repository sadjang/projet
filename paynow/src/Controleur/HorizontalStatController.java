/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author sadjang
 */
public class HorizontalStatController implements Initializable {

    /**
     * Initializes the controller class.
     */
  /* @FXML
    private BarChart<Number, String> barchposgresacti;*/
   final static String itemA = "ORANGE";
    final static String itemB = "MTN";
    final static String itemC = "NEXTEL";
    
     @FXML
    private BorderPane borderpane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

      /*  XYChart.Series setl=new XYChart.Series<>();
        setl.getData().add(new XYChart.Data(601.34,"Orange")); 
        setl.getData().add(new XYChart.Data(601.34,"MTN")); 
        setl.getData().add(new XYChart.Data(601.34,"NEXTEL")); 
        barchposgresacti.getData().addAll(setl);*/
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);
        
        bc.setTitle("Activity");
        xAxis.setLabel("Value");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Data");
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("ORANGE");
        series1.getData().add(new XYChart.Data(0, itemA));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("MTN");
        series2.getData().add(new XYChart.Data(0, itemB));
        
         XYChart.Series series3 = new XYChart.Series();
        series3.setName("NEXTEL");
        series3.getData().add(new XYChart.Data(0, itemC));
       
        
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(500), 
            new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                for (XYChart.Series<Number, String> series : bc.getData()) {
                    for (XYChart.Data<Number, String> data : series.getData()) {
                        data.setXValue(Math.random() * 100);
                    }
                }
            }
        }));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();

         bc.getData().addAll(series1,series2,series3);
        borderpane.setCenter(bc);
        
    }    
    
}
