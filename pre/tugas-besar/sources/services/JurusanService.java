package services;

import java.sql.*;

import providers.Database;
import models.JurusanModel;

public class JurusanService extends BaseService<JurusanModel> {
    private final String table = "jurusan";

    @Override
    public JurusanModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database.executeQuery(""
                    + "SELECT "
                    + "id, "
                    + "jurusan, "
                    + "deskripsi "
                    + "FROM " + table + ""
                    + ";");

            final JurusanModel[] jurusanList = new JurusanModel[total];
            int i = 0;
            while (result.next()) {
                jurusanList[i] = new JurusanModel(
                        result.getInt("id"),
                        result.getString("jurusan"),
                        result.getString("deskripsi"));

                i++;
            }

            database.close();

            return jurusanList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public JurusanModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "jurusan, "
                            + "deskripsi "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            JurusanModel jurusan = null;

            if (result.next()) {
                jurusan = new JurusanModel(
                        result.getInt("id"),
                        result.getString("jurusan"),
                        result.getString("deskripsi"));
            }

            database.close();

            return jurusan;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(JurusanModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "INSERT INTO " + table + " ("
                    + "jurusan, "
                    + "deskripsi"
                    + ") VALUES ("
                    + "'" + model.getJurusan() + "', "
                    + "'" + model.getDeskripsi() + "'"
                    + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(JurusanModel[] models) {
        try {
            final Database database = new Database();

            String query = ""
                    + "INSERT INTO " + table + " ("
                    + "jurusan, "
                    + "deskripsi"
                    + ") VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getJurusan() + "', "
                        + "'" + models[i].getDeskripsi() + "'"
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
    public void change(int id, JurusanModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "UPDATE " + table + " SET "
                    + "jurusan='" + model.getJurusan() + "', "
                    + "deskripsi='" + model.getDeskripsi() + "' "
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

    public void clear() {
        try {
            final Database database = new Database();
            database.disableForeignKey();
            database.executeUpdate("TRUNCATE TABLE " + table + ";");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
