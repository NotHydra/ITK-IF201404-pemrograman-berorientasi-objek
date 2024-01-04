package services;

import java.sql.*;

import providers.Database;
import models.RuanganModel;

public class RuanganService extends BaseService<RuanganModel> {
    private final String table = "ruangan";

    @Override
    public RuanganModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database.executeQuery(""
                    + "SELECT "
                    + "id, "
                    + "ruangan "
                    + "FROM " + table + ""
                    + ";");

            final RuanganModel[] ruanganList = new RuanganModel[total];
            int i = 0;
            while (result.next()) {
                ruanganList[i] = new RuanganModel(
                        result.getInt("id"),
                        result.getString("ruangan"));

                i++;
            }

            database.close();

            return ruanganList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public RuanganModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "ruangan "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            RuanganModel ruangan = null;

            if (result.next()) {
                ruangan = new RuanganModel(
                        result.getInt("id"),
                        result.getString("ruangan"));
            }

            database.close();

            return ruangan;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(RuanganModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "INSERT INTO " + table + " ("
                    + "ruangan"
                    + ") VALUES ("
                    + "'" + model.getRuangan() + "'"
                    + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(RuanganModel[] models) {
        try {
            final Database database = new Database();

            String query = ""
                    + "INSERT INTO " + table + " ("
                    + "ruangan"
                    + ") VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getRuangan() + "'"
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
    public void change(int id, RuanganModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "UPDATE " + table + " SET "
                    + "ruangan='" + model.getRuangan() + "' "
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
