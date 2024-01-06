import controllers.MainController;
import utilities.Format;
import models.MahasiswaExtendModel;
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
                for (MahasiswaExtendModel mahasiswa : mahasiswaService.getExtend()) {
                        System.out.println(Format.pretty(mahasiswa.toString()));
                }
        };
}
