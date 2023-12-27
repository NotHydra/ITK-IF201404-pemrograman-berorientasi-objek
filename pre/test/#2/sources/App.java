import java.sql.*;

import controllers.StudentController;
import models.StudentModel;
import views.StudentView;

public class App {
    public static void main(String[] args) throws Exception {
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

        Database database = new Database();
        ResultSet result;

        result = database.executeQuery("SELECT name FROM student;");
        while (result.next()) {
            System.out.println(result.getString("name"));
        }

        database.executeUpdate("INSERT INTO student (name, grade, major) VALUES ('Student 2', 'Grade 2', 'Major 2');");

        result = database.executeQuery("SELECT name FROM student;");
        while (result.next()) {
            System.out.println(result.getString("name"));
        }
    };
}
