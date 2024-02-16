package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CylinderController {
    @FXML
    private TextField textFieldRadius;

    @FXML
    private TextField textFieldHeight;

    @FXML
    private TextField textFieldSurfaceArea;

    @FXML
    private TextField textFieldVolume;

    @FXML
    void buttonCalculate(ActionEvent event) {
        if (!textFieldRadius.getText().isEmpty() && !textFieldHeight.getText().isEmpty()) {
            final double radius = Double.parseDouble(textFieldRadius.getText());
            final double height = Double.parseDouble(textFieldHeight.getText());
            
            textFieldSurfaceArea.setText(String.valueOf(2 * Math.PI * radius * (radius + height)));
            textFieldVolume.setText(String.valueOf(Math.PI * Math.pow(radius, 2) * height));
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
