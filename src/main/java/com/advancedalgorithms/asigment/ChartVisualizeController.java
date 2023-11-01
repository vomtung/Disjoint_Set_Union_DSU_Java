package com.advancedalgorithms.asigment;

import com.advancedalgorithms.asigment.uf.Node;
import com.advancedalgorithms.asigment.uf.UF;
import com.advancedalgorithms.asigment.uf.UFPathCompression;
import com.advancedalgorithms.asigment.uf.UFPathHalving;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ChartVisualizeController {

    private UF uf;
    private UFPathCompression ufPathCompression;

    @FXML
    private Label speedvalueLabel;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    protected void onVisualizeButtonClick() {

        lineChart.setAnimated (true);
        visualizaGrafico();
    }



    private void visualizaGrafico(){
        yAxis.setLabel("Time");
        xAxis.setLabel("Vertex");
        int verTextNum = 2000;
        int runNum = 5000000;
        List<String>vertexValues = new ArrayList<>();
        for(int i = 0; i < verTextNum; i++){
            vertexValues.add(String.valueOf(i));
        }

        uf = new UF(vertexValues);
        ufPathCompression = new UFPathCompression(vertexValues);


        XYChart.Series series = new XYChart.Series();

        for (int i =runNum-200; i < runNum; i ++) {

            int beginDT = ZonedDateTime.now().getNano();
            System.out.println("beginDT.getNano() :" + beginDT);
            int firstVertex = ThreadLocalRandom.current().nextInt(0, verTextNum-1 );
            int secondVertex = ThreadLocalRandom.current().nextInt(0, verTextNum-1);

            uf.union(firstVertex,secondVertex);
            int endDT = ZonedDateTime.now().getNano();
            System.out.println("endDT.getNano() :" + endDT);
            long duration = ( endDT -  beginDT);
            System.out.println("i:" + i+ " duration:" + duration);
            series.getData().add(new XYChart.Data(String.valueOf(i), duration));
        }

        XYChart.Series series2 = new XYChart.Series();
        for (int i  =runNum-200; i < runNum; i ++) {

            int beginDT = ZonedDateTime.now().getNano();
            //System.out.println("beginDT.getNano() :" + beginDT.getNano());
            int firstVertex = ThreadLocalRandom.current().nextInt(0, verTextNum-1 );
            int secondVertex = ThreadLocalRandom.current().nextInt(0, verTextNum-1);

            ufPathCompression.union(firstVertex,secondVertex);
            int endDT = ZonedDateTime.now().getNano();
            long duration = ( endDT -  beginDT);
            //System.out.println("endDT.getNano() :" + endDT.getNano());

            System.out.println("i:" + i+ " duration:" + duration);
            series2.getData().add(new XYChart.Data(String.valueOf(i), duration));
        }



        series.setName("Origin Union Find Algorithm");
        series2.setName("Union Find Path Compression");

        lineChart.getData().clear();
        lineChart.getData().addAll(series, series2);
        //Scene scene  = new Scene(lineChart,800,600);
    }
}
