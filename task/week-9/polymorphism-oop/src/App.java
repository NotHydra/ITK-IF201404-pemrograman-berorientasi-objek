public class App {
    public static void main(String[] args) throws Exception {
        Contact contact1 = new Contact(1, "Name 1", "0812345678910", "email1@gmail.com");

        System.out.println(contact1);
        

        PersonalContact personalContact1 = new PersonalContact(2, "Name 2", "0812345678911", "email2@gmail.com", "Nickname 2");

        System.out.println(personalContact1);
    }
}
