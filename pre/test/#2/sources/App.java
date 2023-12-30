import controllers.StudentController;
import models.StudentModel;
import schemas.StudentSchema;
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
        // studentController.add(new StudentSchema[] {
        // new StudentSchema("Student 5", "Grade 5", "Major 5"),
        // new StudentSchema("Student 6", "Grade 6", "Major 6"),
        // new StudentSchema("Student 7", "Grade 7", "Major 7")
        // });
        // studentController.change(1, "Student 5", "Grade 5", "Major 5");
        // studentController.remove(3);
    };
}
