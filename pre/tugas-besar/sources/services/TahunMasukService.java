package services;

import java.sql.*;

import providers.Database;
import models.TahunMasukModel;

public class TahunMasukService extends BaseService<TahunMasukModel> {
    private static final String table = "tahun_masuk";

    public TahunMasukService() {
        super(table);
    }

    @Override
    public TahunMasukModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database.executeQuery(""
                    + "SELECT "
                    + "id, "
                    + "tahun_masuk "
                    + "FROM " + table + ""
                    + ";");

            final TahunMasukModel[] tahunMasukList = new TahunMasukModel[total];
            int i = 0;
            while (result.next()) {
                tahunMasukList[i] = new TahunMasukModel(
                        result.getInt("id"),
                        result.getString("tahun_masuk"));

                i++;
            }

            database.close();

            return tahunMasukList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TahunMasukModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "tahun_masuk "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            TahunMasukModel tahunMasuk = null;

            if (result.next()) {
                tahunMasuk = new TahunMasukModel(
                        result.getInt("id"),
                        result.getString("tahun_masuk"));
            }

            database.close();

            return tahunMasuk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(TahunMasukModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "INSERT INTO " + table + " ("
                    + "tahun_masuk"
                    + ") VALUES ("
                    + "'" + model.getTahunMasuk() + "'"
                    + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(TahunMasukModel[] models) {
        try {
            final Database database = new Database();

            String query = ""
                    + "INSERT INTO " + table + " ("
                    + "tahun_masuk"
                    + ") VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getTahunMasuk() + "'"
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
    public void change(int id, TahunMasukModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "UPDATE " + table + " SET "
                    + "tahun_masuk='" + model.getTahunMasuk() + "' "
                    + "WHERE "
                    + "id='" + id + "'"
                    + ";");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
