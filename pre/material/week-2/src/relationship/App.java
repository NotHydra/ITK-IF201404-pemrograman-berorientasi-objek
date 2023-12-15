package relationship;

public class App {
    public static void main(String[] args) throws Exception {
        Student student1 = new Student(
                "Student 1",
                "Phone Number 1",
                "Email Address 1",
                "Street 1",
                "City 1",
                "State 1",
                1,
                "Country 1",
                1,
                87);

        Professor professor1 = new Professor(
                "Professor 2",
                "Phone Number 2",
                "Email Address 2",
                "Street 2",
                "City 2",
                "State 2",
                2,
                "Country 2",
                5_000_000);

        student1.Validate();
        professor1.Validate();

    }
}
