package interfaces;

public interface ServiceFindExtendInterface<ModelExtendType> {
    public ModelExtendType[] findExtend();

    public ModelExtendType findIdExtend(int id);
}
