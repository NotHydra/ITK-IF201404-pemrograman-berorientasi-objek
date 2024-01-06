package models;

import utilities.CustomDate;

public class DosenWaliExtendModel extends DosenExtendModel {

    public DosenWaliExtendModel(
            int id,
            String nik,
            String nip,
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
                keterangan,
                tempatLahirTempatLahir,
                pendidikanPendidikan,
                pendidikanSingkatan,
                programStudiIdJurusan,
                programStudiProgramStudi,
                programStudiDeskripsi,
                jurusanJurusan,
                jurusanDeskripsi);
    }

    @Override
    public String toString() {
        return "DosenWali("
                + "id=" + this.getId() + ", "
                + "nik=" + this.getNIK() + ", "
                + "nim=" + this.getNIP() + ", "
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
