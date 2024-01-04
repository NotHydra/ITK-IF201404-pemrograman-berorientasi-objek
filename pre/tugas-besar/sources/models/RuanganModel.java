package models;

import interfaces.RuanganInterface;

public class RuanganModel extends BaseModel implements RuanganInterface {
    private final int id;
    private final String ruangan;

    public RuanganModel(String ruangan) {
        validate(ruangan);

        this.id = -1;
        this.ruangan = ruangan;
    }

    public RuanganModel(int id, String ruangan) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(ruangan);

        this.id = id;
        this.ruangan = ruangan;
    }

    private void validate(String ruangan) {
        if (ruangan == null || ruangan.trim().isEmpty()) {
            throw new IllegalArgumentException("Ruangan cannot be empty");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getRuangan() {
        return this.ruangan;

    }

    @Override
    public String toString() {
        return "Ruangan("
                + "id=" + this.id + ", "
                + "ruangan=" + this.ruangan
                + ")";
    }
}
