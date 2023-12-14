public class Main {
    public static void main(String[] args) throws Exception {

        Human[] humans = {
                new Human("Human 1", 17, 185, 80),
                new Human("Human 2", 18, 170, 50),
                new Human("Human 3", 20, 175, 65),
        };

        for (Human human : humans) {
            human.greet();
            human.data();
            System.out.println();
        }

        Human.displayCount();
    }
}
