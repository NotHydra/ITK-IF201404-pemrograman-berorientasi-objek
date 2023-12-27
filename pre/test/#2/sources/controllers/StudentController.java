package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import schemas.StudentSchema;
import models.StudentModel;
import views.StudentView;

public class StudentController {
    private StudentModel studentModel;
    private StudentView studentView;

    public StudentController(StudentModel studentModel, StudentView studentView) {
        this.studentModel = studentModel;
        this.studentView = studentView;
    }

    public ArrayList<StudentSchema> get() throws SQLException {
        return this.studentModel.get();
    }

    public void display() throws SQLException {
        for (StudentSchema student : this.studentModel.get()) {
            this.studentView.display(student.getName());
        }
    }
}
