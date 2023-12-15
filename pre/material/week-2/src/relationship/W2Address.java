package relationship;

public class W2Address {
    private String street;
    private String city;
    private String state;
    private int postalCode;
    private String country;

    public W2Address(
            String street,
            String city,
            String state,
            int postalCode,
            String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    };

    public void Validate() {
        System.out.println("Validated");
    }

    public void OutputAsLabel() {
        System.out.println("Outputed as label");
    }
};
