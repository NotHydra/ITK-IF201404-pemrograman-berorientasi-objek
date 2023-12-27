package controllers;

import models.StudentModel;
import views.StudentView;

public class StudentController {
    StudentView studentView = new StudentView();

    public void displayStudent() {
        for (StudentModel student : StudentModel.getStudent()) {
            studentView.display(student.getName());
        }
    };

    public void addStudent(String name, int age, String grade, String major) {
        StudentModel.addStudent(new StudentModel(name, age, grade, major));
    }
}
