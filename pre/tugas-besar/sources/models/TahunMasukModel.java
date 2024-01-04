package models;

import interfaces.TahunMasukInterface;

public class TahunMasukModel extends BaseModel implements TahunMasukInterface {
    private final int id;
    private final String tahunMasuk;

    public TahunMasukModel(String tahunMasuk) {
        validate(tahunMasuk);

        this.id = -1;
        this.tahunMasuk = tahunMasuk;
    }

    public TahunMasukModel(int id, String tahunMasuk) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(tahunMasuk);

        this.id = id;
        this.tahunMasuk = tahunMasuk;
    }

    private void validate(String tahunMasuk) {
        if (tahunMasuk == null || tahunMasuk.trim().isEmpty()) {
            throw new IllegalArgumentException("Tahun masuk cannot be empty");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getTahunMasuk() {
        return this.tahunMasuk;

    }

    @Override
    public String toString() {
        return "TahunMasuk("
                + "id=" + this.id + ", "
                + "tahunMasuk=" + this.tahunMasuk
                + ")";
    }
}
