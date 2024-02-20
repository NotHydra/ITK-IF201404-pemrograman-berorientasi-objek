public class App {
    public static void main(String[] args) throws Exception {
        Circle circle1 = new Circle(2.0, "blue");
        Circle circle2 = new Circle(4.0, "red");

        System.out.println(circle1);
        System.out.println(circle2);

        Cylinder cylinder1 = new Cylinder(2.0, "blue", 2.0);
        Cylinder cylinder2 = new Cylinder(4.0, "red", 4.0);

        System.out.println(cylinder1);
        System.out.println(cylinder2);

        cylinder1.setRadius(3.0);
        cylinder2.setRadius(5.0);

        System.out.println(cylinder1);
        System.out.println(cylinder2);
    }
}
