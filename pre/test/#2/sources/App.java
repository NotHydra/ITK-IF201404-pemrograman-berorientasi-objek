import java.sql.*;

import controllers.StudentController;
import models.StudentModel;
import views.StudentView;

public class App {
    public static void main(String[] args) throws Exception {
        Database database = new Database();

        // StudentModel studentModel = new StudentModel();
        // StudentView studentView = new StudentView();
        // StudentController studentController = new StudentController(studentModel,
        // studentView);

        // studentController.add("Student 1", "Grade 1", "Major 1");
        // studentController.add("Student 2", "Grade 2", "Major 2");
        // studentController.add("Student 3", "Grade 3", "Major 3");

        // studentController.display();
        // System.out.println();

        // studentController.change(2, "Student 4", "Grade 4", "Major 4");

        // studentController.display();
        // System.out.println();

        // studentController.remove(2);

        // studentController.display();
        // System.out.println();
    };
}
