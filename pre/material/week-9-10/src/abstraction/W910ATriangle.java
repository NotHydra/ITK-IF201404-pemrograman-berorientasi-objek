package abstraction;

public class W910ATriangle extends W910AShape {
    private int base;
    private int height;

    public W910ATriangle(String color, int length, int width) {
        super(color);

        this.base = length;
        this.height = width;
    };

    public double GetArea() {
        return (double) this.base * (double) this.height * (double) 1 / 2;
    };

    public String ToString() {
        return "Triangle (" + this.base + ", " + this.height + ")";
    };
}
