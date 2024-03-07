public class GeometricShape {
    private final int id;
    private String color;

    public GeometricShape(int id, String color) {
        this.id = id;
        this.color = color;
    }

    public int getId() {
        return this.id;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Color: " + this.color;
    }
}
