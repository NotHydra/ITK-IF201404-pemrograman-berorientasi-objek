public class W7App {
    public static void main(String[] args) throws Exception {
        W7Rectangle rectangle1 = new W7Rectangle("Red", 4, 3);
        W7Shape rectangle2 = new W7Rectangle("Blue", 3, 4);

        W7Triangle triangle1 = new W7Triangle("Red", 4, 3);
        W7Shape triangle2 = new W7Triangle("Blue", 3, 4);

        System.out.println(rectangle1.GetArea());
        System.out.println(rectangle1.ToString());
        System.out.println();

        System.out.println(rectangle2.GetArea());
        System.out.println(rectangle2.ToString());
        System.out.println();

        System.out.println(triangle1.GetArea());
        System.out.println(triangle1.ToString());
        System.out.println();

        System.out.println(triangle2.GetArea());
        System.out.println(triangle2.ToString());
        System.out.println();
    }
}
