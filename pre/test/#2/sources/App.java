import controllers.StudentController;
import models.StudentModel;
import views.StudentView;

public class App {
    public static void main(String[] args) throws Exception {
        StudentModel studentModel = new StudentModel();
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(studentModel, studentView);

        // System.out.println(studentController.get());
        // studentController.add("Student 3", "Grade 3", "Major 3");

        // System.out.println(studentController.get());
        // studentController.change(2, "Student 4", "Grade 4", "Major 4");

        // System.out.println(studentController.get());
        // studentController.remove(2);

        System.out.println(studentController.get());
    };
}
