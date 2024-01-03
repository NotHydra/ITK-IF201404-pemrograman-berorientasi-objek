package models;

import interfaces.ProgramStudiExtendInterface;

public class ProgramStudiExtendModel extends ProgramStudiModel implements ProgramStudiExtendInterface {
    private final JurusanModel jurusanExtend;

    public ProgramStudiExtendModel(
            int id,
            int idJurusan,
            String programStudi,
            String deskripsi,
            String jurusanJurusan,
            String jurusanDeskripsi) {
        super(id, idJurusan, programStudi, deskripsi);

        this.jurusanExtend = new JurusanModel(idJurusan, jurusanJurusan, jurusanDeskripsi);
    }

    @Override
    public JurusanModel getJurusanExtend() {
        return this.jurusanExtend;
    }

    @Override
    public String toString() {
        return "ProgramStudi("
                + "id=" + this.getId() + ", "
                + "idJurusan=" + this.getIdJurusan() + ", "
                + "programStudi=" + this.getProgramStudi() + ", "
                + "deskripsi=" + this.getDeskripsi() + ", "
                + "Jurusan("
                + "jurusan=" + this.getJurusanExtend().getJurusan() + ", "
                + "deskripsi=" + this.getJurusanExtend().getDeskripsi()
                + ")"
                + ")";
    }

}
