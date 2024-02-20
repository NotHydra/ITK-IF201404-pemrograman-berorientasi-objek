public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSurfaceArea() {
        return 2 * Math.PI * this.radius * (this.radius + this.height);
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Cylinder["
            + "radius=" + this.getRadius() + ", "
            + "height=" + this.height + ", "
            + "color=" + this.getColor() + ", "
            + "surfaceArea=" + this.getSurfaceArea() + ", "
            + "volume=" + this.getVolume()
            + "]";
    }
}
