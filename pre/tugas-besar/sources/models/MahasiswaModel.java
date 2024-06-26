package models;

import java.util.Date;

import enums.JenisKelaminEnum;
import enums.GolonganDarahEnum;
import enums.AgamaEnum;
import interfaces.MahasiswaInterface;

import utilities.CustomDate;
import utilities.Password;

public class MahasiswaModel extends BaseModel implements MahasiswaInterface {
    private final int id;
    private final String nik;
    private final String nim;
    private final String nama;
    private final String email;
    private final String password;
    private final String alamat;
    private final int idTempatLahir;
    private final Date tanggalLahir;
    private final JenisKelaminEnum jenisKelamin;
    private final GolonganDarahEnum golonganDarah;
    private final AgamaEnum agama;
    private final String nomorTelepon;
    private final int idTahunAjaran;
    private final int idTahunMasuk;
    private final int idProgramStudi;
    private final int idDosenWali;
    private final boolean aktif;
    private final String keterangan;

    public MahasiswaModel(
            String nik,
            String nim,
            String nama,
            String email,
            String password,
            String alamat,
            int idTempatLahir,
            String tanggalLahir,
            JenisKelaminEnum jenisKelamin,
            GolonganDarahEnum golonganDarah,
            AgamaEnum agama,
            String nomorTelepon,
            int idTahunAjaran,
            int idTahunMasuk,
            int idProgramStudi,
            int idDosenWali,
            boolean aktif,
            String keterangan) {
        validate(
                nik,
                nim,
                nama,
                email,
                password,
                alamat,
                idTempatLahir,
                tanggalLahir,
                nomorTelepon,
                idTahunAjaran,
                idTahunMasuk,
                idProgramStudi,
                idDosenWali);

        this.id = -1;
        this.nik = nik;
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.password = Password.hash(password);
        this.alamat = alamat;
        this.idTempatLahir = idTempatLahir;
        this.tanggalLahir = CustomDate.sqlToDate(tanggalLahir);
        this.jenisKelamin = jenisKelamin;
        this.golonganDarah = golonganDarah;
        this.agama = agama;
        this.nomorTelepon = nomorTelepon;
        this.idTahunAjaran = idTahunAjaran;
        this.idTahunMasuk = idTahunMasuk;
        this.idProgramStudi = idProgramStudi;
        this.idDosenWali = idDosenWali;
        this.aktif = aktif;
        this.keterangan = (keterangan == null || keterangan.trim().isEmpty()) ? null : keterangan;
    }

    public MahasiswaModel(
            int id,
            String nik,
            String nim,
            String nama,
            String email,
            String password,
            String alamat,
            int idTempatLahir,
            String tanggalLahir,
            JenisKelaminEnum jenisKelamin,
            GolonganDarahEnum golonganDarah,
            AgamaEnum agama,
            String nomorTelepon,
            int idTahunAjaran,
            int idTahunMasuk,
            int idProgramStudi,
            int idDosenWali,
            boolean aktif,
            String keterangan) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(
                nik,
                nim,
                nama,
                email,
                password,
                alamat,
                idTempatLahir,
                tanggalLahir,
                nomorTelepon,
                idTahunAjaran,
                idTahunMasuk,
                idProgramStudi,
                idDosenWali);

