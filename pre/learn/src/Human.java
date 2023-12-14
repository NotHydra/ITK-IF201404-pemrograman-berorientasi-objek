public class Human {
    String name;
    int age;
    int height;
    int weight;

    static int count = 0;

    Human(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;

        count += 1;
    };

    static void displayCount() {
        System.out.println("There is a total of 3 human object");
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
