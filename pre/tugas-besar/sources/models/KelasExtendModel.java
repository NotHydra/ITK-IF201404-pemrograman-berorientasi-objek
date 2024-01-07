package models;

import enums.SesiEnum;
import enums.JenisKelaminEnum;
import enums.GolonganDarahEnum;
import enums.AgamaEnum;
import interfaces.KelasExtendInterface;

public class KelasExtendModel extends KelasModel implements KelasExtendInterface {
    private final DosenExtendModel dosenExtend;
    private final MataKuliahModel mataKuliahExtend;
    private final RuanganModel ruanganExtend;

    public KelasExtendModel(
            int id,
            int idDosen,
            int idMataKuliah,
            char tipeKelas,
            int idRuangan,
            SesiEnum sesi,
            String tahunAjaran,
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
            String ruanganRuangan) {
        super(
                id,
                idDosen,
                idMataKuliah,
                tipeKelas,
                idRuangan,
                sesi,
                tahunAjaran);

        this.dosenExtend = new DosenExtendModel(
                idDosen,
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
                dosenJurusanDeskripsi);

        this.mataKuliahExtend = new MataKuliahModel(
                idMataKuliah,
                mataKuliahKode,
                mataKuliahMataKuliah,
                mataKuliahDeskripsi,
                mataKuliahSKS);

        this.ruanganExtend = new RuanganModel(idRuangan, ruanganRuangan);
    }

    public DosenExtendModel getDosenExtend() {
        return dosenExtend;
    }

    public MataKuliahModel getMataKuliahExtend() {
        return mataKuliahExtend;
    }

    public RuanganModel getRuanganExtend() {
        return ruanganExtend;
    }

    @Override
    public String toString() {
        return "Kelas("
                + "id=" + this.getId() + ", "
                + "idDosen=" + this.getIdDosen() + ", "
                + "idMataKuliah=" + this.getIdMataKuliah() + ", "
                + "tipeKelas=" + this.getTipeKelas() + ", "
                + "idRuangan=" + this.getIdRuangan() + ", "
                + "tahunAjaran=" + this.getTahunAjaran() + ", "
                + this.getDosenExtend().toString() + ", "
                + this.getMataKuliahExtend().toString() + ", "
                + this.getRuanganExtend().toString()
                + ")";
    }
}
