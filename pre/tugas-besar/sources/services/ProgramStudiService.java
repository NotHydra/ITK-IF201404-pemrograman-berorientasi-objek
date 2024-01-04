package services;

import java.sql.*;

import providers.Database;
import models.ProgramStudiModel;
import models.ProgramStudiExtendModel;

public class ProgramStudiService
        extends BaseService<ProgramStudiModel>
        implements ExtendService<ProgramStudiExtendModel> {
    private final String table = "program_studi";

    @Override
    public ProgramStudiModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "id_jurusan, "
                            + "program_studi, "
                            + "deskripsi "
                            + "FROM " + table
                            + ";");

            final ProgramStudiModel[] programStudiList = new ProgramStudiModel[total];
            int i = 0;
            while (result.next()) {
                programStudiList[i] = new ProgramStudiModel(
                        result.getInt("id"),
                        result.getInt("id_jurusan"),
                        result.getString("program_studi"),
                        result.getString("deskripsi"));

                i++;
            }

            database.close();

            return programStudiList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ProgramStudiModel getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "id, "
                            + "id_jurusan, "
                            + "program_studi, "
                            + "deskripsi "
                            + "FROM " + table + " "
                            + "WHERE id='" + id + "'"
                            + ";");

            ProgramStudiModel programStudi = null;

            if (result.next()) {
                programStudi = new ProgramStudiModel(
                        result.getInt("id"),
                        result.getInt("id_jurusan"),
                        result.getString("program_studi"),
                        result.getString("deskripsi"));
            }

            database.close();

            return programStudi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ProgramStudiExtendModel[] getExtend() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "program_studi.id, "
                            + "program_studi.id_jurusan, "
                            + "program_studi.program_studi, "
                            + "program_studi.deskripsi "
                            + "jurusan.jurusan, "
                            + "jurusan.deskripsi, "
                            + "FROM program_studi "
                            + "INNER JOIN jurusan ON program_studi.id_jurusan=jurusan.id"
                            + ";");

            final ProgramStudiExtendModel[] programStudiList = new ProgramStudiExtendModel[total];
            int i = 0;
            while (result.next()) {
                programStudiList[i] = new ProgramStudiExtendModel(
                        result.getInt("program_studi.id"),
                        result.getInt("program_studi.id_jurusan"),
                        result.getString("program_studi.program_studi"),
                        result.getString("program_studi.deskripsi"),
                        result.getString("jurusan.jurusan"),
                        result.getString("jurusan.deskripsi"));

                i++;
            }

            database.close();

            return programStudiList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ProgramStudiExtendModel getOneExtend(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery(""
                            + "SELECT "
                            + "program_studi.id, "
                            + "program_studi.id_jurusan, "
                            + "program_studi.program_studi, "
                            + "program_studi.deskripsi "
                            + "jurusan.jurusan, "
                            + "jurusan.deskripsi, "
                            + "FROM program_studi "
                            + "INNER JOIN jurusan ON program_studi.id_jurusan=jurusan.id"
                            + "WHERE id='" + id + "'"
                            + ";");

            ProgramStudiExtendModel programStudi = null;

            if (result.next()) {
                programStudi = new ProgramStudiExtendModel(
                        result.getInt("program_studi.id"),
                        result.getInt("program_studi.id_jurusan"),
                        result.getString("program_studi.program_studi"),
                        result.getString("program_studi.deskripsi"),
                        result.getString("jurusan.jurusan"),
                        result.getString("jurusan.deskripsi"));
            }

            database.close();

            return programStudi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(ProgramStudiModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(
                    "INSERT INTO " + table + " (id_jurusan, program_studi, deskripsi) VALUES ("
                            + "'" + model.getIdJurusan() + "', "
                            + "'" + model.getProgramStudi() + "', "
                            + "'" + model.getDeskripsi() + "'"
                            + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(ProgramStudiModel[] models) {
        try {
            final Database database = new Database();

            String query = "INSERT INTO " + table + " (id_jurusan, program_studi, deskripsi) VALUES ";
            for (int i = 0; i < models.length; i++) {
                query = query + "("
                        + "'" + models[i].getIdJurusan() + "', "
                        + "'" + models[i].getProgramStudi() + "', "
                        + "'" + models[i].getDeskripsi() + "'"
                        + ")";

                if (i != (models.length - 1)) {
                    query = query + ", ";
                } else {
                    query = query + ";";
                }
            }

            database.executeUpdate(query);

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change(int id, ProgramStudiModel model) {
        try {
            final Database database = new Database();
            database.executeUpdate(
                    "UPDATE " + table + " SET "
                            + "id_jurusan='" + model.getIdJurusan() + "', "
                            + "program_studi='" + model.getProgramStudi() + "', "
                            + "deskripsi='" + model.getDeskripsi() + "' "
                            + "WHERE "
                            + "id='" + id + "'"
                            + ";");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try {
            final Database database = new Database();
            database.executeUpdate("DELETE FROM " + table + " WHERE id='" + id + "'");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
