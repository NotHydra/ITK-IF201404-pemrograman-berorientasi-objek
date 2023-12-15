package overloading;
public class W3Overloading {
    public static float average(int firstValue, int secondValue) {
        return (float) ((firstValue + secondValue) / 2);
    };

    public static float average(int firstValue, int secondValue, int thirdValue) {
        return (float) ((firstValue + secondValue + thirdValue) / 3);
    };

    public static float average(int firstValue, int secondValue, int thirdValue, int fourthValue) {
        return (float) ((firstValue + secondValue + thirdValue + fourthValue) / 4);
    };
}
