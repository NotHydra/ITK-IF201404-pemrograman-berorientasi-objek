package services;

import java.sql.*;

import providers.Database;
import utilities.CustomDate;
import models.DosenModel;

public class DosenService extends BaseService<DosenModel> {
    private final String table = "dosen";

    @Override
    public DosenModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "nik, "
                            + "nip, "
                            + "nama, "
                            + "email, "
                            + "password, "
                            + "alamat, "
                            + "id_tempat_lahir, "
                            + "tanggal_lahir, "
                            + "jenis_kelamin, "
                            + "golongan_darah, "
                            + "agama, "
                            + "nomor_telepon, "
                            + "id_pendidikan, "
                            + "id_program_studi, "
                            + "aktif, "
                            + "keterangan "
                            + "FROM " + table
                            + ";");

            final DosenModel[] dosenList = new DosenModel[total];
            int i = 0;
            while (result.next()) {
                dosenList[i] = new DosenModel(
                        result.getInt("id"),
                        result.getString("nik"),
                        result.getString("nip"),
                        result.getString("nama"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("alamat"),
                        result.getInt("id_tempat_lahir"),
                        result.getString("tanggal_lahir"),
                        result.getString("jenis_kelamin"),
                        result.getString("golongan_darah"),
                        result.getString("agama"),
                        result.getString("nomor_telepon"),
                        result.getInt("id_pendidikan"),
                        result.getInt("id_program_studi"),
                        result.getBoolean("aktif"),
                        result.getString("keterangan"));

                i++;
            }

            database.close();

            return dosenList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public DosenModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "nik, "
                            + "nip, "
                            + "nama, "
                            + "email, "
                            + "password, "
                            + "alamat, "
                            + "id_tempat_lahir, "
                            + "tanggal_lahir, "
                            + "jenis_kelamin, "
                            + "golongan_darah, "
                            + "agama, "
                            + "nomor_telepon, "
                            + "id_pendidikan, "
                            + "id_program_studi, "
                            + "aktif, "
                            + "keterangan "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            DosenModel dosen = null;

            if (result.next()) {
                dosen = new DosenModel(
                        result.getInt("id"),
                        result.getString("nik"),
                        result.getString("nip"),
                        result.getString("nama"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("alamat"),
                        result.getInt("id_tempat_lahir"),
                        result.getString("tanggal_lahir"),
                        result.getString("jenis_kelamin"),
                        result.getString("golongan_darah"),
                        result.getString("agama"),
                        result.getString("nomor_telepon"),
                        result.getInt("id_pendidikan"),
                        result.getInt("id_program_studi"),
                        result.getBoolean("aktif"),
                        result.getString("keterangan"));
            }

            database.close();

            return dosen;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(DosenModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "INSERT INTO " + table + " ("
                    + "nik, "
                    + "nip, "
                    + "nama, "
                    + "email, "
                    + "password, "
                    + "alamat, "
                    + "id_tempat_lahir, "
                    + "tanggal_lahir, "
                    + "jenis_kelamin, "
                    + "golongan_darah, "
                    + "agama, "
                    + "nomor_telepon, "
                    + "id_pendidikan, "
                    + "id_program_studi, "
                    + "aktif, "
                    + "keterangan"
                    + ") VALUES ("
                    + "'" + model.getNIK() + "', "
                    + "'" + model.getNIP() + "', "
                    + "'" + model.getNama() + "', "
                    + "'" + model.getEmail() + "', "
                    + "'" + model.getPassword() + "', "
                    + "'" + model.getAlamat() + "', "
                    + "'" + model.getIdTempatLahir() + "', "
                    + "'" + CustomDate.dateToSQL(model.getTanggalLahir()) + "', "
                    + "'" + model.getJenisKelamin() + "', "
                    + "'" + model.getGolonganDarah() + "', "
                    + "'" + model.getAgama() + "', "
                    + "'" + model.getNomorTelepon() + "', "
                    + "'" + model.getIdPendidikan() + "', "
                    + "'" + model.getIdProgramStudi() + "', "
                    + "'" + (model.getAktif() ? 1 : 0) + "', "
                    + (model.getKeterangan() == null ? "NULL" : "'" + model.getKeterangan() + "'")
                    + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(DosenModel[] models) {
        try {
            final Database database = new Database();

            String query = ""
                    + "INSERT INTO " + table + " ("
                    + "nik, "
                    + "nip, "
                    + "nama, "
                    + "email, "
                    + "password, "
                    + "alamat, "
                    + "id_tempat_lahir, "
                    + "tanggal_lahir, "
                    + "jenis_kelamin, "
                    + "golongan_darah, "
                    + "agama, "
                    + "nomor_telepon, "
                    + "id_pendidikan, "
                    + "id_program_studi, "
                    + "aktif, "
                    + "keterangan"
                    + ") VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getNIK() + "', "
                        + "'" + models[i].getNIP() + "', "
                        + "'" + models[i].getNama() + "', "
                        + "'" + models[i].getEmail() + "', "
                        + "'" + models[i].getPassword() + "', "
                        + "'" + models[i].getAlamat() + "', "
                        + "'" + models[i].getIdTempatLahir() + "', "
                        + "'" + CustomDate.dateToSQL(models[i].getTanggalLahir()) + "', "
                        + "'" + models[i].getJenisKelamin() + "', "
                        + "'" + models[i].getGolonganDarah() + "', "
                        + "'" + models[i].getAgama() + "', "
                        + "'" + models[i].getNomorTelepon() + "', "
                        + "'" + models[i].getIdPendidikan() + "', "
                        + "'" + models[i].getIdProgramStudi() + "', "
                        + "'" + (models[i].getAktif() ? 1 : 0) + "', "
                        + (models[i].getKeterangan() == null ? "NULL" : "'" + models[i].getKeterangan() + "'")
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
    public void change(int id, DosenModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "UPDATE " + table + " SET "
                    + "nik='" + model.getNIK() + "', "
                    + "nip='" + model.getNIP() + "', "
                    + "nama='" + model.getNama() + "', "
                    + "email='" + model.getEmail() + "', "
                    + "password='" + model.getPassword() + "', "
                    + "alamat='" + model.getAlamat() + "', "
                    + "id_tempat_lahir='" + model.getIdTempatLahir() + "', "
                    + "tanggal_lahir='" + CustomDate.dateToSQL(model.getTanggalLahir()) + "', "
                    + "jenis_kelamin='" + model.getJenisKelamin() + "', "
                    + "golongan_darah='" + model.getGolonganDarah() + "', "
                    + "agama='" + model.getAgama() + "', "
                    + "nomor_telepon='" + model.getNomorTelepon() + "', "
                    + "id_program_studi='" + model.getIdPendidikan() + "', "
                    + "id_program_studi='" + model.getIdProgramStudi() + "', "
                    + "aktif='" + (model.getAktif() ? 1 : 0) + "', "
                    + "keterangan=" + (model.getKeterangan() == null ? "NULL " : "'" + model.getKeterangan() + "' ")
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
