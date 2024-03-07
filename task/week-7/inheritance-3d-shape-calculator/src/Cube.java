import java.util.ArrayList;

public class Cube extends GeometricShape {
    private float length;

    public static final ArrayList<Cube> history = new ArrayList<Cube>();
    
    public Cube(float length) {
        super(history.size() + 1, "Red");

        this.length = length;

        history.add(this);
    }

    public float getLength() {
        return this.length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getVolume() {
        return (float) Math.pow(this.length, 3);
    }

    public float getSurfaceArea() {
        return 6.0f * (float) Math.pow(this.length, 2);
    }

    public String toString() {
        return "Length: " + this.length + " - Volume: " + this.getVolume() + " - Surface Area: " + this.getSurfaceArea();
    }
}
