public class Learn {
    public static void main(String[] args) throws Exception {

        // Human[] humans = {
        // new Human("Human 1", 17, 185, 80),
        // new Human("Human 2", 18, 170, 50),
        // new Human("Human 3", 20, 175, 65),
        // };

        // for (Human human : humans) {
        // human.data();
        // System.out.println();
        // }

        LStudent[] students = {
                new LStudent("Student 1", 13, 150, 50, LUtility.randomGrades()),
                new LStudent("Student 2", 15, 165, 60, LUtility.randomGrades()),
                new LStudent("Student 3", 15, 160, 55, LUtility.randomGrades()),
                new LStudent("Student 4", 12, 140, 40, LUtility.randomGrades()),
        };

        for (LStudent student : students) {
            System.out.println("Name    : " + student.getName());
            System.out.println("Grade   :");
            student.displayGrade();

            System.out.println("Average : " + student.getAverage());
            System.out.println("Index   : " + student.getIndex());
            System.out.println();

            student.setGrades(LUtility.randomGrades());

            System.out.println("Grade   :");
            student.displayGrade();

            System.out.println("Average : " + student.getAverage());
            System.out.println("Index   : " + student.getIndex());
            System.out.println();
        }
    }
}
