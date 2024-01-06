package models;

import enums.SesiEnum;
import interfaces.KelasInterface;

public class KelasModel extends BaseModel implements KelasInterface {
    private final int id;
    private final int idDosen;
    private final int idMataKuliah;
    private final char tipeKelas;
    private final int idRuangan;
    private final SesiEnum sesi;
    private final String tahunAjaran;

    public KelasModel(
            int idDosen,
            int idMataKuliah,
            char tipeKelas,
            int idRuangan,
            SesiEnum sesi,
            String tahunAjaran) {
        validate(idDosen, idMataKuliah, tipeKelas, idRuangan, tahunAjaran);

        this.id = -1;
        this.idDosen = idDosen;
        this.idMataKuliah = idMataKuliah;
        this.tipeKelas = tipeKelas;
        this.idRuangan = idRuangan;
        this.sesi = sesi;
        this.tahunAjaran = tahunAjaran;
    }

    public KelasModel(
            int id,
            int idDosen,
            int idMataKuliah,
            char tipeKelas,
            int idRuangan,
            SesiEnum sesi,
            String tahunAjaran) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(idDosen, idMataKuliah, tipeKelas, idRuangan, tahunAjaran);

        this.id = id;
        this.idDosen = idDosen;
        this.idMataKuliah = idMataKuliah;
        this.tipeKelas = tipeKelas;
        this.idRuangan = idRuangan;
        this.sesi = sesi;
        this.tahunAjaran = tahunAjaran;
    }

    private void validate(
            int idDosen,
            int idMataKuliah,
            char tipeKelas,
            int idRuangan,
            String tahunAjaran) {
        if (idDosen <= 0) {
            throw new IllegalArgumentException("Id dosen is invalid");
        }

        if (idMataKuliah <= 0) {
            throw new IllegalArgumentException("Id mata kuliah is invalid");
        }

        if (tipeKelas == ' ') {
            throw new IllegalArgumentException("Tipe kelas cannot be empty");
        }

        if (idRuangan <= 0) {
            throw new IllegalArgumentException("Id ruangan is invalid");
        }

        if (tahunAjaran == null || tahunAjaran.trim().isEmpty()) {
            throw new IllegalArgumentException("Tahun ajaran cannot be empty");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    public int getIdDosen() {
        return idDosen;
    }

    public int getIdMataKuliah() {
        return idMataKuliah;
    }

    public char getTipeKelas() {
        return tipeKelas;
    }

    public int getIdRuangan() {
        return idRuangan;
    }

    public SesiEnum getSesi() {
        return sesi;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    @Override
    public String toString() {
        return "Kelas("
                + "id=" + this.id + ", "
                + "idDosen=" + this.idDosen + ", "
                + "idMataKuliah=" + this.idMataKuliah + ", "
                + "tipeKelas=" + this.tipeKelas + ", "
                + "idRuangan=" + this.idRuangan + ", "
                + "tahunAjaran=" + this.tahunAjaran
                + ")";
    }
}
