package models.book;

import java.sql.ResultSet;

import providers.Logger;
import providers.Database;

import models.base.BaseService;
import models.book.interfaces.BookServiceInterface;

public class BookService extends BaseService<BookModel> implements BookServiceInterface {
    private static BookService instance;

    private Logger logger;
    private Database database;
    private String table;

    private BookService(Logger logger, Database database, String table) {
        super(logger, database, table);

        this.logger = logger;
        this.database = database;
        this.table = table;
    }

    public static BookService getInstance() {
        if (BookService.instance == null) {
            try {
                BookService.instance = new BookService(
                        new Logger(BookService.class.getName()),
                        Database.getInstance(),
                        "book");
            } catch (Exception e) {
                BookService.instance.logger.error("Failed to initialize BookService instance: " + e.getMessage());

                throw new RuntimeException("Failed to initialize BookService instance");
            }
        }

        BookService.instance.logger.debug("Get Instance");

        return BookService.instance;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public void change(int id, BookModel model) {
        this.logger.debug("Change");

        try {
            this.database.executeUpdate(""
                    + "UPDATE " + this.table + " SET "
                    + "title='" + model.getTitle() + "', "
                    + "description='" + model.getDescription() + "' "
                    + "WHERE "
                    + "id=" + id + ""
                    + ";");
        } catch (Exception e) {
            this.logger.error("Failed to change: " + e.getMessage());
        }
    }
}
