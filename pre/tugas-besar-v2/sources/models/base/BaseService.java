package models.base;

import providers.Logger;
import providers.Database;

public abstract class BaseService<ModelType> {
    protected Logger logger;
    protected Database database;
    protected String table;

    protected BaseService(Logger logger, Database database) {
        this.logger = logger;
        this.database = database;
    }

    public void display() {
        this.logger.debug("Display");

        try {
            for (ModelType model : this.find()) {
                System.out.println(model);
                System.out.println();
            }
        } catch (Exception e) {
            this.logger.error("Failed to display: " + e.getMessage());
        }
    }

    public abstract ModelType[] find();

    public abstract ModelType findId(int id);

    public abstract void add(ModelType model);

    public abstract void change(ModelType model);

    public void remove(int id) {
        this.logger.debug("Remove");

        try {
            this.database.executeUpdate(""
                    + "DELETE FROM " + this.table + " "
                    + "WHERE id=" + id + ""
                    + ";");
        } catch (Exception e) {
            this.logger.error("Failed to remove: " + e.getMessage());
        }
    }

    public void truncate() {
        this.logger.debug("Truncate");

        try {
            this.database.executeUpdate(""
                    + "TRUNCATE TABLE " + this.table + ""
                    + ";");
        } catch (Exception e) {
            this.logger.error("Failed to truncate: " + e.getMessage());
        }
    }
}
