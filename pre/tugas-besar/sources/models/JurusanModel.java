package models;

import interfaces.JurusanInterface;

public class JurusanModel extends BaseModel implements JurusanInterface {
    private final int id;
    private final String jurusan;
    private final String deskripsi;

    public JurusanModel(String jurusan, String deskripsi) {
        validate(jurusan, deskripsi);

        this.id = -1;
        this.jurusan = jurusan;
        this.deskripsi = deskripsi;
    }

    public JurusanModel(int id, String jurusan, String deskripsi) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(jurusan, deskripsi);

        this.id = id;
        this.jurusan = jurusan;
        this.deskripsi = deskripsi;
    }

    private void validate(String jurusan, String deskripsi) {
        if (jurusan == null || jurusan.trim().isEmpty()) {
            throw new IllegalArgumentException("Jurusan cannot be empty");
        }

        if (deskripsi == null || deskripsi.trim().isEmpty()) {
            throw new IllegalArgumentException("Deskripsi cannot be empty");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getJurusan() {
        return this.jurusan;

    }

    @Override
    public String getDeskripsi() {
        return this.deskripsi;
    }

    @Override
    public String toString() {
        return "Jurusan("
                + "id=" + this.id + ", "
                + "jurusan=" + this.jurusan + ", "
                + "deskripsi=" + this.deskripsi
                + ")";
    }

}
