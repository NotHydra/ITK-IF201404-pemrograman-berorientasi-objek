package models;

import java.sql.*;
import java.util.ArrayList;

import providers.Database;
import schemas.StudentSchema;

public class StudentModel extends BaseModel<StudentSchema> {
    @Override
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

    @Override
    public StudentSchema getOne(int id) throws SQLException {
        Database database = new Database();
        ResultSet result = database
                .executeQuery("SELECT id, name, grade, major FROM student WHERE id='" + id + "';");

        StudentSchema student = null;

        if (result.next()) {
            student = new StudentSchema(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("grade"),
                    result.getString("major"));
        }

        database.close();

        return student;
    }

    @Override
    public void add(StudentSchema schema) throws SQLException {
        Database database = new Database();
        database.executeUpdate(
                "INSERT INTO student (name, grade, major) VALUES ('" + schema.getName() + "', '" + schema.getGrade()
                        + "', '" + schema.getMajor() + "');");

        database.close();
    }

    @Override
    public void change(int id, StudentSchema schema) throws SQLException {
        Database database = new Database();
        database.executeUpdate(
                "UPDATE student SET name='" + schema.getName() + "', grade='" + schema.getGrade() + "', major='"
                        + schema.getMajor() + "' WHERE id='" + id + "';");

        database.close();
    }

    @Override
    public void remove(int id) throws SQLException {
        Database database = new Database();
        database.executeUpdate("DELETE FROM student WHERE id='" + id + "'");

        database.close();
    }
}
