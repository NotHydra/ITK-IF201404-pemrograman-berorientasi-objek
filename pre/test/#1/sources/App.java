import controllers.StudentController;
import models.StudentModel;

public class App {
    public static void main(String[] args) throws Exception {
        StudentModel.addStudent(new StudentModel("Student 1", 1, "Grade 1", "Major 1"));
        StudentModel.addStudent(new StudentModel("Student 2", 2, "Grade 2", "Major 2"));
        StudentModel.addStudent(new StudentModel("Student 3", 3, "Grade 3", "Major 3"));

        StudentController studentController = new StudentController();

        studentController.displayStudentName();
    }
}
