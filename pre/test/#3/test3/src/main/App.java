package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadView("Primary"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadView(fxml));
    }

    private static Parent loadView(String fxml) throws IOException {
        return (new FXMLLoader(App.class.getResource("../views/" + fxml + "View.fxml"))).load();
    }

    public static void main(String[] args) {
        launch();
    }
}