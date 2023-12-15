package relationship;

public class W2Relationship {
    public static void main(String[] args) throws Exception {
        W2Student student1 = new W2Student(
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

        W2Professor professor1 = new W2Professor(
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
