package models;

import java.util.Date;

import interfaces.MahasiswaInterface;

import utilities.CustomDate;

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
    private final String jenisKelamin;
    private final String golonganDarah;
    private final String agama;
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
            String jenisKelamin,
            String golonganDarah,
            String agama,
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
                jenisKelamin,
                golonganDarah,
                agama,
                nomorTelepon,
                idTahunAjaran,
                idTahunMasuk,
                idProgramStudi,
                idDosenWali,
                keterangan);

        this.id = -1;
        this.nik = nik;
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.alamat = alamat;
        this.idTempatLahir = idTempatLahir;
        this.tanggalLahir = CustomDate.stringToDate(tanggalLahir);
        this.jenisKelamin = jenisKelamin;
        this.golonganDarah = golonganDarah;
        this.agama = agama;
        this.nomorTelepon = nomorTelepon;
        this.idTahunAjaran = idTahunAjaran;
        this.idTahunMasuk = idTahunMasuk;
        this.idProgramStudi = idProgramStudi;
        this.idDosenWali = idDosenWali;
        this.aktif = aktif;
        this.keterangan = keterangan;
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
            String jenisKelamin,
            String golonganDarah,
            String agama,
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
                jenisKelamin,
                golonganDarah,
                agama,
                nomorTelepon,
                idTahunAjaran,
                idTahunMasuk,
                idProgramStudi,
                idDosenWali,
                keterangan);

        this.id = id;
        this.nik = nik;
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.alamat = alamat;
        this.idTempatLahir = idTempatLahir;
        this.tanggalLahir = CustomDate.stringToDate(tanggalLahir);
        this.jenisKelamin = jenisKelamin;
        this.golonganDarah = golonganDarah;
        this.agama = agama;
        this.nomorTelepon = nomorTelepon;
        this.idTahunAjaran = idTahunAjaran;
        this.idTahunMasuk = idTahunMasuk;
        this.idProgramStudi = idProgramStudi;
        this.idDosenWali = idDosenWali;
        this.aktif = aktif;
        this.keterangan = keterangan;
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
            String jenisKelamin,
            String golonganDarah,
            String agama,
            String nomorTelepon,
            int idTahunAjaran,
            int idTahunMasuk,
            int idProgramStudi,
            int idDosenWali,
            String keterangan) {
        if (nik == null || nik.trim().isEmpty()) {
            throw new IllegalArgumentException("NIK cannot be empty");
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

        if (jenisKelamin == null || jenisKelamin.trim().isEmpty()) {
            throw new IllegalArgumentException("Jenis kelamin cannot be empty");
        }

        if (golonganDarah == null || golonganDarah.trim().isEmpty()) {
            throw new IllegalArgumentException("Golongan darah cannot be empty");
        }

        if (agama == null || agama.trim().isEmpty()) {
            throw new IllegalArgumentException("Agama cannot be empty");
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

        if (keterangan == null || keterangan.trim().isEmpty()) {
            throw new IllegalArgumentException("Keterangan cannot be empty");
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
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    @Override
    public String getGolonganDarah() {
        return golonganDarah;
    }

    @Override
    public String getAgama() {
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
                + "tanggalLahir=" + tanggalLahir + ", "
                + "jenisKelamin=" + jenisKelamin + ", "
                + "golonganDarah=" + golonganDarah + ", "
                + "agama=" + agama + ", "
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