        this.id = id;
        this.nik = nik;
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.password = Password.hash(password);
        this.alamat = alamat;
        this.idTempatLahir = idTempatLahir;
        this.tanggalLahir = CustomDate.sqlToDate(tanggalLahir);
        this.jenisKelamin = jenisKelamin;
        this.golonganDarah = golonganDarah;
        this.agama = agama;
        this.nomorTelepon = nomorTelepon;
        this.idTahunAjaran = idTahunAjaran;
        this.idTahunMasuk = idTahunMasuk;
        this.idProgramStudi = idProgramStudi;
        this.idDosenWali = idDosenWali;
        this.aktif = aktif;
        this.keterangan = (keterangan == null || keterangan.trim().isEmpty()) ? null : keterangan;
    }

    private void validate(
            String nik,
            String nim,
            String nama,
            String email,
            String password,
            String alamat,
            int idTempatLahir,
            String tanggalLahir,
            String nomorTelepon,
            int idTahunAjaran,
            int idTahunMasuk,
            int idProgramStudi,
            int idDosenWali) {
        if (nik == null || nik.trim().isEmpty()) {
            throw new IllegalArgumentException("NIK cannot be empty");
        }

        if (nim == null || nim.trim().isEmpty()) {
            throw new IllegalArgumentException("NIM cannot be empty");
        }

        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama cannot be empty");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        if (alamat == null || alamat.trim().isEmpty()) {
            throw new IllegalArgumentException("Alamat cannot be empty");
        }

        if (idTempatLahir <= 0) {
            throw new IllegalArgumentException("Id tempat lahir is invalid");
        }

        if (tanggalLahir == null || tanggalLahir.trim().isEmpty()) {
            throw new IllegalArgumentException("Tanggal lahir cannot be empty");
        }

        if (!tanggalLahir.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("Tanggal lahir invalid date format.");
        }

        if (nomorTelepon == null || nomorTelepon.trim().isEmpty()) {
            throw new IllegalArgumentException("Nomor telepon cannot be empty");
        }

        if (idTahunAjaran <= 0) {
            throw new IllegalArgumentException("Id tahun ajaran is invalid");
        }

        if (idTahunMasuk <= 0) {
            throw new IllegalArgumentException("Id tahun masuk is invalid");
        }

        if (idProgramStudi <= 0) {
            throw new IllegalArgumentException("Id program studi is invalid");
        }

        if (idDosenWali <= 0) {
            throw new IllegalArgumentException("Id dosen wali is invalid");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getNIK() {
        return nik;
    }

    @Override
    public String getNIM() {
        return nim;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getAlamat() {
        return alamat;
    }

    @Override
    public int getIdTempatLahir() {
        return idTempatLahir;
    }

    @Override
    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    @Override
    public JenisKelaminEnum getJenisKelamin() {
        return jenisKelamin;
    }

    @Override
    public GolonganDarahEnum getGolonganDarah() {
        return golonganDarah;
    }

    @Override
    public AgamaEnum getAgama() {
        return agama;
    }

    @Override
    public String getNomorTelepon() {
        return nomorTelepon;
    }

    @Override
    public int getIdTahunAjaran() {
        return idTahunAjaran;
    }

    @Override
    public int getIdTahunMasuk() {
        return idTahunMasuk;
    }

    @Override
    public int getIdProgramStudi() {
        return idProgramStudi;
    }

    @Override
    public int getIdDosenWali() {
        return idDosenWali;
    }

    @Override
    public boolean getAktif() {
        return aktif;
    }

    @Override
    public String getKeterangan() {
        return keterangan;
    }

    @Override
    public String toString() {
        return "Mahasiswa("
                + "id=" + id + ", "
                + "nik=" + nik + ", "
                + "nim=" + nim + ", "
                + "nama=" + nama + ", "
                + "email=" + email + ", "
                + "password=" + password + ", "
                + "alamat=" + alamat + ", "
                + "idTempatLahir=" + idTempatLahir + ", "
                + "tanggalLahir=" + CustomDate.dateToString(tanggalLahir) + ", "
                + "jenisKelamin=" + jenisKelamin.value + ", "
                + "golonganDarah=" + golonganDarah.value + ", "
                + "agama=" + agama.value + ", "
                + "nomorTelepon=" + nomorTelepon + ", "
                + "idTahunAjaran=" + idTahunAjaran + ", "
                + "idTahunMasuk=" + idTahunMasuk + ", "
                + "idProgramStudi=" + idProgramStudi + ", "
                + "idDosenWali=" + idDosenWali + ", "
                + "aktif=" + aktif + ", "
                + "keterangan=" + keterangan
                + ")";
    }
}
