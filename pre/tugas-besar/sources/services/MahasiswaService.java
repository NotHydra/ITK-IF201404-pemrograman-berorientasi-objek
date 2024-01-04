package services;

import java.sql.*;

import providers.Database;
import utilities.CustomDate;
import models.MahasiswaModel;

public class MahasiswaService extends BaseService<MahasiswaModel> {
    private final String table = "mahasiswa";

    @Override
    public MahasiswaModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "nik, "
                            + "nim, "
                            + "nama, "
                            + "email, "
                            + "password, "
                            + "alamat, "
                            + "id_tempat_lahir , "
                            + "tanggal_lahir, "
                            + "jenis_kelamin, "
                            + "golongan_darah, "
                            + "agama, "
                            + "nomor_telepon, "
                            + "id_tahun_ajaran , "
                            + "id_tahun_masuk , "
                            + "id_program_studi , "
                            + "id_dosen_wali , "
                            + "aktif, "
                            + "keterangan "
                            + "FROM " + table
                            + ";");

            final MahasiswaModel[] mahasiswaList = new MahasiswaModel[total];
            int i = 0;
            while (result.next()) {
                mahasiswaList[i] = new MahasiswaModel(
                        result.getInt("id"),
                        result.getString("nik"),
                        result.getString("nim"),
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
                        result.getInt("id_tahun_ajaran"),
                        result.getInt("id_tahun_masuk"),
                        result.getInt("id_program_studi"),
                        result.getInt("id_dosen_wali"),
                        result.getBoolean("aktif"),
                        result.getString("keterangan"));

                i++;
            }

            database.close();

            return mahasiswaList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public MahasiswaModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "nik, "
                            + "nim, "
                            + "nama, "
                            + "email, "
                            + "password, "
                            + "alamat, "
                            + "id_tempat_lahir , "
                            + "tanggal_lahir, "
                            + "jenis_kelamin, "
                            + "golongan_darah, "
                            + "agama, "
                            + "nomor_telepon, "
                            + "id_tahun_ajaran , "
                            + "id_tahun_masuk , "
                            + "id_program_studi , "
                            + "id_dosen_wali , "
                            + "aktif, "
                            + "keterangan "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            MahasiswaModel mahasiswa = null;

            if (result.next()) {
                mahasiswa = new MahasiswaModel(
                        result.getInt("id"),
                        result.getString("nik"),
                        result.getString("nim"),
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
                        result.getInt("id_tahun_ajaran"),
                        result.getInt("id_tahun_masuk"),
                        result.getInt("id_program_studi"),
                        result.getInt("id_dosen_wali"),
                        result.getBoolean("aktif"),
                        result.getString("keterangan"));
            }

            database.close();

            return mahasiswa;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(MahasiswaModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "INSERT INTO " + table + " ("
                    + "nik, "
                    + "nim, "
                    + "nama, "
                    + "email, "
                    + "password, "
                    + "alamat, "
                    + "id_tempat_lahir , "
                    + "tanggal_lahir, "
                    + "jenis_kelamin, "
                    + "golongan_darah, "
                    + "agama, "
                    + "nomor_telepon, "
                    + "id_tahun_ajaran , "
                    + "id_tahun_masuk , "
                    + "id_program_studi , "
                    + "id_dosen_wali , "
                    + "aktif, "
                    + "keterangan"
                    + ") VALUES ("
                    + "'" + model.getNIK() + "', "
                    + "'" + model.getNIM() + "', "
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
                    + "'" + model.getIdTahunAjaran() + "', "
                    + "'" + model.getIdTahunMasuk() + "', "
                    + "'" + model.getIdProgramStudi() + "', "
                    + "'" + model.getIdDosenWali() + "', "
                    + "'" + (model.getAktif() ? 1 : 0) + "', "
                    + "'" + model.getKeterangan() + "'"
                    + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(MahasiswaModel[] models) {
        try {
            final Database database = new Database();

            String query = ""
                    + "INSERT INTO " + table + " ("
                    + "nik, "
                    + "nim, "
                    + "nama, "
                    + "email, "
                    + "password, "
                    + "alamat, "
                    + "id_tempat_lahir , "
                    + "tanggal_lahir, "
                    + "jenis_kelamin, "
                    + "golongan_darah, "
                    + "agama, "
                    + "nomor_telepon, "
                    + "id_tahun_ajaran , "
                    + "id_tahun_masuk , "
                    + "id_program_studi , "
                    + "id_dosen_wali , "
                    + "aktif, "
                    + "keterangan"
                    + ") VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getNIK() + "', "
                        + "'" + models[i].getNIM() + "', "
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
                        + "'" + models[i].getIdTahunAjaran() + "', "
                        + "'" + models[i].getIdTahunMasuk() + "', "
                        + "'" + models[i].getIdProgramStudi() + "', "
                        + "'" + models[i].getIdDosenWali() + "', "
                        + "'" + (models[i].getAktif() ? 1 : 0) + "', "
                        + "'" + models[i].getKeterangan() + "'"
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
    public void change(int id, MahasiswaModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'change'");
    }

    @Override
    public void remove(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    // @Override
    // public void change(int id, ProgramStudiModel model) {
    // try {
    // final Database database = new Database();
    // database.executeUpdate(""
    // + "UPDATE " + table + " SET "
    // + "id_jurusan='" + model.getIdJurusan() + "', "
    // + "program_studi='" + model.getProgramStudi() + "', "
    // + "deskripsi='" + model.getDeskripsi() + "' "
    // + "WHERE "
    // + "id='" + id + "'"
    // + ";");

    // database.close();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    // @Override
    // public void remove(int id) {
    // try {
    // final Database database = new Database();
    // database.executeUpdate("DELETE FROM " + table + " WHERE id='" + id + "'");

    // database.close();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

}
