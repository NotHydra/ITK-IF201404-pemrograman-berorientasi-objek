package interfaces;

public class W910ITriangle implements W910IShape {
    private int base;
    private int height;

    public W910ITriangle(int length, int width) {
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
