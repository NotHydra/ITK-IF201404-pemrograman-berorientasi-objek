package relationship;

public class W2Professor extends W2Person {
    private int salary;

    public W2Professor(
            String name,
            String phoneNumber,
            String emailAddress,
            String street,
            String city,
            String state,
            int postalCode,
            String country,
            int salary) {
        super(name, phoneNumber, emailAddress, street, city, state, postalCode, country);

        this.salary = salary;
    };
}
