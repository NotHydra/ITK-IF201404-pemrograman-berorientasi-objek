package models;

import interfaces.MataKuliahInterface;

public class MataKuliahModel extends BaseModel implements MataKuliahInterface {
    private final int id;
    private final String kode;
    private final String mataKuliah;
    private final String deskripsi;
    private final int sks;

    public MataKuliahModel(String kode, String mataKuliah, String deskripsi, int sks) {
        validate(kode, mataKuliah, deskripsi, sks);

        this.id = -1;
        this.kode = kode;
        this.mataKuliah = mataKuliah;
        this.deskripsi = deskripsi;
        this.sks = sks;
    }

    public MataKuliahModel(int id, String kode, String mataKuliah, String deskripsi, int sks) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(kode, mataKuliah, deskripsi, sks);

        this.id = id;
        this.kode = kode;
        this.mataKuliah = mataKuliah;
        this.deskripsi = deskripsi;
        this.sks = sks;
    }

    private void validate(String kode, String mataKuliah, String deskripsi, int sks) {
        if (kode == null || kode.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode cannot be empty");
        }

        if (mataKuliah == null || mataKuliah.trim().isEmpty()) {
            throw new IllegalArgumentException("Mata kuliah cannot be empty");
        }

        if (deskripsi == null || deskripsi.trim().isEmpty()) {
            throw new IllegalArgumentException("Deskripsi cannot be empty");
        }

        if (sks <= 0) {
            throw new IllegalArgumentException("SKS is invalid");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getKode() {
        return this.kode;
    }

    @Override
    public String getMataKuliah() {
        return this.mataKuliah;
    }

    @Override
    public String getDeskripsi() {
        return this.deskripsi;
    }

    @Override
    public int getSKS() {
        return this.sks;
    }

    @Override
    public String toString() {
        return "MataKuliah("
                + "id=" + this.id + ", "
                + "kode=" + this.kode + ", "
                + "mataKuliah=" + this.mataKuliah + ", "
                + "deskripsi=" + this.deskripsi + ", "
                + "sks=" + this.sks
                + ")";
    }
}
