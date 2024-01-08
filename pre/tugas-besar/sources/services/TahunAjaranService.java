package services;

import java.sql.*;

import providers.Database;
import models.TahunAjaranModel;

public class TahunAjaranService extends BaseService<TahunAjaranModel> {
    private static final String table = "tahun_ajaran";

    public TahunAjaranService() {
        super(table);
    }

    @Override
    public TahunAjaranModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database.executeQuery(""
                    + "SELECT "
                    + "id, "
                    + "tahun_ajaran "
                    + "FROM " + table + ""
                    + ";");

            final TahunAjaranModel[] tahunAjaranList = new TahunAjaranModel[total];
            int i = 0;
            while (result.next()) {
                tahunAjaranList[i] = new TahunAjaranModel(
                        result.getInt("id"),
                        result.getString("tahun_ajaran"));

                i++;
            }

            database.close();

            return tahunAjaranList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TahunAjaranModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "tahun_ajaran "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            TahunAjaranModel tahunAjaran = null;

            if (result.next()) {
                tahunAjaran = new TahunAjaranModel(
                        result.getInt("id"),
                        result.getString("tahun_ajaran"));
            }

            database.close();

            return tahunAjaran;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(TahunAjaranModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "INSERT INTO " + table + " ("
                    + "tahun_ajaran"
                    + ") VALUES ("
                    + "'" + model.getTahunAjaran() + "'"
                    + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(TahunAjaranModel[] models) {
        try {
            final Database database = new Database();

            String query = ""
                    + "INSERT INTO " + table + " ("
                    + "tahun_ajaran"
                    + ") VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getTahunAjaran() + "'"
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
    public void change(int id, TahunAjaranModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "UPDATE " + table + " SET "
                    + "tahun_ajaran='" + model.getTahunAjaran() + "' "
                    + "WHERE "
                    + "id='" + id + "'"
                    + ";");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
