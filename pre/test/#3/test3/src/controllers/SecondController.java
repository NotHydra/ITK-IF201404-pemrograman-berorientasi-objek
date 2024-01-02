package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.App;

public class SecondController {
    @FXML
    private TextField textFieldTitle;

    @FXML
    void buttonSwitchClick(ActionEvent event) throws IOException {
        App.setRoot("Primary");
    }

    @FXML
    void buttonSubmitClick(ActionEvent event) {
        System.out.println(textFieldTitle.getText());
    }

}
