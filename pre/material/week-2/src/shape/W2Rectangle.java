package shape;

public class W2Rectangle {
    private int width;
    private int height;

    public W2Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double distance() {
        return (double) (this.width * this.height);
    }
}
