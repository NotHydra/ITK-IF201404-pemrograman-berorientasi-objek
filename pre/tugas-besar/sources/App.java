import controllers.MainController;
import models.KelasModel;
import services.KelasService;

public class App {
        public static void main(String[] args) {
                // try {
                // MainController.initialize(args);
                // } catch (Exception e) {
                // e.printStackTrace();
                // }

                KelasService kelasService = new KelasService();
                for (KelasModel kelas : kelasService.get()) {
                        System.out.println(kelas);
                }
        };
}
