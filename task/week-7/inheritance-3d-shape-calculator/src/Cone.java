import java.util.ArrayList;

public class Cone extends GeometricShape {
    private float radius;
    private float height;

    public static final ArrayList<Cone> history = new ArrayList<Cone>();

    public Cone(float radius, float height) {
        super(history.size() + 1, "Green");

        this.radius = radius;
        this.height = height;

        history.add(this);
    }

    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getVolume() {
        return (float) ((float) Math.PI * (float) Math.pow(this.radius, 2) * (this.height / 3.0f));
    }

    public float getSurfaceArea() {
        return (float) ((float) Math.PI * this.radius * (this.radius + (float) Math.sqrt(Math.pow(this.height, 2) + (float) Math.pow(this.radius, 2))));
    }

    public String toString() {
        return "Radius: " + this.radius + " - Height: " + this.height + " - Volume: " + this.getVolume() + " - Surface Area: " + this.getSurfaceArea();
    }
}
