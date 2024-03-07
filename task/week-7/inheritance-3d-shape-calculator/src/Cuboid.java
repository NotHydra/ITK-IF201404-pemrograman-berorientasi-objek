import java.util.ArrayList;

public class Cuboid extends GeometricShape {
    private float length;
    private float width;
    private float height;

    public static final ArrayList<Cuboid> history = new ArrayList<Cuboid>();

    public Cuboid(float length, float width, float height) {
        super(history.size() + 1, "Blue");

        this.length = length;
        this.width = width;
        this.height = height;

        history.add(this);
    }

    public float getLength() {
        return this.length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getVolume() {
        return this.length * this.width * this.height;
    }

    public float getSurfaceArea() {
        return 2.0f * (this.length * this.width + this.length * this.height + this.width * this.height);
    }

    public String toString() {
        return "Length: " + this.length + " - Width: " + this.width + " - Height: " + this.height + " - Volume: " + this.getVolume() + " - Surface Area: " + this.getSurfaceArea();
    }
}
