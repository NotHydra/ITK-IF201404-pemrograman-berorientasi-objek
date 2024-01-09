package services;

import java.sql.ResultSet;

import providers.Database;

public abstract class BaseService<ModelType> {
    private final String table;

    public BaseService(String table) {
        this.table = table;
    }

    public void display() {
        for (ModelType model : this.get()) {
            System.out.println(model);
            System.out.println();
        }
    };

    public abstract ModelType[] get();

    public abstract ModelType getOne(int id);

    public Integer[] getId() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal(table);
            final ResultSet result = database.executeQuery(""
                    + "SELECT "
                    + "id "
                    + "FROM " + table + ""
                    + ";");

            final Integer[] idList = new Integer[total];
            int i = 0;
            while (result.next()) {
                idList[i] = result.getInt("id");

                i++;
            }

            database.close();

            return idList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public abstract void add(ModelType model);

    public abstract void add(ModelType[] models);

    public abstract void change(int id, ModelType model);

    public void remove(int id) {
        try {
            final Database database = new Database();
            database.executeUpdate("DELETE FROM " + table + " WHERE id='" + id + "'");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        try {
            final Database database = new Database();
            database.disableForeignKey();
            database.executeUpdate("TRUNCATE TABLE " + this.table + ";");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
