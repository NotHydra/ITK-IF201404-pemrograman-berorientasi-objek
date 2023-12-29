import controllers.StudentController;
import models.StudentModel;
import views.StudentView;

public class App {
    public static void main(String[] args) throws Exception {
        StudentModel studentModel = new StudentModel();
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(studentModel, studentView);

        // Implementation
        System.out.println(studentController.get());
        // System.out.println(studentController.getOne(1));
        // studentController.add("Student 4", "Grade 4", "Major 4");
        // studentController.change(1, "Student 5", "Grade 5", "Major 5");
        // studentController.remove(3);

    };
}
