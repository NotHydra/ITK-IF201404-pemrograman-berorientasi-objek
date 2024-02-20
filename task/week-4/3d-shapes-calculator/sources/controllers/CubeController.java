package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CubeController {
    @FXML
    private TextField textFieldSide;

    @FXML
    private TextField textFieldSurfaceArea;

    @FXML
    private TextField textFieldVolume;

    @FXML
    void buttonCalculate(ActionEvent event) {
        if (!textFieldSide.getText().isEmpty()) {
            final double side = Double.parseDouble(textFieldSide.getText());
            
            textFieldSurfaceArea.setText(String.valueOf(6 * Math.pow(side, 2)));
            textFieldVolume.setText(String.valueOf(Math.pow(side, 3)));
        } else {
            textFieldSurfaceArea.setText("Missing Value");
            textFieldVolume.setText("Missing Value");
        }
    }

    @FXML
    void buttonBack(ActionEvent event) {
        MainController.setRoot("Main");
    }
}
