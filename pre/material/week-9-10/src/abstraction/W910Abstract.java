package abstraction;

public class W910Abstract {
    public static void main(String[] args) throws Exception {
        W910ARectangle rectangle1 = new W910ARectangle("Red", 4, 3);

        W910ATriangle triangle1 = new W910ATriangle("Red", 4, 3);

        System.out.println(rectangle1.GetArea());
        System.out.println(rectangle1.ToString());
        System.out.println();

        System.out.println(triangle1.GetArea());
        System.out.println(triangle1.ToString());
        System.out.println();
    }
}
