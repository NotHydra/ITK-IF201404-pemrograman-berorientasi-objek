import models.StudentModel;

public class App {
    public static void main(String[] args) throws Exception {
        StudentModel student1 = new StudentModel("Student 1", 1, "Grade 1", "Major 1");
        StudentModel student2 = new StudentModel("Student 2", 2, "Grade 2", "Major 2");
        StudentModel student3 = new StudentModel("Student 3", 3, "Grade 3", "Major 3");

        System.out.println(StudentModel.getStudent());
        StudentModel.addStudent(student1);

        System.out.println(StudentModel.getStudent());
        StudentModel.addStudent(student2);

        System.out.println(StudentModel.getStudent());
        StudentModel.addStudent(student3);

        System.out.println(StudentModel.getStudent());
        StudentModel.removeStudent(student2);

        System.out.println(StudentModel.getStudent());
    }
}
