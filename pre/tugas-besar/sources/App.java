
// import controllers.MainController;

import java.util.HashMap;

import services.MahasiswaService;

public class App {
	public static void main(String[] args) {
		// try {
		// MainController.initialize(args);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		MahasiswaService mahasiswaService = new MahasiswaService();

		System.out.println(mahasiswaService.getOneSKS(6));
		System.out.println(mahasiswaService.getOneIPK(6));
	};
}
