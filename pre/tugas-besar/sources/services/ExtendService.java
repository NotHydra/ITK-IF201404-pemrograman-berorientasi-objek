package services;

public interface ExtendService<ModelType> {
    public ModelType[] getExtend();

    public ModelType getOneExtend(int id);
}
