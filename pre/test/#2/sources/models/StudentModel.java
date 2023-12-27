package models;

import java.util.ArrayList;

import schemas.StudentSchema;

public class StudentModel {
    private int increment;
    private ArrayList<StudentSchema> students;

    public StudentModel() {
        this.increment = 0;
        this.students = new ArrayList<StudentSchema>();
    }

    public int getIncrement() {
        return this.increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public ArrayList<StudentSchema> get() {
        return this.students;
    }

    public StudentSchema getOne(int id) {
        for (StudentSchema student : this.students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public StudentSchema add(String name, String grade, String major) {
        this.increment++;
        StudentSchema student = new StudentSchema(this.increment, name, grade, major);
        this.students.add(student);

        return student;
    }

    public StudentSchema change(int id, String name, String grade, String major) {
        for (StudentSchema student : this.students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setGrade(grade);
                student.setMajor(major);

                return student;
            }
        }

        return null;
    }

    public StudentSchema remove(int id) {
        for (StudentSchema student : this.students) {
            if (student.getId() == id) {
                this.students.remove(student);

                return student;
            }
        }

        return null;
    }
}