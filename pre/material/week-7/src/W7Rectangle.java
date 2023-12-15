public class W7Rectangle extends W7Shape {
    private int length;
    private int width;

    public W7Rectangle(String color, int length, int width) {
        super(color);

        this.length = length;
        this.width = width;
    };

    @Override
    public double GetArea() {
        return (double) this.length * (double) this.width;
    };

    @Override
    public String ToString() {
        return "Rectangle (" + this.length + ", " + this.width + ")";
    };
}
