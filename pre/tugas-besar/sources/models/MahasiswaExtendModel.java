package models;

import interfaces.MahasiswaExtendInterface;
import utilities.CustomDate;

public class MahasiswaExtendModel extends MahasiswaModel implements MahasiswaExtendInterface {
    private final TempatLahirModel tempatLahirExtend;
    private final TahunAjaranModel tahunAjaranExtend;
    private final TahunMasukModel tahunMasukExtend;
    private final ProgramStudiExtendModel programStudiExtend;

    public MahasiswaExtendModel(
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
            String keterangan,
            String tempatLahirTempatLahir,
            String tahunAjaranTahunAjaran,
            String tahunMasukTahunMasuk,
            int programStudiIdJurusan,
            String programStudiProgramStudi,
            String programStudiDeskripsi,
            String jurusanJurusan,
            String jurusanDeskripsi) {
        super(
                id,
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
                aktif,
                keterangan);

        this.tempatLahirExtend = new TempatLahirModel(idTempatLahir, tempatLahirTempatLahir);
        this.tahunAjaranExtend = new TahunAjaranModel(idTahunAjaran, tahunAjaranTahunAjaran);
        this.tahunMasukExtend = new TahunMasukModel(idTahunMasuk, tahunMasukTahunMasuk);
        this.programStudiExtend = new ProgramStudiExtendModel(
                idProgramStudi,
                programStudiIdJurusan,
                programStudiProgramStudi,
                programStudiDeskripsi,
                jurusanJurusan,
                jurusanDeskripsi);
    }

    public TempatLahirModel getTempatLahirExtend() {
        return this.tempatLahirExtend;
    }

    public TahunAjaranModel getTahunAjaranExtend() {
        return this.tahunAjaranExtend;
    }

    public TahunMasukModel getTahunMasukExtend() {
        return this.tahunMasukExtend;
    }

    public ProgramStudiExtendModel getProgramStudiExtend() {
        return this.programStudiExtend;
    }

    @Override
    public String toString() {
        return "Mahasiswa("
                + "id=" + this.getId() + ", "
                + "nik=" + this.getNIK() + ", "
                + "nim=" + this.getNIM() + ", "
                + "nama=" + this.getNama() + ", "
                + "email=" + this.getEmail() + ", "
                + "password=" + this.getPassword() + ", "
                + "alamat=" + this.getAlamat() + ", "
                + "idTempatLahir=" + this.getIdTempatLahir() + ", "
                + "tanggalLahir=" + CustomDate.dateToString(this.getTanggalLahir()) + ", "
                + "jenisKelamin=" + this.getJenisKelamin() + ", "
                + "golonganDarah=" + this.getGolonganDarah() + ", "
                + "agama=" + this.getAgama() + ", "
                + "nomorTelepon=" + this.getNomorTelepon() + ", "
                + "idTahunAjaran=" + this.getIdTahunAjaran() + ", "
                + "idTahunMasuk=" + this.getIdTahunMasuk() + ", "
                + "idProgramStudi=" + this.getIdProgramStudi() + ", "
                + "idDosenWali=" + this.getIdDosenWali() + ", "
                + "aktif=" + this.getAktif() + ", "
                + "keterangan=" + this.getKeterangan() + ", "
                + this.getTempatLahirExtend().toString() + ", "
                + this.getTahunAjaranExtend().toString() + ", "
                + this.getTahunMasukExtend().toString() + ", "
                + this.getProgramStudiExtend().toString()
                + ")";
    }
}
