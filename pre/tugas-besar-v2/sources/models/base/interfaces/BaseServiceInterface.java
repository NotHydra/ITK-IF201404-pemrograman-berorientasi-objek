package models.base.interfaces;

import models.base.BaseModel;

public interface BaseServiceInterface<ModelType extends BaseModel> {
    public void display();

    public abstract ModelType[] find();

    public abstract ModelType findId(int id);

    public abstract void add(ModelType model);

    public abstract void change(int id, ModelType model);

    public void remove(int id);

    public void truncate();
}
