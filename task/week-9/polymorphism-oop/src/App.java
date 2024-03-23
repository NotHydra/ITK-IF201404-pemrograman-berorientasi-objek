public class App {
    public static void main(String[] args) throws Exception {
        Contact contact1 = new Contact(
                1,
                "Name 1",
                "0812345678910",
                "email1@gmail.com");

        System.out.println(contact1);

        PersonalContact personalContact1 = new PersonalContact(
                1,
                "Name 1",
                "0812345678910",
                "email1@gmail.com",
                "Nickname 1");

        System.out.println(personalContact1);

        Organization organization1 = new Organization(
                "Organization 1",
                "0812345678910",
                "email1@gmail.com");

        System.out.println(organization1);

        BusinessContact businessContact1 = new BusinessContact(
                1,
                "Name 1",
                "0812345678910",
                "email1@gmail.com",
                organization1);

        System.out.println(businessContact1);
    }
}
