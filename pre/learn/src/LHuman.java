public class LHuman {
    private static int count = 0;

    private String name;
    private int age;
    private int height;
    private int weight;

    LHuman(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;

        count += 1;
    };

    static void displayCount() {
        System.out.println("There is a total of " + count + " human object");
    }

    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }

    int getHeight() {
        return this.height;
    }

    int getWeight() {
        return this.weight;
    }

    void greet() {
        System.out.println(
                "Hello my name is " + this.name + ", my age is " + this.age + " and my BMI is " + this.getBMI());
    }

    void data() {
        System.out.println("Name   : " + this.name);
        System.out.println("Age    : " + this.age);
        System.out.println("Height : " + this.height);
        System.out.println("Weight : " + this.weight);
        System.out.println("BMI    : " + this.getBMI());

    }

    float getBMI() {
        return (((float) this.weight) / (((float) this.height / 100) * ((float) this.height / 100)));
    }
};
