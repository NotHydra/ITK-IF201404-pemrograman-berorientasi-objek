package services;

import java.sql.*;

import providers.Database;
import utilities.CustomDate;
import models.MahasiswaModel;
import models.MahasiswaExtendModel;

public class MahasiswaService
        extends BaseService<MahasiswaModel>
        implements ExtendService<MahasiswaExtendModel> {
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
                            + "id_tempat_lahir, "
                            + "tanggal_lahir, "
                            + "jenis_kelamin, "
                            + "golongan_darah, "
                            + "agama, "
                            + "nomor_telepon, "
                            + "id_tahun_ajaran, "
                            + "id_tahun_masuk, "
                            + "id_program_studi, "
                            + "id_dosen_wali, "
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
                            + "id_tempat_lahir, "
                            + "tanggal_lahir, "
                            + "jenis_kelamin, "
                            + "golongan_darah, "
                            + "agama, "
                            + "nomor_telepon, "
                            + "id_tahun_ajaran, "
                            + "id_tahun_masuk, "
                            + "id_program_studi, "
                            + "id_dosen_wali, "
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
    public MahasiswaExtendModel[] getExtend() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "mahasiswa.id, "
                            + "mahasiswa.nik, "
                            + "mahasiswa.nim, "
                            + "mahasiswa.nama, "
                            + "mahasiswa.email, "
                            + "mahasiswa.password, "
                            + "mahasiswa.alamat, "
                            + "mahasiswa.id_tempat_lahir, "
                            + "mahasiswa.tanggal_lahir, "
                            + "mahasiswa.jenis_kelamin, "
                            + "mahasiswa.golongan_darah, "
                            + "mahasiswa.agama, "
                            + "mahasiswa.nomor_telepon, "
                            + "mahasiswa.id_tahun_ajaran, "
                            + "mahasiswa.id_tahun_masuk, "
                            + "mahasiswa.id_program_studi, "
                            + "mahasiswa.id_dosen_wali, "
                            + "mahasiswa.aktif, "
                            + "mahasiswa.keterangan, "
                            + "tempat_lahir.tempat_lahir, "
                            + "tahun_ajaran.tahun_ajaran, "
                            + "tahun_masuk.tahun_masuk, "
                            + "program_studi.id_jurusan, "
                            + "program_studi.program_studi, "
                            + "program_studi.deskripsi, "
                            + "jurusan.jurusan, "
                            + "jurusan.deskripsi "
                            + "FROM mahasiswa "
                            + "INNER JOIN tempat_lahir ON mahasiswa.id_tempat_lahir=tempat_lahir.id "
                            + "INNER JOIN tahun_ajaran ON mahasiswa.id_tahun_ajaran=tahun_ajaran.id "
                            + "INNER JOIN tahun_masuk ON mahasiswa.id_tahun_masuk=tahun_masuk.id "
                            + "INNER JOIN program_studi ON mahasiswa.id_program_studi=program_studi.id "
                            + "INNER JOIN jurusan ON program_studi.id_jurusan=jurusan.id"
                            + ";");

            final MahasiswaExtendModel[] mahasiswaList = new MahasiswaExtendModel[total];
            int i = 0;
            while (result.next()) {
                mahasiswaList[i] = new MahasiswaExtendModel(
                        result.getInt("mahasiswa.id"),
                        result.getString("mahasiswa.nik"),
                        result.getString("mahasiswa.nim"),
                        result.getString("mahasiswa.nama"),
                        result.getString("mahasiswa.email"),
                        result.getString("mahasiswa.password"),
                        result.getString("mahasiswa.alamat"),
                        result.getInt("mahasiswa.id_tempat_lahir"),
                        result.getString("mahasiswa.tanggal_lahir"),
                        result.getString("mahasiswa.jenis_kelamin"),
                        result.getString("mahasiswa.golongan_darah"),
                        result.getString("mahasiswa.agama"),
                        result.getString("mahasiswa.nomor_telepon"),
                        result.getInt("mahasiswa.id_tahun_ajaran"),
                        result.getInt("mahasiswa.id_tahun_masuk"),
                        result.getInt("mahasiswa.id_program_studi"),
                        result.getInt("mahasiswa.id_dosen_wali"),
                        result.getBoolean("mahasiswa.aktif"),
                        result.getString("mahasiswa.keterangan"),
                        result.getString("tempat_lahir.tempat_lahir"),
                        result.getString("tahun_ajaran.tahun_ajaran"),
                        result.getString("tahun_masuk.tahun_masuk"),
                        result.getInt("program_studi.id_jurusan"),
                        result.getString("program_studi.program_studi"),
                        result.getString("program_studi.deskripsi"),
                        result.getString("jurusan.jurusan"),
                        result.getString("jurusan.deskripsi"));

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
    public MahasiswaExtendModel getOneExtend(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "mahasiswa.id, "
                            + "mahasiswa.nik, "
                            + "mahasiswa.nim, "
                            + "mahasiswa.nama, "
                            + "mahasiswa.email, "
                            + "mahasiswa.password, "
                            + "mahasiswa.alamat, "
                            + "mahasiswa.id_tempat_lahir, "
                            + "mahasiswa.tanggal_lahir, "
                            + "mahasiswa.jenis_kelamin, "
                            + "mahasiswa.golongan_darah, "
                            + "mahasiswa.agama, "
                            + "mahasiswa.nomor_telepon, "
                            + "mahasiswa.id_tahun_ajaran, "
                            + "mahasiswa.id_tahun_masuk, "
                            + "mahasiswa.id_program_studi, "
                            + "mahasiswa.id_dosen_wali, "
                            + "mahasiswa.aktif, "
                            + "mahasiswa.keterangan, "
                            + "tempat_lahir.tempat_lahir, "
                            + "tahun_ajaran.tahun_ajaran, "
                            + "tahun_masuk.tahun_masuk, "
                            + "program_studi.id_jurusan, "
                            + "program_studi.program_studi, "
                            + "program_studi.deskripsi, "
                            + "jurusan.jurusan, "
                            + "jurusan.deskripsi "
                            + "FROM mahasiswa "
                            + "INNER JOIN tempat_lahir ON mahasiswa.id_tempat_lahir=tempat_lahir.id "
                            + "INNER JOIN tahun_ajaran ON mahasiswa.id_tahun_ajaran=tahun_ajaran.id "
                            + "INNER JOIN tahun_masuk ON mahasiswa.id_tahun_masuk=tahun_masuk.id "
                            + "INNER JOIN program_studi ON mahasiswa.id_program_studi=program_studi.id "
                            + "INNER JOIN jurusan ON program_studi.id_jurusan=jurusan.id"
                            + "WHERE id='" + id + "'"
                            + ";");

            MahasiswaExtendModel mahasiswa = null;

            if (result.next()) {
                mahasiswa = new MahasiswaExtendModel(
                        result.getInt("mahasiswa.id"),
                        result.getString("mahasiswa.nik"),
                        result.getString("mahasiswa.nim"),
                        result.getString("mahasiswa.nama"),
                        result.getString("mahasiswa.email"),
                        result.getString("mahasiswa.password"),
                        result.getString("mahasiswa.alamat"),
                        result.getInt("mahasiswa.id_tempat_lahir"),
                        result.getString("mahasiswa.tanggal_lahir"),
                        result.getString("mahasiswa.jenis_kelamin"),
                        result.getString("mahasiswa.golongan_darah"),
                        result.getString("mahasiswa.agama"),
                        result.getString("mahasiswa.nomor_telepon"),
                        result.getInt("mahasiswa.id_tahun_ajaran"),
                        result.getInt("mahasiswa.id_tahun_masuk"),
                        result.getInt("mahasiswa.id_program_studi"),
                        result.getInt("mahasiswa.id_dosen_wali"),
                        result.getBoolean("mahasiswa.aktif"),
                        result.getString("mahasiswa.keterangan"),
                        result.getString("tempat_lahir.tempat_lahir"),
                        result.getString("tahun_ajaran.tahun_ajaran"),
                        result.getString("tahun_masuk.tahun_masuk"),
                        result.getInt("program_studi.id_jurusan"),
                        result.getString("program_studi.program_studi"),
                        result.getString("program_studi.deskripsi"),
                        result.getString("jurusan.jurusan"),
                        result.getString("jurusan.deskripsi"));
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
                    + "id_tempat_lahir, "
                    + "tanggal_lahir, "
                    + "jenis_kelamin, "
                    + "golongan_darah, "
                    + "agama, "
                    + "nomor_telepon, "
                    + "id_tahun_ajaran, "
                    + "id_tahun_masuk, "
                    + "id_program_studi, "
                    + "id_dosen_wali, "
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
                    + (model.getKeterangan() == null ? "NULL" : "'" + model.getKeterangan() + "'")
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
                    + "id_tempat_lahir, "
                    + "tanggal_lahir, "
                    + "jenis_kelamin, "
                    + "golongan_darah, "
                    + "agama, "
                    + "nomor_telepon, "
                    + "id_tahun_ajaran, "
                    + "id_tahun_masuk, "
                    + "id_program_studi, "
                    + "id_dosen_wali, "
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
    public void change(int id, MahasiswaModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(""
                    + "UPDATE " + table + " SET "
                    + "nik='" + model.getNIK() + "', "
                    + "nim='" + model.getNIM() + "', "
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
                    + "id_tahun_ajaran='" + model.getIdTahunAjaran() + "', "
                    + "id_tahun_masuk='" + model.getIdTahunMasuk() + "', "
                    + "id_program_studi='" + model.getIdProgramStudi() + "', "
                    + "id_dosen_wali='" + model.getIdDosenWali() + "', "
                    + "aktif='" + (model.getAktif() ? 1 : 0) + "', "
                    + "keterangan='" + model.getKeterangan() + "'"
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
