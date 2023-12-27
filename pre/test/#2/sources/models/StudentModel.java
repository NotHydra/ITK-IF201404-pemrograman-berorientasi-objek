package models;

import java.sql.*;
import java.util.ArrayList;

import providers.Database;
import schemas.StudentSchema;

public class StudentModel {
    public ArrayList<StudentSchema> get() throws SQLException {
        Database database = new Database();
        ResultSet result = database.executeQuery("SELECT id, name, grade, major FROM student;");

        ArrayList<StudentSchema> students = new ArrayList<StudentSchema>();
        while (result.next()) {
            students.add(new StudentSchema(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("grade"),
                    result.getString("major")));
        }

        database.close();

        return students;
    }

}
