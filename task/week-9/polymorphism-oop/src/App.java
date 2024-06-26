public class App {
	public static void main(String[] args) throws Exception {
		Contact contact1 = new Contact(
				1,
				"Name 1",
				"0812345678910",
				"email1@gmail.com");

		Contact contact2 = new Contact(
				2,
				"Name 2",
				"0812345678911",
				"email2@gmail.com");

		System.out.println(contact1);
		System.out.println(contact2);
		System.out.println();

		PersonalContact personalContact1 = new PersonalContact(
				1,
				"Name 1",
				"0812345678910",
				"email1@gmail.com",
				"Nickname 1");

		PersonalContact personalContact2 = new PersonalContact(
				2,
				"Name 2",
				"0812345678911",
				"email2@gmail.com",
				"Nickname 2");

		System.out.println(personalContact1);
		System.out.println(personalContact2);
		System.out.println();

		Organization organization1 = new Organization(
				"Organization 1",
				"0812345678910",
				"email1@gmail.com");

		Organization organization2 = new Organization(
				"Organization 2",
				"0812345678911",
				"email2@gmail.com");

		System.out.println(organization1);
		System.out.println(organization2);
		System.out.println();

		BusinessContact businessContact1 = new BusinessContact(
				1,
				"Name 1",
				"0812345678910",
				"email1@gmail.com",
				organization1);

		BusinessContact businessContact2 = new BusinessContact(
				2,
				"Name 2",
				"0812345678911",
				"email2@gmail.com",
				organization2);

		System.out.println(businessContact1);
		System.out.println(businessContact2);
		System.out.println();

		System.out.println("Polymorphism Test");
		Contact contact3 = new PersonalContact(
				3,
				"Name 3",
				"0812345678912",
				"email3@gmail.com",
				"Nickname 3");

		Contact contact4 = new BusinessContact(
				3,
				"Name 3",
				"0812345678912",
				"email3@gmail.com",
				organization1);

		System.out.println(contact3);
		System.out.println(contact4);
	}
}
