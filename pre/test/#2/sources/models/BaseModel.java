package models;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class BaseModel<SchemaType> {
    public abstract ArrayList<SchemaType> get() throws SQLException;

    public abstract SchemaType getOne(int id) throws SQLException;

    public abstract void add(SchemaType schema) throws SQLException;

    public abstract void add(SchemaType[] schemas) throws SQLException;

    public abstract void change(int id, SchemaType schema) throws SQLException;

    public abstract void remove(int id) throws SQLException;
}
