package services;

public interface ExtendService<ModelExtendType> {
    public default void displayExtend() {
        for (ModelExtendType modelExtend : this.getExtend()) {
            System.out.println(modelExtend);
            System.out.println();
        }
    };

    public ModelExtendType[] getExtend();

    public ModelExtendType getOneExtend(int id);
}
