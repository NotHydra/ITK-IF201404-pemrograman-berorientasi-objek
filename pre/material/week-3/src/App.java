import get_set.GetSet;
import overloading.Overloading;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(Overloading.average(10, 4));
        System.out.println(Overloading.average(10, 4, 6));
        System.out.println(Overloading.average(10, 4, 6, 9));

        System.out.println(GetSet.getName());
        GetSet.setName("Name 2");
        System.out.println(GetSet.getName());
    }
}
