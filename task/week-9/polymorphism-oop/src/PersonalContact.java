public class PersonalContact extends Contact {
    private String nickname;

    public PersonalContact(int id, String name, String phone, String email, String nickname) {
        super(id, name, phone, email);
        this.nickname = nickname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getObjectType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "PersonalContact("
                + "id=" + this.getId() + ", "
                + "name=\"" + this.getName() + "\", "
                + "phoneNumber=\"" + this.getPhoneNumber() + "\", "
                + "email=\"" + this.getEmail() + "\", "
                + "nickname=\"" + this.nickname + "\""
                + ")";
    }
}
