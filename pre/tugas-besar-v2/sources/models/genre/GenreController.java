package models.genre;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import components.Modal;

public class GenreController implements Initializable {
    private final static GenreService service = GenreService.getInstance();

    private GenreModel selectedModel;

    @FXML
    private TableView<GenreModel> tableViewGenre;

    @FXML
    private TableColumn<GenreModel, String> tableColumnName;

    @FXML
    private TextField textFieldName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnName.setCellValueFactory(model -> new SimpleStringProperty(model.getValue().getName()));

        tableViewGenre.setItems(FXCollections.observableArrayList(service.find()));
    }

    public void tableReload() {
        tableViewGenre.setItems(FXCollections.observableArrayList(service.find()));
    }

    @FXML
    public void tableItemClick(MouseEvent event) {
        try {
            this.selectedModel = tableViewGenre.getSelectionModel().getSelectedItem();

            textFieldName.setText(this.selectedModel.getName());
        }
        catch (Exception e) {
        }
    }

    @FXML
    public void buttonAddEvent(ActionEvent event) {
        if (Modal.getInstance().confirmation()) {
            try {
                service.add(new GenreModel(textFieldName.getText()));

                this.tableReload();
            }
            catch (Exception e) {
                Modal.getInstance().fail(e.getMessage());
            }
        }
    }

    @FXML
    public void buttonChangeEvent(ActionEvent event) {
        if (this.selectedModel != null) {
            if (Modal.getInstance().confirmation()) {
                try {
                    service.change(
                            this.selectedModel.getId(),
                            new GenreModel(textFieldName.getText()));

                    this.tableReload();
                }
                catch (Exception e) {
                    Modal.getInstance().fail(e.getMessage());
                }
            }
        }
    }

    @FXML
    public void buttonRemoveEvent(ActionEvent event) {
        if (this.selectedModel != null) {
            if (Modal.getInstance().confirmation()) {
                try {
                    service.remove(this.selectedModel.getId());

                    this.selectedModel = null;

                    textFieldName.clear();

                    this.tableReload();
                }
                catch (Exception e) {
                    Modal.getInstance().fail(e.getMessage());
                }
            }
        }
    }
}