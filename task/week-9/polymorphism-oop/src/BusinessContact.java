public class BusinessContact extends Contact {
    private Organization organization;

    public BusinessContact(int id, String name, String phone, String email, Organization organization) {
        super(id, name, phone, email);

        this.organization = organization;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getObjectType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "BusinessContact("
                + "id=" + this.getId() + ", "
                + "name=\"" + this.getName() + "\", "
                + "phoneNumber=\"" + this.getPhoneNumber() + "\", "
                + "email=\"" + this.getEmail() + "\", "
                + "organization=" + this.organization
                + ")";
    }
}
