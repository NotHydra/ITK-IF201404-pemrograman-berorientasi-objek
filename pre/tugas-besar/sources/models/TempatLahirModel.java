package models;

import interfaces.TempatLahirInterface;


public class TempatLahirModel extends BaseModel implements TempatLahirInterface {
    private final int id;
    private final String tempatLahir;

    public TempatLahirModel(String tempatLahir) {
        validate(tempatLahir);

        this.id = -1;
        this.tempatLahir = tempatLahir;
    }

    public TempatLahirModel(int id, String tempatLahir) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(tempatLahir);

        this.id = id;
        this.tempatLahir = tempatLahir;
    }

    private void validate(String tempatLahir) {
        if (tempatLahir == null || tempatLahir.trim().isEmpty()) {
            throw new IllegalArgumentException("Tempat lahir cannot be empty");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getTempatLahir() {
        return this.tempatLahir;
    }

    @Override
    public String toString() {
        return "TempatLahir("
                + "id=" + this.id + ", "
                + "tempatLahir=" + this.tempatLahir
                + ")";
    }
}
