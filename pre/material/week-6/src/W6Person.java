public class W6Person {
    private String name;
    private String address;

    public W6Person(String name, String address) {
        this.name = name;
        this.address = address;
    };

    public String GetName() {
        return this.name;
    };

    public String GetAddress() {
        return this.address;
    };

    public void SetAddress(String address) {
        this.address = address;
    };

    public String ToString() {
        return this.GetName() + "(" + this.GetAddress() + ")";
    };
}
