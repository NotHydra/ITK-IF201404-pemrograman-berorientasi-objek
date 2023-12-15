package abstraction;

abstract public class W910AShape {
    private String color;

    public W910AShape(String color) {
        this.color = color;
    }

    abstract public double GetArea();

    public String ToString() {
        return "Shape (" + this.color + ")";
    };
}
