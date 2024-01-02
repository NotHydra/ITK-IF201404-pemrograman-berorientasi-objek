package controllers;

import views.StudentView;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import models.StudentModel;

public class StudentController {
    private final static StudentModel model = new StudentModel();
    private final static StudentView view = new StudentView();

    @FXML
    void buttonHomeEvent(ActionEvent event) throws IOException {
        view.home();
    }

    @FXML
    void buttonAddEvent(ActionEvent event) throws IOException {
        view.add();
    }
}