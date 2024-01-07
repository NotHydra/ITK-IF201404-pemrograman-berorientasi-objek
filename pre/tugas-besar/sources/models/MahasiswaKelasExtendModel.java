package models;

import enums.AgamaEnum;
import enums.GolonganDarahEnum;
import enums.IndeksEnum;
import enums.JenisKelaminEnum;
import enums.SesiEnum;
import interfaces.MahasiswaKelasExtendInterface;

public class MahasiswaKelasExtendModel extends MahasiswaKelasModel implements MahasiswaKelasExtendInterface {
    private final KelasExtendModel kelasExtend;
    private final MahasiswaExtendModel mahasiswaExtend;

    public MahasiswaKelasExtendModel(
            int id,
            int idKelas,
            int idMahasiswa,
            IndeksEnum indeks,
            int kelasIdDosen,
            int kelasIdMataKuliah,
            char kelasTipeKelas,
            int kelasIdRuangan,
            SesiEnum kelasSesi,
            String kelasTahunAjaran,
            String dosenNIK,
            String dosenNIP,
            String dosenNama,
            String dosenEmail,
            String dosenPassword,
            String dosenAlamat,
            int dosenIdTempatLahir,
            String dosenTanggalLahir,
            JenisKelaminEnum dosenJenisKelamin,
            GolonganDarahEnum dosenGolonganDarah,
            AgamaEnum dosenAgama,
            String dosenNomorTelepon,
            int dosenIdPendidikan,
            int dosenIdProgramStudi,
            boolean dosenAktif,
            String dosenKeterangan,
            String dosenTempatLahirTempatLahir,
            String dosenPendidikanPendidikan,
            String dosenPendidikanSingkatan,
            int dosenProgramStudiIdJurusan,
            String dosenProgramStudiProgramStudi,
            String dosenProgramStudiDeskripsi,
            String dosenJurusanJurusan,
            String dosenJurusanDeskripsi,
            String mataKuliahKode,
            String mataKuliahMataKuliah,
            String mataKuliahDeskripsi,
            int mataKuliahSKS,
            String ruanganRuangan,
            String mahasiswaNIK,
            String mahasiswaNIM,
            String mahasiswaNama,
            String mahasiswaEmail,
            String mahasiswaPassword,
            String mahasiswaAlamat,
            int mahasiswaIdTempatLahir,
            String mahasiswaTanggalLahir,
            JenisKelaminEnum mahasiswaJenisKelamin,
            GolonganDarahEnum mahasiswaGolonganDarah,
            AgamaEnum mahasiswaAgama,
            String mahasiswaNomorTelepon,
            int mahasiswaIdTahunAjaran,
            int mahasiswaIdTahunMasuk,
            int mahasiswaIdProgramStudi,
            int mahasiswaIdDosenWali,
            boolean mahasiswaAktif,
            String mahasiswaKeterangan,
            String mahasiswaTempatLahirTempatLahir,
            String mahasiswaTahunAjaranTahunAjaran,
            String mahasiswaTahunMasukTahunMasuk,
            int mahasiswaProgramStudiIdJurusan,
            String mahasiswaProgramStudiProgramStudi,
            String mahasiswaProgramStudiDeskripsi,
            String mahasiswaJurusanJurusan,
            String mahasiswaJurusanDeskripsi,
            String mahasiswaDosenWaliNIK,
            String mahasiswaDosenWaliNIP,
            String mahasiswaDosenWaliNama,
            String mahasiswaDosenWaliEmail,
            String mahasiswaDosenWaliPassword,
            String mahasiswaDosenWaliAlamat,
            int mahasiswaDosenWaliIdTempatLahir,
            String mahasiswaDosenWaliTanggalLahir,
            JenisKelaminEnum mahasiswaDosenWaliJenisKelamin,
            GolonganDarahEnum mahasiswaDosenWaliGolonganDarah,
            AgamaEnum mahasiswaDosenWaliAgama,
            String mahasiswaDosenWaliNomorTelepon,
            int mahasiswaDosenWaliIdPendidikan,
            int mahasiswaDosenWaliIdProgramStudi,
            boolean mahasiswaDosenWaliAktif,
            String mahasiswaDosenWaliKeterangan,
            String mahasiswaDosenWaliTempatLahirTempatLahir,
            String mahasiswaDosenWaliPendidikanPendidikan,
            String mahasiswaDosenWaliPendidikanSingkatan,
            int mahasiswaDosenWaliProgramStudiIdJurusan,
            String mahasiswaDosenWaliProgramStudiProgramStudi,
            String mahasiswaDosenWaliProgramStudiDeskripsi,
            String mahasiswaDosenWaliJurusanJurusan,
            String mahasiswaDosenWaliJurusanDeskripsi) {
        super(id, idKelas, idMahasiswa, indeks);

        this.kelasExtend = new KelasExtendModel(
                idKelas,
                kelasIdDosen,
                kelasIdMataKuliah,
                kelasTipeKelas,
                kelasIdRuangan,
                kelasSesi,
                kelasTahunAjaran,
                dosenNIK,
                dosenNIP,
                dosenNama,
                dosenEmail,
                dosenPassword,
                dosenAlamat,
                dosenIdTempatLahir,
                dosenTanggalLahir,
                dosenJenisKelamin,
                dosenGolonganDarah,
                dosenAgama,
                dosenNomorTelepon,
                dosenIdPendidikan,
                dosenIdProgramStudi,
                dosenAktif,
                dosenKeterangan,
                dosenTempatLahirTempatLahir,
                dosenPendidikanPendidikan,
                dosenPendidikanSingkatan,
                dosenProgramStudiIdJurusan,
                dosenProgramStudiProgramStudi,
                dosenProgramStudiDeskripsi,
                dosenJurusanJurusan,
                dosenJurusanDeskripsi,
                mataKuliahKode,
                mataKuliahMataKuliah,
                mataKuliahDeskripsi,
                mataKuliahSKS,
                ruanganRuangan);

        this.mahasiswaExtend = new MahasiswaExtendModel(
                idMahasiswa,
                mahasiswaNIK,
                mahasiswaNIM,
                mahasiswaNama,
                mahasiswaEmail,
                mahasiswaPassword,
                mahasiswaAlamat,
                mahasiswaIdTempatLahir,
                mahasiswaTanggalLahir,
                mahasiswaJenisKelamin,
                mahasiswaGolonganDarah,
                mahasiswaAgama,
                mahasiswaNomorTelepon,
                mahasiswaIdTahunAjaran,
                mahasiswaIdTahunMasuk,
                mahasiswaIdProgramStudi,
                mahasiswaIdDosenWali,
                mahasiswaAktif,
                mahasiswaKeterangan,
                mahasiswaTempatLahirTempatLahir,
                mahasiswaTahunAjaranTahunAjaran,
                mahasiswaTahunMasukTahunMasuk,
                mahasiswaProgramStudiIdJurusan,
                mahasiswaProgramStudiProgramStudi,
                mahasiswaProgramStudiDeskripsi,
                mahasiswaJurusanJurusan,
                mahasiswaJurusanDeskripsi,
                mahasiswaDosenWaliNIK,
                mahasiswaDosenWaliNIP,
                mahasiswaDosenWaliNama,
                mahasiswaDosenWaliEmail,
                mahasiswaDosenWaliPassword,
                mahasiswaDosenWaliAlamat,
                mahasiswaDosenWaliIdTempatLahir,
                mahasiswaDosenWaliTanggalLahir,
                mahasiswaDosenWaliJenisKelamin,
                mahasiswaDosenWaliGolonganDarah,
                mahasiswaDosenWaliAgama,
                mahasiswaDosenWaliNomorTelepon,
                mahasiswaDosenWaliIdPendidikan,
                mahasiswaDosenWaliIdProgramStudi,
                mahasiswaDosenWaliAktif,
                mahasiswaDosenWaliKeterangan,
                mahasiswaDosenWaliTempatLahirTempatLahir,
                mahasiswaDosenWaliPendidikanPendidikan,
                mahasiswaDosenWaliPendidikanSingkatan,
                mahasiswaDosenWaliProgramStudiIdJurusan,
                mahasiswaDosenWaliProgramStudiProgramStudi,
                mahasiswaDosenWaliProgramStudiDeskripsi,
                mahasiswaDosenWaliJurusanJurusan,
                mahasiswaDosenWaliJurusanDeskripsi);
    }

    public KelasExtendModel getKelasExtend() {
        return this.kelasExtend;
    }

    public MahasiswaExtendModel getMahasiswaExtend() {
        return this.mahasiswaExtend;
    }

    @Override
    public String toString() {
        return "MahasiswaKelas("
                + "id=" + this.getId() + ", "
                + "idKelas=" + this.getIdKelas() + ", "
                + "idMahasiswa=" + this.getIdMahasiswa() + ", "
                + "indeks=" + this.getIndeks() + ", "
                + this.getKelasExtend().toString() + ", "
                + this.getMahasiswaExtend().toString()
                + ")";
    }
}
