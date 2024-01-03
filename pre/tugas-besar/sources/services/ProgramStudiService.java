package services;

import java.sql.*;

import providers.Database;
import models.ProgramStudiModel;

public class ProgramStudiService extends BaseService<ProgramStudiModel> {
    private final String table = "program_studi";

    @Override
    public ProgramStudiModel[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database
                    .executeQuery("SELECT id, id_jurusan, program_studi, deskripsi FROM " + table + ";");

            final ProgramStudiModel[] jurusanList = new ProgramStudiModel[total];
            int i = 0;
            while (result.next()) {
                jurusanList[i] = new ProgramStudiModel(
                        result.getInt("id"),
                        result.getInt("id_jurusan"),
                        result.getString("program_studi"),
                        result.getString("deskripsi"));

                i++;
            }

            database.close();

            return jurusanList;
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
                            + "SELECT id, id_jurusan, program_studi, deskripsi "
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
