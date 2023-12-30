package schemas;

import interfaces.StudentInterface;

public class StudentSchema extends BaseSchema implements StudentInterface {
    private final int id;
    private final String name;
    private final String grade;
    private final String major;

    public StudentSchema(String name, String grade, String major) {
        this.validate(name, grade, major);

        this.id = -1;
        this.name = name;
        this.grade = grade;
        this.major = major;
    }

    public StudentSchema(int id, String name, String grade, String major) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        this.validate(name, grade, major);

        this.id = id;
        this.name = name;
        this.grade = grade;
        this.major = major;
    }

    private void validate(String name, String grade, String major) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (grade == null || grade.trim().isEmpty()) {
            throw new IllegalArgumentException("Grade cannot be empty");
        }

        if (major == null || major.trim().isEmpty()) {
            throw new IllegalArgumentException("Major cannot be empty");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getGrade() {
        return this.grade;
    }

    @Override
    public String getMajor() {
        return this.major;
    }

    @Override
    public String toString() {
        return "Student("
                + "id=" + this.id + ", "
                + "name=" + this.name + ", "
                + "grade=" + this.grade + ", "
                + "major=" + this.major
                + ")";
    }
}
