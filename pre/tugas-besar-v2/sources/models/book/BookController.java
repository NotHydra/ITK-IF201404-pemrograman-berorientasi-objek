package models.book;


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

import components.Modal;

public class BookController implements Initializable {
    private final static BookService service = BookService.getInstance();

    private BookModel selectedBook;

    @FXML
    private TableView<BookModel> tableViewBook;

    @FXML
    private TableColumn<BookModel, String> tableColumnTitle;

    @FXML
    private TableColumn<BookModel, String> tableColumnDescription;

    @FXML
    private TextField textFieldTitle;

    @FXML
    private TextField textFieldDescription;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<BookModel, String>("title"));
        tableColumnDescription.setCellValueFactory(new PropertyValueFactory<BookModel, String>("description"));

        tableViewBook.setItems(FXCollections.observableArrayList(service.find()));
    }

    public void tableReload() {
        tableViewBook.setItems(FXCollections.observableArrayList(service.find()));
    }

    @FXML
    public void tableItemClick(MouseEvent event) {
        try {
            this.selectedBook = tableViewBook.getSelectionModel().getSelectedItem();

            textFieldTitle.setText(this.selectedBook.getTitle());
            textFieldDescription.setText(this.selectedBook.getDescription());
        }
        catch (Exception e) {
        }
    }

    @FXML
    public void buttonAddEvent(ActionEvent event) {
        if (Modal.getInstance().confirmation()) {
            try {
                service.add(new BookModel(
                        textFieldTitle.getText(),
                        textFieldDescription.getText()));

                this.tableReload();
            }
            catch (Exception e) {
                Modal.getInstance().fail(e.getMessage());
            }
        }
    }

    @FXML
    public void buttonChangeEvent(ActionEvent event) {
        if (this.selectedBook != null) {
            if (Modal.getInstance().confirmation()) {
                try {
                    service.change(
                            this.selectedBook.getId(),
                            new BookModel(
                                    textFieldTitle.getText(),
                                    textFieldDescription.getText()));

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
        if (this.selectedBook != null) {
            if (Modal.getInstance().confirmation()) {
                try {
                    service.remove(this.selectedBook.getId());

                    this.selectedBook = null;

                    textFieldTitle.clear();
                    textFieldDescription.clear();

                    this.tableReload();
                }
                catch (Exception e) {
                    Modal.getInstance().fail(e.getMessage());
                }
            }
        }
    }
}