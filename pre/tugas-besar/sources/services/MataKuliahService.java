package services;

import java.sql.*;

import providers.Database;
import models.MataKuliahModel;

public class MataKuliahService extends BaseService<MataKuliahModel> {
    private final String table = "mata_kuliah";

    @Override
    public MataKuliahModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "kode, "
                            + "mata_kuliah, "
                            + "deskripsi, "
                            + "sks "
                            + "FROM " + table
                            + ";");

            final MataKuliahModel[] mataKuliahList = new MataKuliahModel[total];
            int i = 0;
            while (result.next()) {
                mataKuliahList[i] = new MataKuliahModel(
                        result.getInt("id"),
                        result.getString("kode"),
                        result.getString("mata_kuliah"),
                        result.getString("deskripsi"),
                        result.getInt("sks"));

                i++;
            }

            database.close();

            return mataKuliahList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public MataKuliahModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "kode, "
                            + "mata_kuliah, "
                            + "deskripsi, "
                            + "sks "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            MataKuliahModel mataKuliah = null;

            if (result.next()) {
                mataKuliah = new MataKuliahModel(
                        result.getInt("id"),
                        result.getString("kode"),
                        result.getString("mata_kuliah"),
                        result.getString("deskripsi"),
                        result.getInt("sks"));
            }

            database.close();

            return mataKuliah;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(MataKuliahModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "INSERT INTO " + table + " ("
                    + "kode, "
                    + "mata_kuliah, "
                    + "deskripsi, "
                    + "sks "
                    + ") VALUES ("
                    + "'" + model.getKode() + "', "
                    + "'" + model.getMataKuliah() + "', "
                    + "'" + model.getDeskripsi() + "', "
                    + "'" + model.getSKS() + "'"
                    + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(MataKuliahModel[] models) {
        try {
            final Database database = new Database();

            String query = ""
                    + "INSERT INTO " + table + " ("
                    + "kode, "
                    + "mata_kuliah, "
                    + "deskripsi, "
                    + "sks "
                    + ") VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getKode() + "', "
                        + "'" + models[i].getMataKuliah() + "', "
                        + "'" + models[i].getDeskripsi() + "', "
                        + "'" + models[i].getSKS() + "'"
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
    public void change(int id, MataKuliahModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "UPDATE " + table + " SET "
                    + "kode='" + model.getKode() + "', "
                    + "mata_kuliah='" + model.getMataKuliah() + "', "
                    + "deskripsi='" + model.getDeskripsi() + "', "
                    + "sks='" + model.getSKS() + "' "
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
