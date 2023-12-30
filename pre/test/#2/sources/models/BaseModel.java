package models;

public abstract class BaseModel<SchemaType> {
    public abstract SchemaType[] get();

    public abstract SchemaType getOne(int id);

    public abstract void add(SchemaType schema);

    public abstract void add(SchemaType[] schemas);

    public abstract void change(int id, SchemaType schema);

    public abstract void remove(int id);
}
