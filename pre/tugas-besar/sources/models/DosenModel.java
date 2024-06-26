package models;

import java.util.Date;

import interfaces.DosenInterface;
import enums.JenisKelaminEnum;
import enums.GolonganDarahEnum;
import enums.AgamaEnum;
import utilities.CustomDate;
import utilities.Password;

public class DosenModel extends BaseModel implements DosenInterface {
    private final int id;
    private final String nik;
    private final String nip;
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
    private final int idPendidikan;
    private final int idProgramStudi;
    private final boolean aktif;
    private final String keterangan;

    public DosenModel(
            String nik,
            String nip,
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
            int idPendidikan,
            int idProgramStudi,
            boolean aktif,
            String keterangan) {
        validate(
                nik,
                nip,
                nama,
                email,
                password,
                alamat,
                idTempatLahir,
                tanggalLahir,
                nomorTelepon,
                idPendidikan,
                idProgramStudi);

        this.id = -1;
        this.nik = nik;
        this.nip = nip;
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
        this.idPendidikan = idPendidikan;
        this.idProgramStudi = idProgramStudi;
        this.aktif = aktif;
        this.keterangan = (keterangan == null || keterangan.trim().isEmpty()) ? null : keterangan;
    }

    public DosenModel(
            int id,
            String nik,
            String nip,
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
            int idPendidikan,
            int idProgramStudi,
            boolean aktif,
            String keterangan) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(
                nik,
                nip,
                nama,
                email,
                password,
                alamat,
                idTempatLahir,
                tanggalLahir,
                nomorTelepon,
                idPendidikan,
                idProgramStudi);

        this.id = id;
        this.nik = nik;
        this.nip = nip;
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
        this.idPendidikan = idPendidikan;
        this.idProgramStudi = idProgramStudi;
        this.aktif = aktif;
        this.keterangan = (keterangan == null || keterangan.trim().isEmpty()) ? null : keterangan;
    }

    private void validate(
            String nik,
            String nip,
            String nama,
            String email,
            String password,
            String alamat,
            int idTempatLahir,
            String tanggalLahir,
            String nomorTelepon,
            int idPendidikan,
            int idProgramStudi) {
        if (nik == null || nik.trim().isEmpty()) {
            throw new IllegalArgumentException("NIK cannot be empty");
        }

        if (nip == null || nip.trim().isEmpty()) {
            throw new IllegalArgumentException("NIP cannot be empty");
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

        if (idPendidikan <= 0) {
            throw new IllegalArgumentException("Id pendidikan is invalid");
        }

        if (idProgramStudi <= 0) {
            throw new IllegalArgumentException("Id program studi is invalid");
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
    public String getNIP() {
        return nip;
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
    public int getIdPendidikan() {
        return idPendidikan;
    }

    @Override
    public int getIdProgramStudi() {
        return idProgramStudi;
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
        return "Dosen("
                + "id=" + id + ", "
                + "nik=" + nik + ", "
                + "nip=" + nip + ", "
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
                + "idPendidikan=" + idPendidikan + ", "
                + "idProgramStudi=" + idProgramStudi + ", "
                + "aktif=" + aktif + ", "
                + "keterangan=" + keterangan
                + ")";
    }
}
