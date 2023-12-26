package controllers;

import models.StudentModel;
import views.StudentView;

public class StudentController {
    public static void DisplayStudentName() {
        for (StudentModel student : StudentModel.getStudent()) {
            StudentView.Display(student.getName());
        }
    };
}
