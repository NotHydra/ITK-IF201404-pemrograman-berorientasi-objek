import get_set.W3GetSet;
import overloading.W3Overloading;

public class W3App {
    public static void main(String[] args) throws Exception {
        System.out.println(W3Overloading.average(10, 4));
        System.out.println(W3Overloading.average(10, 4, 6));
        System.out.println(W3Overloading.average(10, 4, 6, 9));

        System.out.println(W3GetSet.getName());
        W3GetSet.setName("Name 2");
        System.out.println(W3GetSet.getName());
    }
}
