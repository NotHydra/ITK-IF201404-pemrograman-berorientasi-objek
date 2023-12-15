import java.util.Random;

public class Utility {
    public static Random random = new Random();

    public static int randomBetween(int start, int end) {
        return random.nextInt(end - start + 1) + start;
    }

    public static int[] randomGrades() {
        final int count = randomBetween(2, 5);
        final int[] grades = new int[count];
        for (int i = 0; i < count; i += 1) {
            grades[i] = randomBetween(45, 100);
        }

        return grades;
    }
}
