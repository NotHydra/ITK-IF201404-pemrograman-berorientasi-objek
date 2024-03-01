public class Publisher {
    private int id;
    private String name;
    private String address;

    public Publisher(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Publisher("
            + "id=" + this.id + ", " 
            + "name=" + this.name + ", "
            + "address=" + this.address
            + ")";
    }
}
