package controllers;

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
import views.JurusanView;

public class JurusanController implements Initializable {
    private final static JurusanService service = new JurusanService();
    private final static JurusanView view = new JurusanView();

    private JurusanModel selectedJurusan;

    @FXML
    private TableView<JurusanModel> tableViewJurusan;

    @FXML
    private TableColumn<JurusanModel, String> tableColumnJurusan;

    @FXML
    private TableColumn<JurusanModel, String> tableColumnDeskripsi;

    @FXML
    private TextField textFieldJurusan;

    @FXML
    private TextField textFieldDeskripsi;

    public static void loadPage() {
        view.page();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnJurusan.setCellValueFactory(new PropertyValueFactory<JurusanModel, String>("jurusan"));
        tableColumnDeskripsi.setCellValueFactory(new PropertyValueFactory<JurusanModel, String>("deskripsi"));

        tableViewJurusan.setItems(FXCollections.observableArrayList(service.get()));
    }

    public void tableReload() {
        tableViewJurusan.setItems(FXCollections.observableArrayList(service.get()));
    }

    @FXML
    public void tableItemClick(MouseEvent event) {
        try {
            this.selectedJurusan = tableViewJurusan.getSelectionModel().getSelectedItem();

            textFieldJurusan.setText(this.selectedJurusan.getJurusan());
            textFieldDeskripsi.setText(this.selectedJurusan.getDeskripsi());
        } catch (Exception e) {
        }
    }

    @FXML
    public void buttonAddEvent(ActionEvent event) {
        if (Modal.confirmation()) {
            try {
                service.add(new JurusanModel(
                        textFieldJurusan.getText(),
                        textFieldDeskripsi.getText()));

                this.tableReload();
            } catch (Exception e) {
                Modal.fail(e.getMessage());
            }
        }
    }

    @FXML
    public void buttonChangeEvent(ActionEvent event) {
        if (this.selectedJurusan != null) {
            if (Modal.confirmation()) {
                try {
                    service.change(
                            this.selectedJurusan.getId(),
                            new JurusanModel(
                                    textFieldJurusan.getText(),
                                    textFieldDeskripsi.getText()));

                    this.tableReload();
                } catch (Exception e) {
                    Modal.fail(e.getMessage());
                }
            }
        }
    }

    @FXML
    public void buttonRemoveEvent(ActionEvent event) {
        if (this.selectedJurusan != null) {
            if (Modal.confirmation()) {
                try {
                    service.remove(this.selectedJurusan.getId());

                    this.selectedJurusan = null;

                    textFieldJurusan.clear();
                    textFieldDeskripsi.clear();

                    this.tableReload();
                } catch (Exception e) {
                    Modal.fail(e.getMessage());
                }
            }
        }
    }
}