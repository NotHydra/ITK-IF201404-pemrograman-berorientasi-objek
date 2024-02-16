package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CuboidController {
    @FXML
    private TextField textFieldLength;

    @FXML
    private TextField textFieldWidth;

    @FXML
    private TextField textFieldHeight;

    @FXML
    private TextField textFieldSurfaceArea;

    @FXML
    private TextField textFieldVolume;

    @FXML
    void buttonCalculate(ActionEvent event) {
        if (!textFieldLength.getText().isEmpty() && !textFieldWidth.getText().isEmpty() && !textFieldHeight.getText().isEmpty()) {
            final double length = Double.parseDouble(textFieldLength.getText());
            final double width = Double.parseDouble(textFieldWidth.getText());
            final double height = Double.parseDouble(textFieldHeight.getText());

            textFieldSurfaceArea.setText(String.valueOf(2 * (length * width + length * height + width * height)));
            textFieldVolume.setText(String.valueOf(length * width * height));
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
