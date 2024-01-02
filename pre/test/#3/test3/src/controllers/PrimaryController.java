package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TextField textFieldTitle;

    @FXML
    void buttonSubmitClick(ActionEvent event) {
        System.out.println("Test 1");
    }

}
