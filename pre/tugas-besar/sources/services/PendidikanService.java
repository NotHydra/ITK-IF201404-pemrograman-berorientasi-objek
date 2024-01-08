package services;

import java.sql.*;

import providers.Database;
import models.PendidikanModel;

public class PendidikanService extends BaseService<PendidikanModel> {
    private static final String table = "pendidikan";

    public PendidikanService() {
        super(table);
    }

    @Override
    public PendidikanModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database.executeQuery(""
                    + "SELECT "
                    + "id, "
                    + "pendidikan, "
                    + "singkatan "
                    + "FROM " + table + ""
                    + ";");

            final PendidikanModel[] pendidikanList = new PendidikanModel[total];
            int i = 0;
            while (result.next()) {
                pendidikanList[i] = new PendidikanModel(
                        result.getInt("id"),
                        result.getString("pendidikan"),
                        result.getString("singkatan"));

                i++;
            }

            database.close();

            return pendidikanList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public PendidikanModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "pendidikan, "
                            + "singkatan "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            PendidikanModel pendidikan = null;

            if (result.next()) {
                pendidikan = new PendidikanModel(
                        result.getInt("id"),
                        result.getString("pendidikan"),
                        result.getString("singkatan"));
            }

            database.close();

            return pendidikan;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(PendidikanModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "INSERT INTO " + table + " ("
                    + "pendidikan, "
                    + "singkatan"
                    + ") VALUES ("
                    + "'" + model.getPendidikan() + "', "
                    + "'" + model.getSingkatan() + "'"
                    + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(PendidikanModel[] models) {
        try {
            final Database database = new Database();

            String query = ""
                    + "INSERT INTO " + table + " ("
                    + "pendidikan, "
                    + "singkatan"
                    + ") VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getPendidikan() + "', "
                        + "'" + models[i].getSingkatan() + "'"
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
    public void change(int id, PendidikanModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "UPDATE " + table + " SET "
                    + "pendidikan='" + model.getPendidikan() + "', "
                    + "singkatan='" + model.getSingkatan() + "' "
                    + "WHERE "
                    + "id='" + id + "'"
                    + ";");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
