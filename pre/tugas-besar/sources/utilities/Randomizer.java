package utilities;

import java.util.Random;

public class Randomizer {
    private static final Random random = new Random();

    public static <Type> Type pickArray(Type[] array) {
        final int randomIndex = random.nextInt(array.length);

        return array[randomIndex];
    }

    
}
