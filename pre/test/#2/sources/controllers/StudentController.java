package controllers;

import views.StudentView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.StudentModel;
import services.StudentService;

public class StudentController {
    private final static StudentService service = new StudentService();
    private final static StudentView view = new StudentView();

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldGrade;

    @FXML
    private TextField textFieldMajor;

    @FXML
    void buttonAddEvent(ActionEvent event) {
        view.add();
    }

    @FXML
    void buttonBackEvent(ActionEvent event) {
        view.home();
    }

    @FXML
    void buttonSubmitEvent(ActionEvent event) {
        service.add(new StudentModel(textFieldName.getText(), textFieldGrade.getText(), textFieldMajor.getText()));
    }
}