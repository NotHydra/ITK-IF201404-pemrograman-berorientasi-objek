public class W6App {
    public static void main(String[] args) throws Exception {
        W6Student student1 = new W6Student("Student 1", "Address 1");

        System.out.println(student1.GetName());
        student1.AddCourseGrade("Course 1", 87);
        student1.PrintGrades();
        System.out.println(student1.GetAverageGrade());
        System.out.println();

        student1.AddCourseGrade("Course 2", 76);
        student1.PrintGrades();
        System.out.println(student1.GetAverageGrade());
        System.out.println();

        student1.AddCourseGrade("Course 3", 92);
        student1.PrintGrades();
        System.out.println(student1.GetAverageGrade());
        System.out.println();

        W6Teacher teacher1 = new W6Teacher("Teacher 1", "Address 1");

        System.out.println(teacher1.GetName());
        System.out.println(teacher1.AddCourse("Calculus 1"));
        System.out.println(teacher1.AddCourse("Calculus 1"));
        System.out.println(teacher1.AddCourse("Calculus 2"));
        System.out.println(teacher1.AddCourse("Calculus 2"));
        System.out.println(teacher1.RemoveCourse("Calculus 1"));
        System.out.println(teacher1.RemoveCourse("Calculus 1"));
        System.out.println(teacher1.RemoveCourse("Physics 1"));
        System.out.println(teacher1.AddCourse("Physics 1"));
        System.out.println(teacher1.GetCourse());

    }
}
