import models.StudentModel;

public class App {
    public static void main(String[] args) throws Exception {
        StudentModel studentModel = new StudentModel();

        studentModel.add("Student 1", "Grade 1", "Major 1");
        studentModel.add("Student 2", "Grade 2", "Major 2");
        studentModel.add("Student 3", "Grade 3", "Major 3");

        System.out.println(studentModel.get());
        System.out.println(studentModel.getOne(1));
        System.out.println(studentModel.change(1, "Student 4", "Grade 4", "Major 4"));
        System.out.println(studentModel.getOne(1));
        System.out.println(studentModel.get());
    };
}
