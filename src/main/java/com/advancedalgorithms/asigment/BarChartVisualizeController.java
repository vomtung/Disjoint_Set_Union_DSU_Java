package com.advancedalgorithms.asigment;

import com.advancedalgorithms.asigment.uf.UF;
import com.advancedalgorithms.asigment.uf.UFPathCompression;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BarChartVisualizeController {

    private static final Integer RUN_NUMBER_150000 = 150000;

    private static final Integer RUN_NUMBER_200000 = 200000;

    private static final Integer RUN_NUMBER_250000 = 250000;
    private static final Integer VERTEX_NUMBER = 1000;

    private static final String UF = "Union Find Origin";
    private static final String UF_PATH_COMPRESSION = "Union Find Path Compression";



    private UF uf;
    private UFPathCompression ufPathCompression;

    @FXML
    private Label speedvalueLabel;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    protected void onVisualizeButtonClick() {

        barChart.setAnimated (true);
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
                RUN_NUMBER_150000.toString(), RUN_NUMBER_200000.toString(), RUN_NUMBER_250000.toString())));
        visualizaGrafico();
    }



    private void visualizaGrafico(){
        yAxis.setLabel("Time(milliseconds)");
        xAxis.setLabel("Run number");
        List<String>vertexValues = new ArrayList<>();
        for(int i = 0; i < VERTEX_NUMBER; i++){
            vertexValues.add(String.valueOf(i));
        }

        uf = new UF(vertexValues);
        ufPathCompression = new UFPathCompression(vertexValues);


        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();


        long originUFHeight =0;
        for (int i = 0; i < RUN_NUMBER_150000; i ++) {

            int beginDT = ZonedDateTime.now().getNano();
            int firstVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1 );
            int secondVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1);

            uf.union(firstVertex,secondVertex);
            int endDT = ZonedDateTime.now().getNano();
            long duration = ( endDT -  beginDT);
            originUFHeight = originUFHeight + duration;
        }
        series.getData().add(new XYChart.Data(RUN_NUMBER_150000.toString(), originUFHeight/1000000));

        originUFHeight =0;
        for (int i = 0; i < RUN_NUMBER_200000; i ++) {

            int beginDT = ZonedDateTime.now().getNano();
            int firstVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1 );
            int secondVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1);

            uf.union(firstVertex,secondVertex);
            int endDT = ZonedDateTime.now().getNano();
            long duration = ( endDT -  beginDT);
            originUFHeight = originUFHeight + duration;
        }
        series.getData().add(new XYChart.Data(RUN_NUMBER_200000.toString(), originUFHeight/1000000));


        originUFHeight =0;
        for (int i = 0; i < RUN_NUMBER_250000; i ++) {

            int beginDT = ZonedDateTime.now().getNano();
            //System.out.println("beginDT.getNano() :" + beginDT.getNano());
            int firstVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1 );
            int secondVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1);

            uf.union(firstVertex,secondVertex);
            int endDT = ZonedDateTime.now().getNano();
            long duration = ( endDT -  beginDT);
            //System.out.println("endDT.getNano() :" + endDT.getNano());

            originUFHeight = originUFHeight + duration;
        }
        series.getData().add(new XYChart.Data(RUN_NUMBER_250000.toString(), originUFHeight/1000000));

        long pathCompressionUFHeight =0;
        for (int i = 0; i < RUN_NUMBER_150000; i ++) {

            int beginDT = ZonedDateTime.now().getNano();
            //System.out.println("beginDT.getNano() :" + beginDT.getNano());
            int firstVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1 );
            int secondVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1);

            ufPathCompression.union(firstVertex,secondVertex);
            int endDT = ZonedDateTime.now().getNano();
            long duration = ( endDT -  beginDT);
            //System.out.println("endDT.getNano() :" + endDT.getNano());

            pathCompressionUFHeight = pathCompressionUFHeight + duration;
        }

        series2.getData().add(new XYChart.Data(RUN_NUMBER_150000.toString(), pathCompressionUFHeight/1000000));

        pathCompressionUFHeight =0;
        for (int i = 0; i < RUN_NUMBER_200000; i ++) {

            int beginDT = ZonedDateTime.now().getNano();
            //System.out.println("beginDT.getNano() :" + beginDT.getNano());
            int firstVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1 );
            int secondVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1);

            ufPathCompression.union(firstVertex,secondVertex);
            int endDT = ZonedDateTime.now().getNano();
            long duration = ( endDT -  beginDT);
            //System.out.println("endDT.getNano() :" + endDT.getNano());

            pathCompressionUFHeight = pathCompressionUFHeight + duration;
        }
        series2.getData().add(new XYChart.Data(RUN_NUMBER_200000.toString(), pathCompressionUFHeight/1000000));

        pathCompressionUFHeight =0;
        for (int i = 0; i < RUN_NUMBER_250000; i ++) {

            int beginDT = ZonedDateTime.now().getNano();
            //System.out.println("beginDT.getNano() :" + beginDT.getNano());
            int firstVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1 );
            int secondVertex = ThreadLocalRandom.current().nextInt(0, VERTEX_NUMBER-1);

            ufPathCompression.union(firstVertex,secondVertex);
            int endDT = ZonedDateTime.now().getNano();
            long duration = ( endDT -  beginDT);
            //System.out.println("endDT.getNano() :" + endDT.getNano());

            pathCompressionUFHeight = pathCompressionUFHeight + duration;
        }

        series2.getData().add(new XYChart.Data(RUN_NUMBER_250000.toString(), pathCompressionUFHeight/1000000));





        series.setName("Union Find");
        series2.setName("Path Compression");

        barChart.getData().clear();
        barChart.getData().addAll(series,series2);
        //Scene scene  = new Scene(lineChart,800,600);
    }
}
