import controllers.StudentController;

public class App {
    public static void main(String[] args) throws Exception {
        StudentController studentController = new StudentController();

        studentController.addStudent("Student 1", 1, "Grade 1", "Major 1");
        studentController.addStudent("Student 2", 2, "Grade 2", "Major 2");
        studentController.addStudent("Student 3", 3, "Grade 3", "Major 3");

        studentController.displayStudent();
    }
}
