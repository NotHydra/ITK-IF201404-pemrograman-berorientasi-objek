package relationship;

public class W2Person extends W2Address {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public W2Person(
            String name,
            String phoneNumber,
            String emailAddress,
            String street,
            String city,
            String state,
            int postalCode,
            String country) {
        super(street, city, state, postalCode, country);

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public void purchaseParkingPass() {
        System.out.println("Parking pass purchased");
    }
}
