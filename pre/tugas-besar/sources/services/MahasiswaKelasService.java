package services;

import java.sql.*;

import providers.Database;
import enums.IndeksEnum;
import models.MahasiswaKelasModel;

public class MahasiswaKelasService extends BaseService<MahasiswaKelasModel> {
    private final String table = "mahasiswa_kelas";

    @Override
    public MahasiswaKelasModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "id_kelas, "
                            + "id_mahasiswa, "
                            + "indeks "
                            + "FROM " + table
                            + ";");

            final MahasiswaKelasModel[] programStudiList = new MahasiswaKelasModel[total];
            int i = 0;
            while (result.next()) {
                programStudiList[i] = new MahasiswaKelasModel(
                        result.getInt("id"),
                        result.getInt("id_kelas"),
                        result.getInt("id_mahasiswa"),
                        IndeksEnum.valueToEnum(result.getString("indeks")));

                i++;
            }

            database.close();

            return programStudiList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public MahasiswaKelasModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "id_kelas, "
                            + "id_mahasiswa, "
                            + "indeks "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            MahasiswaKelasModel mahasiswaKelas = null;

            if (result.next()) {
                mahasiswaKelas = new MahasiswaKelasModel(
                        result.getInt("id"),
                        result.getInt("id_kelas"),
                        result.getInt("id_mahasiswa"),
                        IndeksEnum.valueToEnum(result.getString("indeks")));
            }

            database.close();

            return mahasiswaKelas;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(MahasiswaKelasModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "INSERT INTO " + table + " ("
                    + "id_kelas, "
                    + "id_mahasiswa, "
                    + "indeks"
                    + ") VALUES ("
                    + "'" + model.getIdKelas() + "', "
                    + "'" + model.getIdMahasiswa() + "', "
                    + (model.getIndeks() == null ? "NULL" : "'" + model.getIndeks() + "'")
                    + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(MahasiswaKelasModel[] models) {
        try {
            final Database database = new Database();

            String query = ""
                    + "INSERT INTO " + table + " ("
                    + "id_kelas, "
                    + "id_mahasiswa, "
                    + "indeks"
                    + ") VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getIdKelas() + "', "
                        + "'" + models[i].getIdMahasiswa() + "', "
                        + (models[i].getIndeks() == null ? "NULL" : "'" + models[i].getIndeks() + "'")
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
    public void change(int id, MahasiswaKelasModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "UPDATE " + table + " SET "
                    + "id_kelas='" + model.getIdKelas() + "', "
                    + "id_mahasiswa='" + model.getIdMahasiswa() + "', "
                    + "indeks='" + model.getIndeks() + "' "
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
