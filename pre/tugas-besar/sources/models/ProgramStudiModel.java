package models;

import interfaces.ProgramStudiInterface;

public class ProgramStudiModel extends BaseModel implements ProgramStudiInterface {
    private final int id;
    private final int idJurusan;
    private final String programStudi;
    private final String deskripsi;

    public ProgramStudiModel(int idJurusan, String programStudi, String deskripsi) {
        validate(idJurusan, programStudi, deskripsi);

        this.id = -1;
        this.idJurusan = idJurusan;
        this.programStudi = programStudi;
        this.deskripsi = deskripsi;
    }

    public ProgramStudiModel(int id, int idJurusan, String programStudi, String deskripsi) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(idJurusan, programStudi, deskripsi);

        this.id = id;
        this.idJurusan = idJurusan;
        this.programStudi = programStudi;
        this.deskripsi = deskripsi;
    }

    private void validate(int idJurusan, String programStudi, String deskripsi) {
        if (idJurusan <= 0) {
            throw new IllegalArgumentException("Id jurusan is invalid");
        }

        if (programStudi == null || programStudi.trim().isEmpty()) {
            throw new IllegalArgumentException("Program studi cannot be empty");
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
    public int getIdJurusan() {
        return this.idJurusan;
    }

    @Override
    public String getProgramStudi() {
        return this.programStudi;

    }

    @Override
    public String getDeskripsi() {
        return this.deskripsi;
    }

    @Override
    public String toString() {
        return "ProgramStudi("
                + "id=" + this.id + ", "
                + "idJurusan=" + this.idJurusan + ", "
                + "programStudi=" + this.programStudi + ", "
                + "deskripsi=" + this.deskripsi
                + ")";
    }

}
