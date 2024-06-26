package services;

import java.sql.*;

import models.StudentModel;
import providers.Database;

public class StudentService extends BaseService<StudentModel> {
    @Override
    public StudentModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal("student");
            final ResultSet result = database.executeQuery("SELECT id, name, grade, major FROM student;");

            final StudentModel[] students = new StudentModel[total];
            int i = 0;
            while (result.next()) {
                students[i] = new StudentModel(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("grade"),
                        result.getString("major"));

                i++;
            }

            database.close();

            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public StudentModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery("SELECT id, name, grade, major FROM student WHERE id='" + id + "';");

            StudentModel student = null;

            if (result.next()) {
                student = new StudentModel(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("grade"),
                        result.getString("major"));
            }

            database.close();

            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(StudentModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(
                    "INSERT INTO student (name, grade, major) VALUES ("
                            + "'" + model.getName() + "', "
                            + "'" + model.getGrade() + "', "
                            + "'" + model.getMajor() + "'"
                            + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(StudentModel[] models) {
        try {
            final Database database = new Database();

            String query = "INSERT INTO student (name, grade, major) VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getName() + "', "
                        + "'" + models[i].getGrade() + "', "
                        + "'" + models[i].getMajor() + "'"
                        + ")";

                if (i != (models.length - 1)) {
                    query = query + ", ";
                } else {
                    query = query + ";";
                }
            }

            database.executeUpdate(query);

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change(int id, StudentModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(
                    "UPDATE student SET "
                            + "name='" + model.getName() + "', "
                            + "grade='" + model.getGrade() + "', "
                            + "major='" + model.getMajor() + "' "
                            + "WHERE "
                            + "id='" + id + "'"
                            + ";");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try {
            final Database database = new Database();
            database.executeUpdate("DELETE FROM student WHERE id='" + id + "'");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
