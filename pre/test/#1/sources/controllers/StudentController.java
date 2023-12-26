package controllers;

import models.StudentModel;
import views.StudentView;

public class StudentController {
    public void displayStudent() {
        for (StudentModel student : StudentModel.getStudent()) {
            StudentView.display(student.getName());
        }
    };

    public void addStudent(String name, int age, String grade, String major) {
        StudentModel.addStudent(new StudentModel(name, age, grade, major));
    }
}
