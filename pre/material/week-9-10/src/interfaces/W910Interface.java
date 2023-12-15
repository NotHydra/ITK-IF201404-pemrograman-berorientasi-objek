package interfaces;

public class W910Interface {
    public static void main(String[] args) throws Exception {
        W910IRectangle rectangle1 = new W910IRectangle(4, 3);
        W910ITriangle triangle1 = new W910ITriangle(4, 3);

        System.out.println(rectangle1.GetArea());
        System.out.println(rectangle1.ToString());
        System.out.println();

        System.out.println(triangle1.GetArea());
        System.out.println(triangle1.ToString());
        System.out.println();
    }
}
