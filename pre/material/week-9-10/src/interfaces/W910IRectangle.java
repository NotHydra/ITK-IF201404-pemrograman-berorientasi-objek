package interfaces;

public class W910IRectangle implements W910IShape {
    private int length;
    private int width;

    public W910IRectangle(int length, int width) {
        this.length = length;
        this.width = width;
    };

    public double GetArea() {
        return (double) this.length * (double) this.width;
    };

    public String ToString() {
        return "Rectangle (" + this.length + ", " + this.width + ")";
    };
}
