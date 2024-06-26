package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import main.App;

public class PrimaryController {
    @FXML
    private TextField textFieldTitle;

    @FXML
    void buttonSwitchClick(ActionEvent event) throws IOException {
        App.setRoot("Second");
    }

    @FXML
    void buttonSubmitClick(ActionEvent event) {
        System.out.println(textFieldTitle.getText());
    }

}
