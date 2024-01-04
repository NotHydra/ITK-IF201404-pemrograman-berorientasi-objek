import controllers.MainController;
import models.MahasiswaModel;
import services.MahasiswaService;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        MahasiswaService mahasiswaService = new MahasiswaService();

        mahasiswaService.remove(7);

        for (MahasiswaModel mahasiswa : mahasiswaService.get()) {
            System.out.println(mahasiswa);
        }
    };
}
