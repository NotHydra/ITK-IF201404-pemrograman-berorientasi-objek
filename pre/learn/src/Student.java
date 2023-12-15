public class Student extends Human {
    private static int count = 0;

    private int[] grades;

    Student(String name, int age, int height, int weight, int[] grades) {
        super(name, age, height, weight);

        this.grades = grades;

        count += 1;
    };

    static void displayCount() {
        System.out.println("There is a total of " + count + " student object");
    }

    int[] getGrades() {
        return this.grades;
    }

    @Override
    void greet() {
        System.out.println(
                "Hello my name is " + this.getName() + ", my age is " + this.getAge() + " and I'm a student");
    };

    void displayGrade() {
        for (int index = 0; index < this.grades.length; index += 1) {
            System.out.println((index + 1) + ". " + this.grades[index]);
        }
    };

    float getAverage() {
        int total = 0;

        for (int grade : grades) {
            total += grade;
        }

        return ((float) (total / grades.length));
    };

    String getIndex() {
        float average = getAverage();

        if (86 <= average && average <= 100) {
            return "A";
        } else if (76 <= average && average < 86) {
            return "B";
        } else if (66 <= average && average < 76) {
            return "B";
        } else if (56 <= average && average < 66) {
            return "C";
        } else if (46 <= average && average < 56) {
            return "D";
        } else if (0 <= average && average < 46) {
            return "E";
        }

        return "Not Valid";
    };
};
