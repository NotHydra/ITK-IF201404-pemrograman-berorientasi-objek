package interfaces;

import models.base.BaseModel;

public interface ServiceFindInterface<ModelType extends BaseModel> {
    public ModelType[] find();

    public ModelType findId(int id);
}
