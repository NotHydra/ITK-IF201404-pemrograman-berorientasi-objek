package views;

import controllers.MainController;

public class StudentView {
    public void home() {
        MainController.setRoot("Student");
    }

    public void add() {
        MainController.setRoot("StudentAdd");
    }
}
