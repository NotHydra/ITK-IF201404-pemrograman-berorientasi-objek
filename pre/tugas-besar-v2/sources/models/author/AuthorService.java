package models.author;


import java.sql.ResultSet;

import providers.Logger;
import providers.Database;

import interfaces.ServiceFindInterface;
import interfaces.ServiceAddInterface;
import interfaces.ServiceChangeInterface;

import models.base.BaseService;

import models.book.BookModel;

public class AuthorService
        extends BaseService<AuthorModel>
        implements ServiceFindInterface<AuthorModel>, ServiceAddInterface<AuthorModel>, ServiceChangeInterface<AuthorModel> {
    private static AuthorService instance;

    private AuthorService(Logger logger, Database database, String table) {
        super(logger, database, table);
    }

    public static AuthorService getInstance() {
        if (AuthorService.instance == null) {
            try {
                AuthorService.instance = new AuthorService(new Logger(AuthorService.class.getName()), Database.getInstance(), "author");
            }
            catch (Exception e) {
                AuthorService.instance.logger.error("Failed to initialize AuthorService instance: " + e.getMessage());

                throw new RuntimeException("Failed to initialize AuthorService instance");
            }
        }

        AuthorService.instance.logger.debug("Get Instance");

        return AuthorService.instance;
    }

    @Override
    public AuthorModel[] find() {
        this.logger.debug("Find");

        try {
            final int total = this.database.tableTotal(this.table);
            final ResultSet result = this.database.executeQuery(""
                    + "SELECT "
                    + "id, "
                    + "name, "
                    + "idBook "
                    + "FROM " + this.table + ""
                    + ";");

            final AuthorModel[] models = new AuthorModel[total];

            int i = 0;
            while (result.next()) {
                models[i] = new AuthorModel(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("idBook"));

                i++;
            }

            return models;
        }
        catch (Exception e) {
            this.logger.error("Failed to find: " + e.getMessage());
        }

        return null;
    }

    @Override
    public AuthorModel findId(int id) {
        this.logger.debug("Find Id");

        try {
            final ResultSet result = this.database.executeQuery(""
                    + "SELECT "
                    + "id, "
                    + "name, "
                    + "idBook "
                    + "FROM " + this.table + " "
                    + "WHERE id=" + id + ""
                    + ";");

            if (result.next()) {
                return new AuthorModel(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("idBook"));
            }
        }
        catch (Exception e) {
            this.logger.error("Failed to find id: " + e.getMessage());
        }

        return null;
    }

    public AuthorExtendModel[] findExtend() {
        this.logger.debug("Find Extend");

        try {
            final int total = this.database.tableTotal(this.table);
            final ResultSet result = this.database.executeQuery(""
                    + "SELECT "
                    + "author.id, "
                    + "author.name, "
                    + "author.idBook, "
                    + "book.id, "
                    + "book.title, "
                    + "book.description "
                    + "FROM author "
                    + "INNER JOIN book ON author.idBook=book.id"
                    + ";");

            final AuthorExtendModel[] models = new AuthorExtendModel[total];

            int i = 0;
            while (result.next()) {
                models[i] = new AuthorExtendModel(
                        result.getInt("author.id"),
                        result.getString("author.name"),
                        result.getInt("author.idBook"),
                        new BookModel(
                                result.getInt("book.id"),
                                result.getString("book.title"),
                                result.getString("book.description")));

                i++;
            }

            return models;
        }
        catch (Exception e) {
            this.logger.error("Failed to find extend: " + e.getMessage());
        }

        return null;
    }

    public AuthorExtendModel findIdExtend(int id) {
        this.logger.debug("Find Id Extend");

        try {
            final ResultSet result = this.database.executeQuery(""
                    + "SELECT "
                    + "author.id, "
                    + "author.name, "
                    + "author.idBook, "
                    + "book.id, "
                    + "book.title, "
                    + "book.description "
                    + "FROM author "
                    + "INNER JOIN book ON author.idBook=book.id "
                    + "WHERE author.id=" + id + ""
                    + ";");

            if (result.next()) {
                return new AuthorExtendModel(
                        result.getInt("author.id"),
                        result.getString("author.name"),
                        result.getInt("author.idBook"),
                        new BookModel(
                                result.getInt("book.id"),
                                result.getString("book.title"),
                                result.getString("book.description")));
            }
        }
        catch (Exception e) {
            this.logger.error("Failed to find id extend: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void add(AuthorModel model) {
        this.logger.debug("Add");

        try {
            this.database.executeUpdate(""
                    + "INSERT INTO " + this.table + " ("
                    + "name, "
                    + "idBook"
                    + ") VALUES ("
                    + "'" + model.getName() + "', "
                    + "'" + model.getIdBook() + "'"
                    + ");");
        }
        catch (Exception e) {
            this.logger.error("Failed to add: " + e.getMessage());
        }
    }

    @Override
    public void change(int id, AuthorModel model) {
        this.logger.debug("Change");

        try {
            this.database.executeUpdate(""
                    + "UPDATE " + this.table + " SET "
                    + "name='" + model.getName() + "', "
                    + "idBook='" + model.getIdBook() + "' "
                    + "WHERE "
                    + "id=" + id + ""
                    + ";");
        }
        catch (Exception e) {
            this.logger.error("Failed to change: " + e.getMessage());
        }
    }
}
