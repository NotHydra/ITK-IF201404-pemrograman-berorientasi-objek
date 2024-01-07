package models;

import enums.IndeksEnum;
import interfaces.MahasiswaKelasInterface;

public class MahasiswaKelasModel extends BaseModel implements MahasiswaKelasInterface {
    private final int id;
    private final int idKelas;
    private final int idMahasiswa;
    private final IndeksEnum indeks;

    public MahasiswaKelasModel(int idKelas, int idMahasiswa, IndeksEnum indeks) {
        validate(idKelas, idMahasiswa);

        this.id = -1;
        this.idKelas = idKelas;
        this.idMahasiswa = idMahasiswa;
        this.indeks = indeks;
    }

    public MahasiswaKelasModel(int id, int idKelas, int idMahasiswa, IndeksEnum indeks) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid");
        }

        validate(idKelas, idMahasiswa);

        this.id = id;
        this.idKelas = idKelas;
        this.idMahasiswa = idMahasiswa;
        this.indeks = indeks;
    }

    private void validate(int idKelas, int idMahasiswa) {
        if (idKelas <= 0) {
            throw new IllegalArgumentException("Id kelas is invalid");
        }

        if (idMahasiswa <= 0) {
            throw new IllegalArgumentException("Id mahasiswa is invalid");
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public IndeksEnum getIndeks() {
        return indeks;
    }

    @Override
    public String toString() {
        return "MahasiswaKelas("
                + "id=" + this.id + ", "
                + "idKelas=" + this.idKelas + ", "
                + "idMahasiswa=" + this.idMahasiswa + ", "
                + "indeks=" + this.indeks
                + ")";
    }
}
