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

    public void display() throws SQLException {
        for (StudentSchema student : this.studentModel.get()) {
            this.studentView.display(student.getName());
        }
    }

    public ArrayList<StudentSchema> get() throws SQLException {
        return this.studentModel.get();
    }

    public StudentSchema getOne(int id) throws SQLException {
        return this.studentModel.getOne(id);
    }

    public void add(String name, String grade, String major) throws SQLException {
        this.studentModel.add(new StudentSchema(name, grade, major));
    }

    public void change(int id, String name, String grade, String major) throws SQLException {
        this.studentModel.change(id, new StudentSchema(name, grade, major));
    }

    public void remove(int id) throws SQLException {
        this.studentModel.remove(id);
    }
}
