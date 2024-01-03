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
import javafx.scene.input.MouseEvent;

import utilities.Modal;
import models.JurusanModel;
import services.JurusanService;

public class StudentController implements Initializable {
    private final static Modal modal = new Modal();
    private final static JurusanService service = new JurusanService();
    private final static StudentView view = new StudentView();

    private JurusanModel selectedStudent;

    @FXML
    private TableView<JurusanModel> tableViewStudent;

    @FXML
    private TableColumn<JurusanModel, String> tableColumnName;

    @FXML
    private TableColumn<JurusanModel, String> tableColumnGrade;

    @FXML
    private TableColumn<JurusanModel, String> tableColumnMajor;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldGrade;

    @FXML
    private TextField textFieldMajor;

    public static void loadPage() {
        view.page();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnName.setCellValueFactory(new PropertyValueFactory<JurusanModel, String>("name"));
        tableColumnGrade.setCellValueFactory(new PropertyValueFactory<JurusanModel, String>("grade"));
        tableColumnMajor.setCellValueFactory(new PropertyValueFactory<JurusanModel, String>("major"));

        tableViewStudent.setItems(FXCollections.observableArrayList(service.get()));
    }

    public void tableReload() {
        tableViewStudent.setItems(FXCollections.observableArrayList(service.get()));
    }

    @FXML
    public void tableItemClick(MouseEvent event) {
        try {
            this.selectedStudent = tableViewStudent.getSelectionModel().getSelectedItem();

            textFieldName.setText(this.selectedStudent.getName());
            textFieldGrade.setText(this.selectedStudent.getGrade());
            textFieldMajor.setText(this.selectedStudent.getMajor());
        } catch (Exception e) {
        }
    }

    @FXML
    public void buttonAddEvent(ActionEvent event) {
        if (modal.confirmation()) {
            service.add(new JurusanModel(textFieldName.getText(), textFieldGrade.getText(), textFieldMajor.getText()));

            this.tableReload();
        }
    }

    @FXML
    public void buttonChangeEvent(ActionEvent event) {
        if (this.selectedStudent != null) {
            if (modal.confirmation()) {
                service.change(
                        this.selectedStudent.getId(),
                        new JurusanModel(
                                textFieldName.getText(),
                                textFieldGrade.getText(),
                                textFieldMajor.getText()));

                this.tableReload();
            }
        }
    }

    @FXML
    public void buttonRemoveEvent(ActionEvent event) {
        if (this.selectedStudent != null) {
            if (modal.confirmation()) {
                service.remove(this.selectedStudent.getId());

                this.selectedStudent = null;

                textFieldName.clear();
                textFieldGrade.clear();
                textFieldMajor.clear();

                this.tableReload();
            }
        }
    }
}