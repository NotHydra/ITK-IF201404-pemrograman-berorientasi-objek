package services;

import java.sql.*;

import enums.AgamaEnum;
import enums.GolonganDarahEnum;
import enums.JenisKelaminEnum;
import enums.SesiEnum;
import providers.Database;
import models.KelasExtendModel;
import models.KelasModel;

public class KelasService
        extends BaseService<KelasModel>
        implements ExtendService<KelasExtendModel> {
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
    public KelasExtendModel[] getExtend() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "kelas.id, "
                            + "kelas.id_dosen, "
                            + "kelas.id_mata_kuliah, "
                            + "kelas.tipe_kelas, "
                            + "kelas.id_ruangan, "
                            + "kelas.sesi, "
                            + "kelas.tahun_ajaran, "
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
                            + "dosen_tempat_lahir.tempat_lahir, "
                            + "dosen_pendidikan.pendidikan, "
                            + "dosen_pendidikan.singkatan, "
                            + "dosen_program_studi.id_jurusan, "
                            + "dosen_program_studi.program_studi, "
                            + "dosen_program_studi.deskripsi, "
                            + "dosen_jurusan.jurusan, "
                            + "dosen_jurusan.deskripsi, "
                            + "mata_kuliah.kode, "
                            + "mata_kuliah.mata_kuliah, "
                            + "mata_kuliah.deskripsi, "
                            + "mata_kuliah.sks, "
                            + "ruangan.ruangan "
                            + "FROM kelas "
                            + "INNER JOIN dosen ON kelas.id_dosen=dosen.id "
                            + "INNER JOIN tempat_lahir AS `dosen_tempat_lahir` ON dosen.id_tempat_lahir=dosen_tempat_lahir.id "
                            + "INNER JOIN pendidikan AS `dosen_pendidikan` ON dosen.id_pendidikan=dosen_pendidikan.id "
                            + "INNER JOIN program_studi AS `dosen_program_studi` ON dosen.id_program_studi=dosen_program_studi.id "
                            + "INNER JOIN jurusan AS `dosen_jurusan` ON dosen_program_studi.id_jurusan=dosen_jurusan.id "
                            + "INNER JOIN mata_kuliah ON kelas.id_mata_kuliah=mata_kuliah.id "
                            + "INNER JOIN ruangan ON kelas.id_ruangan=ruangan.id"
                            + ";");

            final KelasExtendModel[] kelasList = new KelasExtendModel[total];
            int i = 0;
            while (result.next()) {
                kelasList[i] = new KelasExtendModel(
                        result.getInt("kelas.id"),
                        result.getInt("kelas.id_dosen"),
                        result.getInt("kelas.id_mata_kuliah"),
                        result.getString("kelas.tipe_kelas").charAt(0),
                        result.getInt("kelas.id_ruangan"),
                        SesiEnum.valueToEnum(result.getString("kelas.sesi")),
                        result.getString("kelas.tahun_ajaran"), result.getString("dosen.nik"),
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
                        result.getString("dosen_tempat_lahir.tempat_lahir"),
                        result.getString("dosen_pendidikan.pendidikan"),
                        result.getString("dosen_pendidikan.singkatan"),
                        result.getInt("dosen_program_studi.id_jurusan"),
                        result.getString("dosen_program_studi.program_studi"),
                        result.getString("dosen_program_studi.deskripsi"),
                        result.getString("dosen_jurusan.jurusan"),
                        result.getString("dosen_jurusan.deskripsi"),
                        result.getString("mata_kuliah.kode"),
                        result.getString("mata_kuliah.mata_kuliah"),
                        result.getString("mata_kuliah.deskripsi"),
                        result.getInt("mata_kuliah.sks"),
                        result.getString("ruangan.ruangan"));

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

    @Override
    public KelasExtendModel getOneExtend(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOneExtend'");
    }
}
