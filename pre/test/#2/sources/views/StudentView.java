package views;

import java.io.IOException;

import controllers.MainController;

public class StudentView {
    public void home() throws IOException {
        MainController.setRoot("Student");
    }

    public void add() throws IOException {
        MainController.setRoot("StudentAdd");
    }
}
