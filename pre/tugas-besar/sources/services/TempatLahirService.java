package services;

import java.sql.*;

import providers.Database;
import models.TempatLahirModel;

public class TempatLahirService extends BaseService<TempatLahirModel> {
    private final String table = "tempat_lahir";

    @Override
    public TempatLahirModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database.executeQuery(""
                    + "SELECT "
                    + "id, "
                    + "tempat_lahir "
                    + "FROM " + table + ""
                    + ";");

            final TempatLahirModel[] tempatLahirList = new TempatLahirModel[total];
            int i = 0;
            while (result.next()) {
                tempatLahirList[i] = new TempatLahirModel(
                        result.getInt("id"),
                        result.getString("tempat_lahir"));

                i++;
            }

            database.close();

            return tempatLahirList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TempatLahirModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "tempat_lahir "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            TempatLahirModel tempatLahir = null;

            if (result.next()) {
                tempatLahir = new TempatLahirModel(
                        result.getInt("id"),
                        result.getString("tempat_lahir"));
            }

            database.close();

            return tempatLahir;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(TempatLahirModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "INSERT INTO " + table + " ("
                    + "tempat_lahir"
                    + ") VALUES ("
                    + "'" + model.getTempatLahir() + "'"
                    + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(TempatLahirModel[] models) {
        try {
            final Database database = new Database();

            String query = ""
                    + "INSERT INTO " + table + " ("
                    + "tempat_lahir"
                    + ") VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getTempatLahir() + "'"
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
    public void change(int id, TempatLahirModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "UPDATE " + table + " SET "
                    + "tempat_lahir='" + model.getTempatLahir() + "' "
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
            database.executeUpdate("DELETE FROM " + table + " WHERE id='" + id + "'");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
