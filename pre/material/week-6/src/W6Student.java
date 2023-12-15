import java.util.ArrayList;

public class W6Student extends W6Person {
    private int numCourses = 0;
    private ArrayList<String> courses = new ArrayList<String>();
    private ArrayList<Integer> grades = new ArrayList<Integer>();

    public W6Student(String name, String address) {
        super(name, address);
    };

    public void AddCourseGrade(String course, int grade) {
        this.numCourses += 1;
        this.courses.add(course);
        this.grades.add(grade);
    }

    public void PrintGrades() {
        System.out.println(this.grades);
    };

    public double GetAverageGrade() {
        int total = 0;
        for (Integer grade : this.grades) {
            total += grade;
        }

        return (double) (total / this.numCourses);
    };

    @Override
    public String ToString() {
        return "Student: " + this.GetName() + "(" + this.GetAddress() + ")";
    };

}
