package abstraction;

public class W910ARectangle extends W910AShape {
    private int length;
    private int width;

    public W910ARectangle(String color, int length, int width) {
        super(color);

        this.length = length;
        this.width = width;
    };

    public double GetArea() {
        return (double) this.length * (double) this.width;
    };

    @Override
    public String ToString() {
        return "Rectangle (" + this.length + ", " + this.width + ")";
    };
}
