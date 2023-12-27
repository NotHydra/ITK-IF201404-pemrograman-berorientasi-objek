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

    public void add(String name, String grade, String major) throws SQLException {
        Database database = new Database();
        database.executeUpdate(
                "INSERT INTO student (name, grade, major) VALUES('" + name + "', '" + grade + "', '" + major + "');");

        database.close();
    }

    public void change(int id, String name, String grade, String major) throws SQLException {
        Database database = new Database();
        database.executeUpdate(
                "UPDATE student SET name='" + name + "', grade='" + grade + "', major='" + major + "' WHERE id='" + id
                        + "';");

        database.close();
    }
}
