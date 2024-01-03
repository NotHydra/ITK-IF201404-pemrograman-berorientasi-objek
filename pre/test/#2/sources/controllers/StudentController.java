package controllers;

import views.StudentView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.StudentModel;
import services.StudentService;

public class StudentController implements Initializable {
    private final static StudentService service = new StudentService();
    private final static StudentView view = new StudentView();

    @FXML
    private TableView<StudentModel> tableViewStudent;

    @FXML
    private TableColumn<StudentModel, String> tableColumnName;

    @FXML
    private TableColumn<StudentModel, String> tableColumnGrade;

    @FXML
    private TableColumn<StudentModel, String> tableColumnMajor;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldGrade;

    @FXML
    private TextField textFieldMajor;

    public static void loadPage() {
        view.page();
    }

    public void reloadPage() {
        tableViewStudent.setItems(FXCollections.observableArrayList(service.get()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnName.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("name"));
        tableColumnGrade.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("grade"));
        tableColumnMajor.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("major"));

        tableViewStudent.setItems(FXCollections.observableArrayList(service.get()));
    }

    @FXML
    public void buttonAddEvent(ActionEvent event) {
        service.add(new StudentModel(textFieldName.getText(), textFieldGrade.getText(), textFieldMajor.getText()));

        this.reloadPage();
    }

    @FXML
    public void buttonChangeEvent(ActionEvent event) {
    }

    @FXML
    public void buttonRemoveEvent(ActionEvent event) {
    }
}