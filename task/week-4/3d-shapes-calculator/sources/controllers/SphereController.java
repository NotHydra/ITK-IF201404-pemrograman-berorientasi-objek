package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SphereController {
    @FXML
    private TextField textFieldRadius;

    @FXML
    private TextField textFieldSurfaceArea;

    @FXML
    private TextField textFieldVolume;

    @FXML
    void buttonCalculate(ActionEvent event) {
        if (!textFieldRadius.getText().isEmpty()) {
            final double radius = Double.parseDouble(textFieldRadius.getText());

            textFieldSurfaceArea.setText(String.valueOf(4 * Math.PI * Math.pow(radius, 2)));
            textFieldVolume.setText(String.valueOf(((double) (4) / (double) (3)) * Math.PI * Math.pow(radius, 3)));
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
