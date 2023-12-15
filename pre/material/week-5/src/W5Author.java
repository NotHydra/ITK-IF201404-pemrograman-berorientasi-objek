public class W5Author {
    private String name;
    private String email;
    private char gender;

    public W5Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public char getGender() {
        return this.gender;
    }

    public String toString() {
        return "Author name is " + this.name +
                ", email is " + this.email +
                " and gender is " + ((this.gender == 'M') ? "Male" : "Female");
    }
}
