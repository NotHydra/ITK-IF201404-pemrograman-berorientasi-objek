package services;

public interface ExtendService<ModelExtendType> {
    public ModelExtendType[] getExtend();

    public ModelExtendType getOneExtend(int id);
}
