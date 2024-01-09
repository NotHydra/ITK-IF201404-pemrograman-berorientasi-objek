
// import controllers.MainController;
import data.Generate;
import utilities.Password;

public class App {
	public static void main(String[] args) {
		// try {
		// MainController.initialize(args);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		Generate.start();

		String hashedPassword = Password.hash("123");
		System.out.println(Password.match("123", hashedPassword));
	};
}
