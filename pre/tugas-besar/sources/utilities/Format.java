package utilities;

public class Format {
    public static String pretty(String text) {
        StringBuilder result = new StringBuilder();
        int indentation = 0;

        for (char character : text.toCharArray()) {
            if (character != ' ') {
                if (character == '(') {
                    indentation++;
                    result.append(character).append("\n").append(" ".repeat(indentation * 4));
                } else if (character == ')') {
                    indentation--;
                    result.append("\n").append(" ".repeat(indentation * 4)).append(character);
                } else if (character == ',') {
                    result.append(character).append("\n").append(" ".repeat(indentation * 4));
                } else {
                    result.append(character);
                }
            }
        }

        return result.toString();
    }
}