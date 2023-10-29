package com.advancedalgorithms.asigment;

import com.advancedalgorithms.asigment.uf.Node;
import com.advancedalgorithms.asigment.uf.UF;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloController {

    private UF dus;

    @FXML
    private Label welcomeText;

    @FXML
    private TextArea inputTA;

    @FXML
    private TextArea outPutTA;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!. Input: " + inputTA.getText());

        String input = inputTA.getText();

        List<String> myList = new ArrayList<String>(Arrays.asList(input.split(" ")));

        this.dus = new UF(myList);
        outPutTA.setText(Arrays.toString(dus.getParent()));
    }

    @FXML
    protected void onSameTreeButtonClick() {
        welcomeText.setText("Call SameTree Method!. Input: " + inputTA.getText());

        String input = inputTA.getText();

        List<String> myList = new ArrayList<String>(Arrays.asList(input.split(" ")));

        Node fResult = dus.find(Integer.valueOf(myList.get(0)));
        Node sResult = dus.find(Integer.valueOf(myList.get(1)));

        outPutTA.setText((fResult == sResult) + "");
    }

    @FXML
    protected void onUnionButtonClick() {
        welcomeText.setText("Union!. Input: " + inputTA.getText());

        String input = inputTA.getText();

        List<String> myList = new ArrayList<String>(Arrays.asList(input.split(" ")));

        dus.union(Integer.parseInt(myList.get(0)), Integer.parseInt(myList.get(1)));
        outPutTA.setText(Arrays.toString(dus.getParent()));
    }
}