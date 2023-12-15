import java.util.ArrayList;

public class W6Teacher extends W6Person {
    private int numCourses = 0;
    private ArrayList<String> courses = new ArrayList<String>();

    public W6Teacher(String name, String address) {
        super(name, address);
    };

    public ArrayList<String> GetCourse() {
        return this.courses;
    }

    public boolean AddCourse(String course) {
        boolean isValid = true;
        for (String courseItem : this.courses) {
            if (course == courseItem) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            this.courses.add(course);
            this.numCourses += 1;
        }

        return isValid;
    };

    public boolean RemoveCourse(String course) {
        boolean isValid = false;
        for (String courseItem : this.courses) {
            if (course == courseItem) {
                isValid = true;
                this.courses.remove(course);

                break;
            }
        }

        return isValid;
    };

    @Override
    public String ToString() {
        return "Teacher: " + this.GetName() + "(" + this.GetAddress() + ")";
    };
}
