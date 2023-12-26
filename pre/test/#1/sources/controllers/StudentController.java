package controllers;

import models.StudentModel;
import views.StudentView;

public class StudentController {
    public static void displayStudentName() {
        for (StudentModel student : StudentModel.getStudent()) {
            StudentView.display(student.getName());
        }
    };
}
