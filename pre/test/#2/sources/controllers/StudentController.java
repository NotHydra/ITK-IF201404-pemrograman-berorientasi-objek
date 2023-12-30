package controllers;

import schemas.StudentSchema;
import models.StudentModel;
import views.StudentView;

public class StudentController {
    private final StudentModel studentModel;
    private final StudentView studentView;

    public StudentController(StudentModel studentModel, StudentView studentView) {
        this.studentModel = studentModel;
        this.studentView = studentView;
    }

    public void display() {
        try {
            for (StudentSchema student : this.studentModel.get()) {
                this.studentView.display(student.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StudentSchema[] get() {
        try {
            return this.studentModel.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public StudentSchema getOne(int id) {
        try {
            return this.studentModel.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void add(String name, String grade, String major) {
        try {
            this.studentModel.add(new StudentSchema(name, grade, major));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(StudentSchema[] students) {
        try {
            this.studentModel.add(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void change(int id, String name, String grade, String major) {
        try {
            this.studentModel.change(id, new StudentSchema(name, grade, major));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        try {
            this.studentModel.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
