package services;

import java.sql.*;

import providers.Database;
import enums.JenisKelaminEnum;
import enums.GolonganDarahEnum;
import enums.AgamaEnum;
import utilities.CustomDate;
import models.DosenModel;
import models.DosenExtendModel;

public class DosenService extends BaseService<DosenModel> implements ExtendService<DosenExtendModel> {
    private static final String table = "dosen";

    public DosenService() {
        super(table);
    }

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
                        JenisKelaminEnum.valueToEnum(result.getString("jenis_kelamin")),
                        GolonganDarahEnum.valueToEnum(result.getString("golongan_darah")),
                        AgamaEnum.valueToEnum(result.getString("agama")),
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
                        JenisKelaminEnum.valueToEnum(result.getString("jenis_kelamin")),
                        GolonganDarahEnum.valueToEnum(result.getString("golongan_darah")),
                        AgamaEnum.valueToEnum(result.getString("agama")),
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
    public DosenExtendModel[] getExtend() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "dosen.id, "
                            + "dosen.nik, "
                            + "dosen.nip, "
                            + "dosen.nama, "
                            + "dosen.email, "
                            + "dosen.password, "
                            + "dosen.alamat, "
                            + "dosen.id_tempat_lahir, "
                            + "dosen.tanggal_lahir, "
                            + "dosen.jenis_kelamin, "
                            + "dosen.golongan_darah, "
                            + "dosen.agama, "
                            + "dosen.nomor_telepon, "
                            + "dosen.id_pendidikan, "
                            + "dosen.id_program_studi, "
                            + "dosen.aktif, "
                            + "dosen.keterangan, "
                            + "tempat_lahir.tempat_lahir, "
                            + "pendidikan.pendidikan, "
                            + "pendidikan.singkatan, "
                            + "program_studi.id_jurusan, "
                            + "program_studi.program_studi, "
                            + "program_studi.deskripsi, "
                            + "jurusan.jurusan, "
                            + "jurusan.deskripsi "
                            + "FROM dosen "
                            + "INNER JOIN tempat_lahir ON dosen.id_tempat_lahir=tempat_lahir.id "
                            + "INNER JOIN pendidikan ON dosen.id_pendidikan=pendidikan.id "
                            + "INNER JOIN program_studi ON dosen.id_program_studi=program_studi.id "
                            + "INNER JOIN jurusan ON program_studi.id_jurusan=jurusan.id"
                            + ";");

            final DosenExtendModel[] dosenList = new DosenExtendModel[total];
            int i = 0;
            while (result.next()) {
                dosenList[i] = new DosenExtendModel(
                        result.getInt("dosen.id"),
                        result.getString("dosen.nik"),
                        result.getString("dosen.nip"),
                        result.getString("dosen.nama"),
                        result.getString("dosen.email"),
                        result.getString("dosen.password"),
                        result.getString("dosen.alamat"),
                        result.getInt("dosen.id_tempat_lahir"),
                        result.getString("dosen.tanggal_lahir"),
                        JenisKelaminEnum.valueToEnum(result.getString("dosen.jenis_kelamin")),
                        GolonganDarahEnum.valueToEnum(result.getString("dosen.golongan_darah")),
                        AgamaEnum.valueToEnum(result.getString("dosen.agama")),
                        result.getString("dosen.nomor_telepon"),
                        result.getInt("dosen.id_pendidikan"),
                        result.getInt("dosen.id_program_studi"),
                        result.getBoolean("dosen.aktif"),
                        result.getString("dosen.keterangan"),
                        result.getString("tempat_lahir.tempat_lahir"),
                        result.getString("pendidikan.pendidikan"),
                        result.getString("pendidikan.singkatan"),
                        result.getInt("program_studi.id_jurusan"),
                        result.getString("program_studi.program_studi"),
                        result.getString("program_studi.deskripsi"),
                        result.getString("jurusan.jurusan"),
                        result.getString("jurusan.deskripsi"));

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
    public DosenExtendModel getOneExtend(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "dosen.id, "
                            + "dosen.nik, "
                            + "dosen.nip, "
                            + "dosen.nama, "
                            + "dosen.email, "
                            + "dosen.password, "
                            + "dosen.alamat, "
                            + "dosen.id_tempat_lahir, "
                            + "dosen.tanggal_lahir, "
                            + "dosen.jenis_kelamin, "
                            + "dosen.golongan_darah, "
                            + "dosen.agama, "
                            + "dosen.nomor_telepon, "
                            + "dosen.id_pendidikan, "
                            + "dosen.id_program_studi, "
                            + "dosen.aktif, "
                            + "dosen.keterangan, "
                            + "tempat_lahir.tempat_lahir, "
                            + "pendidikan.pendidikan, "
                            + "pendidikan.singkatan, "
                            + "program_studi.id_jurusan, "
                            + "program_studi.program_studi, "
                            + "program_studi.deskripsi, "
                            + "jurusan.jurusan, "
                            + "jurusan.deskripsi "
                            + "FROM dosen "
                            + "INNER JOIN tempat_lahir ON dosen.id_tempat_lahir=tempat_lahir.id "
                            + "INNER JOIN pendidikan ON dosen.id_pendidikan=pendidikan.id "
                            + "INNER JOIN program_studi ON dosen.id_program_studi=program_studi.id "
                            + "INNER JOIN jurusan ON program_studi.id_jurusan=jurusan.id "
                            + "WHERE dosen.id='" + id + "'"
                            + ";");

            DosenExtendModel dosen = null;

            if (result.next()) {
                dosen = new DosenExtendModel(
                        result.getInt("dosen.id"),
                        result.getString("dosen.nik"),
                        result.getString("dosen.nip"),
                        result.getString("dosen.nama"),
                        result.getString("dosen.email"),
                        result.getString("dosen.password"),
                        result.getString("dosen.alamat"),
                        result.getInt("dosen.id_tempat_lahir"),
                        result.getString("dosen.tanggal_lahir"),
                        JenisKelaminEnum.valueToEnum(result.getString("dosen.jenis_kelamin")),
                        GolonganDarahEnum.valueToEnum(result.getString("dosen.golongan_darah")),
                        AgamaEnum.valueToEnum(result.getString("dosen.agama")),
                        result.getString("dosen.nomor_telepon"),
                        result.getInt("dosen.id_pendidikan"),
                        result.getInt("dosen.id_program_studi"),
                        result.getBoolean("dosen.aktif"),
                        result.getString("dosen.keterangan"),
                        result.getString("tempat_lahir.tempat_lahir"),
                        result.getString("pendidikan.pendidikan"),
                        result.getString("pendidikan.singkatan"),
                        result.getInt("program_studi.id_jurusan"),
                        result.getString("program_studi.program_studi"),
                        result.getString("program_studi.deskripsi"),
                        result.getString("jurusan.jurusan"),
                        result.getString("jurusan.deskripsi"));
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
                    + "'" + model.getJenisKelamin().value + "', "
                    + "'" + model.getGolonganDarah().value + "', "
                    + "'" + model.getAgama().value + "', "
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
                        + "'" + models[i].getJenisKelamin().value + "', "
                        + "'" + models[i].getGolonganDarah().value + "', "
                        + "'" + models[i].getAgama().value + "', "
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
                    + "jenis_kelamin='" + model.getJenisKelamin().value + "', "
                    + "golongan_darah='" + model.getGolonganDarah().value + "', "
                    + "agama='" + model.getAgama().value + "', "
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
}
