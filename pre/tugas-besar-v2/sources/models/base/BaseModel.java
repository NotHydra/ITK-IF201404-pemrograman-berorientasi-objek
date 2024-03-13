package models.base;

public abstract class BaseModel implements BaseModelInterface {
    protected final int id;

    public BaseModel() {
        this.id = -1;
    }

    public BaseModel(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public abstract String toString();
}
