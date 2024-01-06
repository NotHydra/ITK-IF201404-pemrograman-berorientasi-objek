package models;

import interfaces.DosenExtendInterface;
import enums.JenisKelaminEnum;
import enums.GolonganDarahEnum;
import enums.AgamaEnum;
import utilities.CustomDate;

public class DosenExtendModel extends DosenModel implements DosenExtendInterface {
    private final TempatLahirModel tempatLahirExtend;
    private final PendidikanModel pendidikanExtend;
    private final ProgramStudiExtendModel programStudiExtend;

    public DosenExtendModel(
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
            String keterangan,
            String tempatLahirTempatLahir,
            String pendidikanPendidikan,
            String pendidikanSingkatan,
            int programStudiIdJurusan,
            String programStudiProgramStudi,
            String programStudiDeskripsi,
            String jurusanJurusan,
            String jurusanDeskripsi) {
        super(
                id,
                nik,
                nip,
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
                idPendidikan,
                idProgramStudi,
                aktif,
                keterangan);

        this.tempatLahirExtend = new TempatLahirModel(idTempatLahir, tempatLahirTempatLahir);
        this.pendidikanExtend = new PendidikanModel(idPendidikan, pendidikanPendidikan, pendidikanSingkatan);
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

    public PendidikanModel getPendidikanExtend() {
        return this.pendidikanExtend;
    }

    public ProgramStudiExtendModel getProgramStudiExtend() {
        return this.programStudiExtend;
    }

    @Override
    public String toString() {
        return "Dosen("
                + "id=" + this.getId() + ", "
                + "nik=" + this.getNIK() + ", "
                + "nim=" + this.getNIP() + ", "
                + "nama=" + this.getNama() + ", "
                + "email=" + this.getEmail() + ", "
                + "password=" + this.getPassword() + ", "
                + "alamat=" + this.getAlamat() + ", "
                + "idTempatLahir=" + this.getIdTempatLahir() + ", "
                + "tanggalLahir=" + CustomDate.dateToString(this.getTanggalLahir()) + ", "
                + "jenisKelamin=" + this.getJenisKelamin().value + ", "
                + "golonganDarah=" + this.getGolonganDarah().value + ", "
                + "agama=" + this.getAgama().value + ", "
                + "nomorTelepon=" + this.getNomorTelepon() + ", "
                + "idPendidikan=" + this.getIdPendidikan() + ", "
                + "idProgramStudi=" + this.getIdProgramStudi() + ", "
                + "aktif=" + this.getAktif() + ", "
                + "keterangan=" + this.getKeterangan() + ", "
                + this.getTempatLahirExtend().toString() + ", "
                + this.getPendidikanExtend().toString() + ", "
                + this.getProgramStudiExtend().toString()
                + ")";
    }
}
