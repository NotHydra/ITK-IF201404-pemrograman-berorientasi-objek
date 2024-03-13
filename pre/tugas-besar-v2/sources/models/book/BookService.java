package models.book;

import providers.Logger;

import java.sql.ResultSet;

import providers.Database;

public class BookService {
    private static BookService instance;

    private Logger logger;
    private Database database;
    private String table;

    private BookService(Logger logger, Database database) {
        this.logger = logger;
        this.database = database;
    }

    public static BookService getInstance() {
        if (BookService.instance == null) {
            try {
                BookService.instance = new BookService(new Logger(BookService.class.getName()), Database.getInstance());

                BookService.instance.table = "books";
            } catch (Exception e) {
                BookService.instance.logger.error("Failed to initialize BookService instance: " + e.getMessage());

                throw new RuntimeException("Failed to initialize BookService instance");
            }
        }

        BookService.instance.logger.debug("Get Instance");

        return BookService.instance;
    }

    public void display() {
        this.logger.debug("Display");

        try {
            for (BookModel model : this.find()) {
                System.out.println(model);
                System.out.println();
            }
        } catch (Exception e) {
            this.logger.error("Failed to display: " + e.getMessage());
        }
    }

    public BookModel[] find() {
        this.logger.debug("Find");

        try {
            final int total = this.database.tableTotal(this.table);
            final ResultSet result = this.database.executeQuery(""
                    + "SELECT "
                    + "id, "
                    + "title, "
                    + "description "
                    + "FROM " + this.table + ""
                    + ";");

            final BookModel[] models = new BookModel[total];

            int i = 0;
            while (result.next()) {
                models[i] = new BookModel(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("description"));

                i++;
            }

            return models;
        } catch (Exception e) {
            this.logger.error("Failed to find: " + e.getMessage());
        }

        return null;
    }

    public BookModel findId(int id) {
        this.logger.debug("Find Id");

        try {
            final ResultSet result = this.database.executeQuery(""
                    + "SELECT "
                    + "id, "
                    + "title, "
                    + "description "
                    + "FROM " + this.table + " "
                    + "WHERE id=" + id + ""
                    + ";");

            if (result.next()) {
                return new BookModel(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("description"));
            }
        } catch (Exception e) {
            this.logger.error("Failed to find id: " + e.getMessage());
        }

        return null;
    }

    public void add(BookModel model) {
        this.logger.debug("Add");

        try {
            this.database.executeUpdate(""
                    + "INSERT INTO " + this.table + " ("
                    + "title, "
                    + "description"
                    + ") VALUES ("
                    + "'" + model.getTitle() + "', "
                    + "'" + model.getDescription() + "'"
                    + ");");
        } catch (Exception e) {
            this.logger.error("Failed to add: " + e.getMessage());
        }
    }

    public void change(BookModel model) {
        this.logger.debug("Change");

        try {
            this.database.executeUpdate(""
                    + "UPDATE " + this.table + " SET "
                    + "title='" + model.getTitle() + "', "
                    + "description='" + model.getDescription() + "' "
                    + "WHERE "
                    + "id=" + model.getId() + ""
                    + ";");
        } catch (Exception e) {
            this.logger.error("Failed to change: " + e.getMessage());
        }
    }

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
