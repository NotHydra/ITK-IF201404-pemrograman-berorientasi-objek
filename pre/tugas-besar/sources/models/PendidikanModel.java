package models;

import interfaces.PendidikanInterface;

public class PendidikanModel extends BaseModel implements PendidikanInterface {
    private final int id;
    private final String pendidikan;
    private final String singkatan;

    public PendidikanModel(String pendidikan, String singkatan) {
        validate(pendidikan, singkatan);

        this.id = -1;
        this.pendidikan = pendidikan;
        this.singkatan = singkatan;
    }

    public PendidikanModel(int id, String pendidikan, String singkatan) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(pendidikan, singkatan);

        this.id = id;
        this.pendidikan = pendidikan;
        this.singkatan = singkatan;
    }

    private void validate(String pendidikan, String singkatan) {
        if (pendidikan == null || pendidikan.trim().isEmpty()) {
            throw new IllegalArgumentException("Pendidikan cannot be empty");
        }

        if (singkatan == null || singkatan.trim().isEmpty()) {
            throw new IllegalArgumentException("Singkatan cannot be empty");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getPendidikan() {
        return this.pendidikan;

    }

    @Override
    public String getSingkatan() {
        return this.singkatan;
    }

    @Override
    public String toString() {
        return "Pendidikan("
                + "id=" + this.id + ", "
                + "pendidikan=" + this.pendidikan + ", "
                + "singkatan=" + this.singkatan
                + ")";
    }
}
