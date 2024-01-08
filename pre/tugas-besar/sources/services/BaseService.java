package services;

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
