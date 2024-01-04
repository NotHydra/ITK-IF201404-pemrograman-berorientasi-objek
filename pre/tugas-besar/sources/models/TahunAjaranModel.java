package models;

import interfaces.TahunAjaranInterface;

public class TahunAjaranModel extends BaseModel implements TahunAjaranInterface {
    private final int id;
    private final String tahunAjaran;

    public TahunAjaranModel(String tahunAjaran) {
        validate(tahunAjaran);

        this.id = -1;
        this.tahunAjaran = tahunAjaran;
    }

    public TahunAjaranModel(int id, String tahunAjaran) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(tahunAjaran);

        this.id = id;
        this.tahunAjaran = tahunAjaran;
    }

    private void validate(String tahunAjaran) {
        if (tahunAjaran == null || tahunAjaran.trim().isEmpty()) {
            throw new IllegalArgumentException("Tahun ajaran cannot be empty");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getTahunAjaran() {
        return this.tahunAjaran;

    }

    @Override
    public String toString() {
        return "TahunAjaran("
                + "id=" + this.id + ", "
                + "tahunAjaran=" + this.tahunAjaran
                + ")";
    }
}
