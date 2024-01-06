package services;

import java.sql.*;

import enums.SesiEnum;
import providers.Database;
import models.KelasModel;

public class KelasService extends BaseService<KelasModel> {
    private final String table = "kelas";

    @Override
    public KelasModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "id_dosen, "
                            + "id_mata_kuliah, "
                            + "tipe_kelas, "
                            + "id_ruangan, "
                            + "sesi, "
                            + "tahun_ajaran "
                            + "FROM " + table
                            + ";");

            final KelasModel[] kelasList = new KelasModel[total];
            int i = 0;
            while (result.next()) {
                kelasList[i] = new KelasModel(
                        result.getInt("id"),
                        result.getInt("id_dosen"),
                        result.getInt("id_mata_kuliah"),
                        result.getString("tipe_kelas").charAt(0),
                        result.getInt("id_ruangan"),
                        SesiEnum.valueToEnum(result.getString("sesi")),
                        result.getString("tahun_ajaran"));

                i++;
            }

            database.close();

            return kelasList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public KelasModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "id_dosen, "
                            + "id_mata_kuliah, "
                            + "tipe_kelas, "
                            + "id_ruangan, "
                            + "sesi, "
                            + "tahun_ajaran "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            KelasModel kelas = null;

            if (result.next()) {
                kelas = new KelasModel(
                        result.getInt("id"),
                        result.getInt("id_dosen"),
                        result.getInt("id_mata_kuliah"),
                        result.getString("tipe_kelas").charAt(0),
                        result.getInt("id_ruangan"),
                        SesiEnum.valueToEnum(result.getString("sesi")),
                        result.getString("tahun_ajaran"));
            }

            database.close();

            return kelas;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(KelasModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "INSERT INTO " + table + " ("
                    + "id_dosen, "
                    + "id_mata_kuliah, "
                    + "tipe_kelas, "
                    + "id_ruangan, "
                    + "sesi, "
                    + "tahun_ajaran"
                    + ") VALUES ("
                    + "'" + model.getIdDosen() + "', "
                    + "'" + model.getIdMataKuliah() + "', "
                    + "'" + model.getTipeKelas() + "', "
                    + "'" + model.getIdRuangan() + "', "
                    + "'" + model.getSesi() + "', "
                    + "'" + model.getTahunAjaran() + "'"
                    + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(KelasModel[] models) {
        try {
            final Database database = new Database();

            String query = ""
                    + "INSERT INTO " + table + " ("
                    + "id_dosen, "
                    + "id_mata_kuliah, "
                    + "tipe_kelas, "
                    + "id_ruangan, "
                    + "sesi, "
                    + "tahun_ajaran"
                    + ") VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getIdDosen() + "', "
                        + "'" + models[i].getIdMataKuliah() + "', "
                        + "'" + models[i].getTipeKelas() + "', "
                        + "'" + models[i].getIdRuangan() + "', "
                        + "'" + models[i].getSesi() + "', "
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
    public void change(int id, KelasModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "UPDATE " + table + " SET "
                    + "id_dosen='" + model.getIdDosen() + "', "
                    + "id_mata_kuliah='" + model.getIdMataKuliah() + "', "
                    + "tipe_kelas='" + model.getTipeKelas() + "', "
                    + "id_ruangan='" + model.getIdRuangan() + "', "
                    + "sesi='" + model.getSesi() + "', "
                    + "tahun_ajaran='" + model.getTahunAjaran() + "' "
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
