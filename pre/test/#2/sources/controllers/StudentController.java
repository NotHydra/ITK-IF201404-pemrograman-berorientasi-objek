package controllers;

import models.StudentModel;
import schemas.StudentSchema;
import views.StudentView;

public class StudentController {
    private StudentModel studentModel;
    private StudentView studentView;

    public StudentController(StudentModel studentModel, StudentView studentView) {
        this.studentModel = studentModel;
        this.studentView = studentView;
    }

    public void display() {
        for (StudentSchema student : this.studentModel.get()) {
            this.studentView.display(student.toString());
        }
    }

    public StudentSchema add(String name, String grade, String major) {
        return this.studentModel.add(name, grade, major);
    }
}
