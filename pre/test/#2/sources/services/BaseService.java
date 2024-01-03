package services;

public abstract class BaseService<ModelType> {
    public abstract ModelType[] get();

    public abstract ModelType getOne(int id);

    public abstract void add(ModelType model);

    public abstract void add(ModelType[] models);

    public abstract void change(int id, ModelType model);

    public abstract void remove(int id);
}
