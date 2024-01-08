package services;

import java.sql.*;

import providers.Database;
import enums.AgamaEnum;
import enums.GolonganDarahEnum;
import enums.IndeksEnum;
import enums.JenisKelaminEnum;
import enums.SesiEnum;
import models.MahasiswaKelasModel;
import models.MahasiswaKelasExtendModel;

public class MahasiswaKelasService
        extends BaseService<MahasiswaKelasModel>
        implements ExtendService<MahasiswaKelasExtendModel> {
    private static final String table = "mahasiswa_kelas";

    public MahasiswaKelasService() {
        super(table);
    }

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

            final MahasiswaKelasModel[] mahasiswaKelasList = new MahasiswaKelasModel[total];
            int i = 0;
            while (result.next()) {
                mahasiswaKelasList[i] = new MahasiswaKelasModel(
                        result.getInt("id"),
                        result.getInt("id_kelas"),
                        result.getInt("id_mahasiswa"),
                        IndeksEnum.valueToEnum(result.getString("indeks")));

                i++;
            }

            database.close();

            return mahasiswaKelasList;
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
    public MahasiswaKelasExtendModel[] getExtend() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "mahasiswa_kelas.id, "
                            + "mahasiswa_kelas.id_kelas, "
                            + "mahasiswa_kelas.id_mahasiswa, "
                            + "mahasiswa_kelas.indeks, "
                            + "kelas.id_dosen, "
                            + "kelas.id_mata_kuliah, "
                            + "kelas.tipe_kelas, "
                            + "kelas.id_ruangan, "
                            + "kelas.sesi, "
                            + "kelas.tahun_ajaran, "
                            + "kelas_dosen.nik, "
                            + "kelas_dosen.nip, "
                            + "kelas_dosen.nama, "
                            + "kelas_dosen.email, "
                            + "kelas_dosen.password, "
                            + "kelas_dosen.alamat, "
                            + "kelas_dosen.id_tempat_lahir, "
                            + "kelas_dosen.tanggal_lahir, "
                            + "kelas_dosen.jenis_kelamin, "
                            + "kelas_dosen.golongan_darah, "
                            + "kelas_dosen.agama, "
                            + "kelas_dosen.nomor_telepon, "
                            + "kelas_dosen.id_pendidikan, "
                            + "kelas_dosen.id_program_studi, "
                            + "kelas_dosen.aktif, "
                            + "kelas_dosen.keterangan, "
                            + "kelas_dosen_tempat_lahir.tempat_lahir, "
                            + "kelas_dosen_pendidikan.pendidikan, "
                            + "kelas_dosen_pendidikan.singkatan, "
                            + "kelas_dosen_program_studi.id_jurusan, "
                            + "kelas_dosen_program_studi.program_studi, "
                            + "kelas_dosen_program_studi.deskripsi, "
                            + "kelas_dosen_jurusan.jurusan, "
                            + "kelas_dosen_jurusan.deskripsi, "
                            + "kelas_mata_kuliah.kode, "
                            + "kelas_mata_kuliah.mata_kuliah, "
                            + "kelas_mata_kuliah.deskripsi, "
                            + "kelas_mata_kuliah.sks, "
                            + "kelas_ruangan.ruangan, "
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
                            + "mahasiswa_tempat_lahir.tempat_lahir, "
                            + "mahasiswa_tahun_ajaran.tahun_ajaran, "
                            + "mahasiswa_tahun_masuk.tahun_masuk, "
                            + "mahasiswa_program_studi.id_jurusan, "
                            + "mahasiswa_program_studi.program_studi, "
                            + "mahasiswa_program_studi.deskripsi, "
                            + "mahasiswa_jurusan.jurusan, "
                            + "mahasiswa_jurusan.deskripsi, "
                            + "mahasiswa_dosen_wali.nik, "
                            + "mahasiswa_dosen_wali.nip, "
                            + "mahasiswa_dosen_wali.nama, "
                            + "mahasiswa_dosen_wali.email, "
                            + "mahasiswa_dosen_wali.password, "
                            + "mahasiswa_dosen_wali.alamat, "
                            + "mahasiswa_dosen_wali.id_tempat_lahir, "
                            + "mahasiswa_dosen_wali.tanggal_lahir, "
                            + "mahasiswa_dosen_wali.jenis_kelamin, "
                            + "mahasiswa_dosen_wali.golongan_darah, "
                            + "mahasiswa_dosen_wali.agama, "
                            + "mahasiswa_dosen_wali.nomor_telepon, "
                            + "mahasiswa_dosen_wali.id_pendidikan, "
                            + "mahasiswa_dosen_wali.id_program_studi, "
                            + "mahasiswa_dosen_wali.aktif, "
                            + "mahasiswa_dosen_wali.keterangan, "
                            + "mahasiswa_dosen_wali_tempat_lahir.tempat_lahir, "
                            + "mahasiswa_dosen_wali_pendidikan.pendidikan, "
                            + "mahasiswa_dosen_wali_pendidikan.singkatan, "
                            + "mahasiswa_dosen_wali_program_studi.id_jurusan, "
                            + "mahasiswa_dosen_wali_program_studi.program_studi, "
                            + "mahasiswa_dosen_wali_program_studi.deskripsi, "
                            + "mahasiswa_dosen_wali_jurusan.jurusan, "
                            + "mahasiswa_dosen_wali_jurusan.deskripsi "
                            + "FROM mahasiswa_kelas "
                            + "INNER JOIN kelas ON mahasiswa_kelas.id_kelas=kelas.id "
                            + "INNER JOIN dosen AS `kelas_dosen` ON kelas.id_dosen=kelas_dosen.id "
                            + "INNER JOIN tempat_lahir AS `kelas_dosen_tempat_lahir` ON kelas_dosen.id_tempat_lahir=kelas_dosen_tempat_lahir.id "
                            + "INNER JOIN pendidikan AS `kelas_dosen_pendidikan` ON kelas_dosen.id_pendidikan=kelas_dosen_pendidikan.id "
                            + "INNER JOIN program_studi AS `kelas_dosen_program_studi` ON kelas_dosen.id_program_studi=kelas_dosen_program_studi.id "
                            + "INNER JOIN jurusan AS `kelas_dosen_jurusan` ON kelas_dosen_program_studi.id_jurusan=kelas_dosen_jurusan.id "
                            + "INNER JOIN mata_kuliah AS `kelas_mata_kuliah` ON kelas.id_mata_kuliah=kelas_mata_kuliah.id "
                            + "INNER JOIN ruangan AS `kelas_ruangan` ON kelas.id_ruangan=kelas_ruangan.id "
                            + "INNER JOIN mahasiswa ON mahasiswa_kelas.id_mahasiswa=mahasiswa.id "
                            + "INNER JOIN tempat_lahir AS `mahasiswa_tempat_lahir` ON mahasiswa.id_tempat_lahir=mahasiswa_tempat_lahir.id "
                            + "INNER JOIN tahun_ajaran AS `mahasiswa_tahun_ajaran` ON mahasiswa.id_tahun_ajaran=mahasiswa_tahun_ajaran.id "
                            + "INNER JOIN tahun_masuk AS `mahasiswa_tahun_masuk` ON mahasiswa.id_tahun_masuk=mahasiswa_tahun_masuk.id "
                            + "INNER JOIN program_studi AS `mahasiswa_program_studi` ON mahasiswa.id_program_studi=mahasiswa_program_studi.id "
                            + "INNER JOIN jurusan AS `mahasiswa_jurusan` ON mahasiswa_program_studi.id_jurusan=mahasiswa_jurusan.id "
                            + "INNER JOIN dosen AS `mahasiswa_dosen_wali` ON mahasiswa.id_dosen_wali=mahasiswa_dosen_wali.id "
                            + "INNER JOIN tempat_lahir AS `mahasiswa_dosen_wali_tempat_lahir` ON mahasiswa_dosen_wali.id_tempat_lahir=mahasiswa_dosen_wali_tempat_lahir.id "
                            + "INNER JOIN pendidikan AS `mahasiswa_dosen_wali_pendidikan` ON mahasiswa_dosen_wali.id_pendidikan=mahasiswa_dosen_wali_pendidikan.id "
                            + "INNER JOIN program_studi AS `mahasiswa_dosen_wali_program_studi` ON mahasiswa_dosen_wali.id_program_studi=mahasiswa_dosen_wali_program_studi.id "
                            + "INNER JOIN jurusan AS `mahasiswa_dosen_wali_jurusan` ON mahasiswa_dosen_wali_program_studi.id_jurusan=mahasiswa_dosen_wali_jurusan.id"
                            + ";");

            final MahasiswaKelasExtendModel[] mahasiswaKelasList = new MahasiswaKelasExtendModel[total];
            int i = 0;
            while (result.next()) {
                mahasiswaKelasList[i] = new MahasiswaKelasExtendModel(
                        result.getInt("id"),
                        result.getInt("id_kelas"),
                        result.getInt("id_mahasiswa"),
                        IndeksEnum.valueToEnum(result.getString("indeks")),
                        result.getInt("kelas.id_dosen"),
                        result.getInt("kelas.id_mata_kuliah"),
                        result.getString("kelas.tipe_kelas").charAt(0),
                        result.getInt("kelas.id_ruangan"),
                        SesiEnum.valueToEnum(result.getString("kelas.sesi")),
                        result.getString("kelas.tahun_ajaran"),
                        result.getString("kelas_dosen.nik"),
                        result.getString("kelas_dosen.nip"),
                        result.getString("kelas_dosen.nama"),
                        result.getString("kelas_dosen.email"),
                        result.getString("kelas_dosen.password"),
                        result.getString("kelas_dosen.alamat"),
                        result.getInt("kelas_dosen.id_tempat_lahir"),
                        result.getString("kelas_dosen.tanggal_lahir"),
                        JenisKelaminEnum.valueToEnum(result.getString("kelas_dosen.jenis_kelamin")),
                        GolonganDarahEnum.valueToEnum(result.getString("kelas_dosen.golongan_darah")),
                        AgamaEnum.valueToEnum(result.getString("kelas_dosen.agama")),
                        result.getString("kelas_dosen.nomor_telepon"),
                        result.getInt("kelas_dosen.id_pendidikan"),
                        result.getInt("kelas_dosen.id_program_studi"),
                        result.getBoolean("kelas_dosen.aktif"),
                        result.getString("kelas_dosen.keterangan"),
                        result.getString("kelas_dosen_tempat_lahir.tempat_lahir"),
                        result.getString("kelas_dosen_pendidikan.pendidikan"),
                        result.getString("kelas_dosen_pendidikan.singkatan"),
                        result.getInt("kelas_dosen_program_studi.id_jurusan"),
                        result.getString("kelas_dosen_program_studi.program_studi"),
                        result.getString("kelas_dosen_program_studi.deskripsi"),
                        result.getString("kelas_dosen_jurusan.jurusan"),
                        result.getString("kelas_dosen_jurusan.deskripsi"),
                        result.getString("kelas_mata_kuliah.kode"),
                        result.getString("kelas_mata_kuliah.mata_kuliah"),
                        result.getString("kelas_mata_kuliah.deskripsi"),
                        result.getInt("kelas_mata_kuliah.sks"),
                        result.getString("kelas_ruangan.ruangan"),
                        result.getString("mahasiswa.nik"),
                        result.getString("mahasiswa.nim"),
                        result.getString("mahasiswa.nama"),
                        result.getString("mahasiswa.email"),
                        result.getString("mahasiswa.password"),
                        result.getString("mahasiswa.alamat"),
                        result.getInt("mahasiswa.id_tempat_lahir"),
                        result.getString("mahasiswa.tanggal_lahir"),
                        JenisKelaminEnum.valueToEnum(result.getString("mahasiswa.jenis_kelamin")),
                        GolonganDarahEnum.valueToEnum(result.getString("mahasiswa.golongan_darah")),
                        AgamaEnum.valueToEnum(result.getString("mahasiswa.agama")),
                        result.getString("mahasiswa.nomor_telepon"),
                        result.getInt("mahasiswa.id_tahun_ajaran"),
                        result.getInt("mahasiswa.id_tahun_masuk"),
                        result.getInt("mahasiswa.id_program_studi"),
                        result.getInt("mahasiswa.id_dosen_wali"),
                        result.getBoolean("mahasiswa.aktif"),
                        result.getString("mahasiswa.keterangan"),
                        result.getString("mahasiswa_tempat_lahir.tempat_lahir"),
                        result.getString("mahasiswa_tahun_ajaran.tahun_ajaran"),
                        result.getString("mahasiswa_tahun_masuk.tahun_masuk"),
                        result.getInt("mahasiswa_program_studi.id_jurusan"),
                        result.getString("mahasiswa_program_studi.program_studi"),
                        result.getString("mahasiswa_program_studi.deskripsi"),
                        result.getString("mahasiswa_jurusan.jurusan"),
                        result.getString("mahasiswa_jurusan.deskripsi"),
                        result.getString("mahasiswa_dosen_wali.nik"),
                        result.getString("mahasiswa_dosen_wali.nip"),
                        result.getString("mahasiswa_dosen_wali.nama"),
                        result.getString("mahasiswa_dosen_wali.email"),
                        result.getString("mahasiswa_dosen_wali.password"),
                        result.getString("mahasiswa_dosen_wali.alamat"),
                        result.getInt("mahasiswa_dosen_wali.id_tempat_lahir"),
                        result.getString("mahasiswa_dosen_wali.tanggal_lahir"),
                        JenisKelaminEnum.valueToEnum(result.getString("mahasiswa_dosen_wali.jenis_kelamin")),
                        GolonganDarahEnum.valueToEnum(result.getString("mahasiswa_dosen_wali.golongan_darah")),
                        AgamaEnum.valueToEnum(result.getString("mahasiswa_dosen_wali.agama")),
                        result.getString("mahasiswa_dosen_wali.nomor_telepon"),
                        result.getInt("mahasiswa_dosen_wali.id_pendidikan"),
                        result.getInt("mahasiswa_dosen_wali.id_program_studi"),
                        result.getBoolean("mahasiswa_dosen_wali.aktif"),
                        result.getString("mahasiswa_dosen_wali.keterangan"),
                        result.getString("mahasiswa_dosen_wali_tempat_lahir.tempat_lahir"),
                        result.getString("mahasiswa_dosen_wali_pendidikan.pendidikan"),
                        result.getString("mahasiswa_dosen_wali_pendidikan.singkatan"),
                        result.getInt("mahasiswa_dosen_wali_program_studi.id_jurusan"),
                        result.getString("mahasiswa_dosen_wali_program_studi.program_studi"),
                        result.getString("mahasiswa_dosen_wali_program_studi.deskripsi"),
                        result.getString("mahasiswa_dosen_wali_jurusan.jurusan"),
                        result.getString("mahasiswa_dosen_wali_jurusan.deskripsi"));

                i++;
            }

            database.close();

            return mahasiswaKelasList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public MahasiswaKelasExtendModel getOneExtend(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "mahasiswa_kelas.id, "
                            + "mahasiswa_kelas.id_kelas, "
                            + "mahasiswa_kelas.id_mahasiswa, "
                            + "mahasiswa_kelas.indeks, "
                            + "kelas.id_dosen, "
                            + "kelas.id_mata_kuliah, "
                            + "kelas.tipe_kelas, "
                            + "kelas.id_ruangan, "
                            + "kelas.sesi, "
                            + "kelas.tahun_ajaran, "
                            + "kelas_dosen.nik, "
                            + "kelas_dosen.nip, "
                            + "kelas_dosen.nama, "
                            + "kelas_dosen.email, "
                            + "kelas_dosen.password, "
                            + "kelas_dosen.alamat, "
                            + "kelas_dosen.id_tempat_lahir, "
                            + "kelas_dosen.tanggal_lahir, "
                            + "kelas_dosen.jenis_kelamin, "
                            + "kelas_dosen.golongan_darah, "
                            + "kelas_dosen.agama, "
                            + "kelas_dosen.nomor_telepon, "
                            + "kelas_dosen.id_pendidikan, "
                            + "kelas_dosen.id_program_studi, "
                            + "kelas_dosen.aktif, "
                            + "kelas_dosen.keterangan, "
                            + "kelas_dosen_tempat_lahir.tempat_lahir, "
                            + "kelas_dosen_pendidikan.pendidikan, "
                            + "kelas_dosen_pendidikan.singkatan, "
                            + "kelas_dosen_program_studi.id_jurusan, "
                            + "kelas_dosen_program_studi.program_studi, "
                            + "kelas_dosen_program_studi.deskripsi, "
                            + "kelas_dosen_jurusan.jurusan, "
                            + "kelas_dosen_jurusan.deskripsi, "
                            + "kelas_mata_kuliah.kode, "
                            + "kelas_mata_kuliah.mata_kuliah, "
                            + "kelas_mata_kuliah.deskripsi, "
                            + "kelas_mata_kuliah.sks, "
                            + "kelas_ruangan.ruangan, "
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
                            + "mahasiswa_tempat_lahir.tempat_lahir, "
                            + "mahasiswa_tahun_ajaran.tahun_ajaran, "
                            + "mahasiswa_tahun_masuk.tahun_masuk, "
                            + "mahasiswa_program_studi.id_jurusan, "
                            + "mahasiswa_program_studi.program_studi, "
                            + "mahasiswa_program_studi.deskripsi, "
                            + "mahasiswa_jurusan.jurusan, "
                            + "mahasiswa_jurusan.deskripsi, "
                            + "mahasiswa_dosen_wali.nik, "
                            + "mahasiswa_dosen_wali.nip, "
                            + "mahasiswa_dosen_wali.nama, "
                            + "mahasiswa_dosen_wali.email, "
                            + "mahasiswa_dosen_wali.password, "
                            + "mahasiswa_dosen_wali.alamat, "
                            + "mahasiswa_dosen_wali.id_tempat_lahir, "
                            + "mahasiswa_dosen_wali.tanggal_lahir, "
                            + "mahasiswa_dosen_wali.jenis_kelamin, "
                            + "mahasiswa_dosen_wali.golongan_darah, "
                            + "mahasiswa_dosen_wali.agama, "
                            + "mahasiswa_dosen_wali.nomor_telepon, "
                            + "mahasiswa_dosen_wali.id_pendidikan, "
                            + "mahasiswa_dosen_wali.id_program_studi, "
                            + "mahasiswa_dosen_wali.aktif, "
                            + "mahasiswa_dosen_wali.keterangan, "
                            + "mahasiswa_dosen_wali_tempat_lahir.tempat_lahir, "
                            + "mahasiswa_dosen_wali_pendidikan.pendidikan, "
                            + "mahasiswa_dosen_wali_pendidikan.singkatan, "
                            + "mahasiswa_dosen_wali_program_studi.id_jurusan, "
                            + "mahasiswa_dosen_wali_program_studi.program_studi, "
                            + "mahasiswa_dosen_wali_program_studi.deskripsi, "
                            + "mahasiswa_dosen_wali_jurusan.jurusan, "
                            + "mahasiswa_dosen_wali_jurusan.deskripsi "
                            + "FROM mahasiswa_kelas "
                            + "INNER JOIN kelas ON mahasiswa_kelas.id_kelas=kelas.id "
                            + "INNER JOIN dosen AS `kelas_dosen` ON kelas.id_dosen=kelas_dosen.id "
                            + "INNER JOIN tempat_lahir AS `kelas_dosen_tempat_lahir` ON kelas_dosen.id_tempat_lahir=kelas_dosen_tempat_lahir.id "
                            + "INNER JOIN pendidikan AS `kelas_dosen_pendidikan` ON kelas_dosen.id_pendidikan=kelas_dosen_pendidikan.id "
                            + "INNER JOIN program_studi AS `kelas_dosen_program_studi` ON kelas_dosen.id_program_studi=kelas_dosen_program_studi.id "
                            + "INNER JOIN jurusan AS `kelas_dosen_jurusan` ON kelas_dosen_program_studi.id_jurusan=kelas_dosen_jurusan.id "
                            + "INNER JOIN mata_kuliah AS `kelas_mata_kuliah` ON kelas.id_mata_kuliah=kelas_mata_kuliah.id "
                            + "INNER JOIN ruangan AS `kelas_ruangan` ON kelas.id_ruangan=kelas_ruangan.id "
                            + "INNER JOIN mahasiswa ON mahasiswa_kelas.id_mahasiswa=mahasiswa.id "
                            + "INNER JOIN tempat_lahir AS `mahasiswa_tempat_lahir` ON mahasiswa.id_tempat_lahir=mahasiswa_tempat_lahir.id "
                            + "INNER JOIN tahun_ajaran AS `mahasiswa_tahun_ajaran` ON mahasiswa.id_tahun_ajaran=mahasiswa_tahun_ajaran.id "
                            + "INNER JOIN tahun_masuk AS `mahasiswa_tahun_masuk` ON mahasiswa.id_tahun_masuk=mahasiswa_tahun_masuk.id "
                            + "INNER JOIN program_studi AS `mahasiswa_program_studi` ON mahasiswa.id_program_studi=mahasiswa_program_studi.id "
                            + "INNER JOIN jurusan AS `mahasiswa_jurusan` ON mahasiswa_program_studi.id_jurusan=mahasiswa_jurusan.id "
                            + "INNER JOIN dosen AS `mahasiswa_dosen_wali` ON mahasiswa.id_dosen_wali=mahasiswa_dosen_wali.id "
                            + "INNER JOIN tempat_lahir AS `mahasiswa_dosen_wali_tempat_lahir` ON mahasiswa_dosen_wali.id_tempat_lahir=mahasiswa_dosen_wali_tempat_lahir.id "
                            + "INNER JOIN pendidikan AS `mahasiswa_dosen_wali_pendidikan` ON mahasiswa_dosen_wali.id_pendidikan=mahasiswa_dosen_wali_pendidikan.id "
                            + "INNER JOIN program_studi AS `mahasiswa_dosen_wali_program_studi` ON mahasiswa_dosen_wali.id_program_studi=mahasiswa_dosen_wali_program_studi.id "
                            + "INNER JOIN jurusan AS `mahasiswa_dosen_wali_jurusan` ON mahasiswa_dosen_wali_program_studi.id_jurusan=mahasiswa_dosen_wali_jurusan.id "
                            + "WHERE mahasiswa_kelas.id='" + id + "'"
                            + ";");

            MahasiswaKelasExtendModel mahasiswaKelas = null;

            if (result.next()) {
                mahasiswaKelas = new MahasiswaKelasExtendModel(
                        result.getInt("id"),
                        result.getInt("id_kelas"),
                        result.getInt("id_mahasiswa"),
                        IndeksEnum.valueToEnum(result.getString("indeks")),
                        result.getInt("kelas.id_dosen"),
                        result.getInt("kelas.id_mata_kuliah"),
                        result.getString("kelas.tipe_kelas").charAt(0),
                        result.getInt("kelas.id_ruangan"),
                        SesiEnum.valueToEnum(result.getString("kelas.sesi")),
                        result.getString("kelas.tahun_ajaran"),
                        result.getString("kelas_dosen.nik"),
                        result.getString("kelas_dosen.nip"),
                        result.getString("kelas_dosen.nama"),
                        result.getString("kelas_dosen.email"),
                        result.getString("kelas_dosen.password"),
                        result.getString("kelas_dosen.alamat"),
                        result.getInt("kelas_dosen.id_tempat_lahir"),
                        result.getString("kelas_dosen.tanggal_lahir"),
                        JenisKelaminEnum.valueToEnum(result.getString("kelas_dosen.jenis_kelamin")),
                        GolonganDarahEnum.valueToEnum(result.getString("kelas_dosen.golongan_darah")),
                        AgamaEnum.valueToEnum(result.getString("kelas_dosen.agama")),
                        result.getString("kelas_dosen.nomor_telepon"),
                        result.getInt("kelas_dosen.id_pendidikan"),
                        result.getInt("kelas_dosen.id_program_studi"),
                        result.getBoolean("kelas_dosen.aktif"),
                        result.getString("kelas_dosen.keterangan"),
                        result.getString("kelas_dosen_tempat_lahir.tempat_lahir"),
                        result.getString("kelas_dosen_pendidikan.pendidikan"),
                        result.getString("kelas_dosen_pendidikan.singkatan"),
                        result.getInt("kelas_dosen_program_studi.id_jurusan"),
                        result.getString("kelas_dosen_program_studi.program_studi"),
                        result.getString("kelas_dosen_program_studi.deskripsi"),
                        result.getString("kelas_dosen_jurusan.jurusan"),
                        result.getString("kelas_dosen_jurusan.deskripsi"),
                        result.getString("kelas_mata_kuliah.kode"),
                        result.getString("kelas_mata_kuliah.mata_kuliah"),
                        result.getString("kelas_mata_kuliah.deskripsi"),
                        result.getInt("kelas_mata_kuliah.sks"),
                        result.getString("kelas_ruangan.ruangan"),
                        result.getString("mahasiswa.nik"),
                        result.getString("mahasiswa.nim"),
                        result.getString("mahasiswa.nama"),
                        result.getString("mahasiswa.email"),
                        result.getString("mahasiswa.password"),
                        result.getString("mahasiswa.alamat"),
                        result.getInt("mahasiswa.id_tempat_lahir"),
                        result.getString("mahasiswa.tanggal_lahir"),
                        JenisKelaminEnum.valueToEnum(result.getString("mahasiswa.jenis_kelamin")),
                        GolonganDarahEnum.valueToEnum(result.getString("mahasiswa.golongan_darah")),
                        AgamaEnum.valueToEnum(result.getString("mahasiswa.agama")),
                        result.getString("mahasiswa.nomor_telepon"),
                        result.getInt("mahasiswa.id_tahun_ajaran"),
                        result.getInt("mahasiswa.id_tahun_masuk"),
                        result.getInt("mahasiswa.id_program_studi"),
                        result.getInt("mahasiswa.id_dosen_wali"),
                        result.getBoolean("mahasiswa.aktif"),
                        result.getString("mahasiswa.keterangan"),
                        result.getString("mahasiswa_tempat_lahir.tempat_lahir"),
                        result.getString("mahasiswa_tahun_ajaran.tahun_ajaran"),
                        result.getString("mahasiswa_tahun_masuk.tahun_masuk"),
                        result.getInt("mahasiswa_program_studi.id_jurusan"),
                        result.getString("mahasiswa_program_studi.program_studi"),
                        result.getString("mahasiswa_program_studi.deskripsi"),
                        result.getString("mahasiswa_jurusan.jurusan"),
                        result.getString("mahasiswa_jurusan.deskripsi"),
                        result.getString("mahasiswa_dosen_wali.nik"),
                        result.getString("mahasiswa_dosen_wali.nip"),
                        result.getString("mahasiswa_dosen_wali.nama"),
                        result.getString("mahasiswa_dosen_wali.email"),
                        result.getString("mahasiswa_dosen_wali.password"),
                        result.getString("mahasiswa_dosen_wali.alamat"),
                        result.getInt("mahasiswa_dosen_wali.id_tempat_lahir"),
                        result.getString("mahasiswa_dosen_wali.tanggal_lahir"),
                        JenisKelaminEnum.valueToEnum(result.getString("mahasiswa_dosen_wali.jenis_kelamin")),
                        GolonganDarahEnum.valueToEnum(result.getString("mahasiswa_dosen_wali.golongan_darah")),
                        AgamaEnum.valueToEnum(result.getString("mahasiswa_dosen_wali.agama")),
                        result.getString("mahasiswa_dosen_wali.nomor_telepon"),
                        result.getInt("mahasiswa_dosen_wali.id_pendidikan"),
                        result.getInt("mahasiswa_dosen_wali.id_program_studi"),
                        result.getBoolean("mahasiswa_dosen_wali.aktif"),
                        result.getString("mahasiswa_dosen_wali.keterangan"),
                        result.getString("mahasiswa_dosen_wali_tempat_lahir.tempat_lahir"),
                        result.getString("mahasiswa_dosen_wali_pendidikan.pendidikan"),
                        result.getString("mahasiswa_dosen_wali_pendidikan.singkatan"),
                        result.getInt("mahasiswa_dosen_wali_program_studi.id_jurusan"),
                        result.getString("mahasiswa_dosen_wali_program_studi.program_studi"),
                        result.getString("mahasiswa_dosen_wali_program_studi.deskripsi"),
                        result.getString("mahasiswa_dosen_wali_jurusan.jurusan"),
                        result.getString("mahasiswa_dosen_wali_jurusan.deskripsi"));
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
}
