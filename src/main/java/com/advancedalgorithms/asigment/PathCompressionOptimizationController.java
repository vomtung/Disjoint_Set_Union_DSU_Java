package com.advancedalgorithms.asigment;

import com.advancedalgorithms.asigment.uf.Node;
import com.advancedalgorithms.asigment.uf.UF;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathCompressionOptimizationController {

    private UF dus;

    private List<String> originList;

    @FXML
    private Label welcomeText;

    @FXML
    private TextArea inputTA;

    @FXML
    private TextArea outPutTA;

    @FXML
    private Label speedvalueLabel;

    @FXML
    protected void onHelloButtonClick() {

        ZonedDateTime beginDT = ZonedDateTime.now();

        welcomeText.setText("Input: " + inputTA.getText());

        String input = inputTA.getText();

        originList = new ArrayList<>(Arrays.asList(input.split(" ")));

        this.dus = new UF(originList);
        outPutTA.setText(Arrays.toString(dus.getParent()));

        ZonedDateTime endDT = ZonedDateTime.now();

        Double duration = (Double.valueOf(endDT.getNano()) - beginDT.getNano())/1000000;
        speedvalueLabel.setText(String.valueOf(duration));
    }

    @FXML
    protected void onSameTreeButtonClick() {


        ZonedDateTime beginDT = ZonedDateTime.now();

        String input = inputTA.getText();

        List<String> myList = new ArrayList<String>(Arrays.asList(input.split(" ")));

        int firstIndex = originList.indexOf(myList.get(0));
        int secondIndex = originList.indexOf(myList.get(1));

        Node fResult = dus.find(firstIndex);
        Node sResult = dus.find(secondIndex);

        welcomeText.setText("Check SameTree. Input: " + inputTA.getText());

        outPutTA.setText((fResult == sResult) + "");

        ZonedDateTime endDT = ZonedDateTime.now();

        Double duration = (Double.valueOf(endDT.getNano()) - beginDT.getNano())/1000000;
        speedvalueLabel.setText(String.valueOf(duration));
    }

    @FXML
    protected void onUnionButtonClick() {

        ZonedDateTime beginDT = ZonedDateTime.now();

        String input = inputTA.getText();

        List<String> myList = new ArrayList<String>(Arrays.asList(input.split(" ")));

        int firstIndex = originList.indexOf(myList.get(0));
        int secondIndex = originList.indexOf(myList.get(1));

        welcomeText.setText("Union. Input: " + inputTA.getText()
                + " index " + firstIndex +" "+ secondIndex);


        dus.union(firstIndex, secondIndex);
        outPutTA.setText(Arrays.toString(dus.getParent()));

        ZonedDateTime endDT = ZonedDateTime.now();

        Double duration = (Double.valueOf(endDT.getNano()) - beginDT.getNano())/1000000;
        speedvalueLabel.setText(String.valueOf(duration));
    }
}
