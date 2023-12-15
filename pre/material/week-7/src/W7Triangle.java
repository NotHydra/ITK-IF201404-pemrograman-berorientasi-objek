public class W7Triangle extends W7Shape {
    private int base;
    private int height;

    public W7Triangle(String color, int length, int width) {
        super(color);

        this.base = length;
        this.height = width;
    };

    @Override
    public double GetArea() {
        return (double) this.base * (double) this.height * (double) 1 / 2;
    };

    @Override
    public String ToString() {
        return "Triangle (" + this.base + ", " + this.height + ")";
    };
}
