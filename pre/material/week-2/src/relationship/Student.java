package relationship;

public class Student extends Person {
    private int studentNumber;
    private float averageMark;

    public Student(
            String name,
            String phoneNumber,
            String emailAddress,
            String street,
            String city,
            String state,
            int postalCode,
            String country,
            int studentNumber,
            float averageMark) {
        super(name, phoneNumber, emailAddress, street, city, state, postalCode, country);

        this.studentNumber = studentNumber;
        this.averageMark = averageMark;
    }

    public void isEligibleToEnroll() {
        System.out.println("Is eligible");
    }

    public void getSeminarsTaken() {
        System.out.println("Seminars taken");
    }
}
