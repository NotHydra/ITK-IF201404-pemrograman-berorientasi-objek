
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
		for (HashMap<String, Object> mahasiswa : mahasiswaService.getSKS()) {
			System.out.println(mahasiswa);
			System.out.println();
		}
	};
}
