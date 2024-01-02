package controllers;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application {
    private static Scene scene;

    public static void initialize(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadView("Student"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadView(fxml));
    }

    private static Parent loadView(String fxml) throws IOException {
        return (new FXMLLoader(MainController.class.getResource("../pages/" + fxml + "Page.fxml"))).load();
    }

}
