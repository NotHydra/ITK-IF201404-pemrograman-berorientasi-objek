import java.util.ArrayList;

public class Cube {
    private final int id;
    private float length;

    public static final ArrayList<Cube> history = new ArrayList<Cube>();
    
    public Cube(float length) {
        this.id = history.size() + 1;
        this.length = length;

        history.add(this);
    }

    public int getId() {
        return this.id;
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
