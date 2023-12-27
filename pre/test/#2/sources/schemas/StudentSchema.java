package schemas;

public class StudentSchema {
    private int id;
    private String name;
    private String grade;
    private String major;

    public StudentSchema(int id, String name, String grade, String major) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.major = major;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getMajor() {
        return this.major;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String toString() {
        return "Student(" + this.id + ", " + this.name + ", " + this.grade + ", " + this.major + ")";
    }
}
